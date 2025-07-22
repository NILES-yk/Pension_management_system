package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.NurseItemDTO;
import com.cqupt.mapper.NurseContentMapper;
import com.cqupt.mapper.NurseLevelItemMapper;
import com.cqupt.pojo.NurseContent;
import com.cqupt.service.NurseContentService;
import com.cqupt.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class NurseContentServiceImpl extends ServiceImpl<NurseContentMapper, NurseContent> implements NurseContentService {

    @Autowired
    private NurseContentMapper nurseContentMapper;

    @Autowired
    private NurseLevelItemMapper nurseLevelItemMapper;

    @Override
    public ResultVo<List<NurseContent>> listNurseItemByLevel(Integer levelId) throws Exception {
        if(levelId==null){
            throw new Exception("护理级别ID不得为空");
        }
        //1.查询级别的项目配置 只查询item_id
        QueryWrapper qw=new QueryWrapper();
        qw.eq("level_id",levelId);
        qw.select("item_id");
        List<Integer>itemIds=nurseLevelItemMapper.selectObjs(qw); //返回对象列表
        //select item_id from nurse_level_item where level_id=levelId
        List<NurseContent>nurseContentList=new ArrayList<>();
        //2.判断是否有记录
        if(itemIds.size()>0){
            //3.查询护理项目信息
            nurseContentList=nurseContentMapper.selectBatchIds(itemIds); //批量查询
        }
        return ResultVo.success(nurseContentList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo updateNurseItem(NurseContent nurseContent) throws Exception {
        if(nurseContent==null){
            throw new Exception("护理内容不得为空");
        }
        //如果修改状态为停用，需要直接剔除护理级别护理项目列表中的对应记录，保证列表中的项目都是可用状态
        if(nurseContent.getStatus()==2){
            //查询当前护理项目是否在护理级别护理项目列表中，如果在就需要删除
            QueryWrapper qwCount=new QueryWrapper();
            qwCount.eq("item_id",nurseContent.getId());
            //select count(*) from nurse_content where item_id=nurseContent.getId()
            int count=nurseLevelItemMapper.selectCount(qwCount);
            if(count>0){
                QueryWrapper qw=new QueryWrapper();
                qw.eq("item_id",nurseContent.getId());
                int row=nurseLevelItemMapper.delete(qw);
                //更新护理项目
                boolean result=updateById(nurseContent);
                if(!(row>0&&result)){
                    throw new Exception("更新失败");
                }
                return ResultVo.success("更新成功");
            }
        }
        //若不停用则直接更新护理项目
        updateById(nurseContent);
        return ResultVo.success("更新成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo delNurseItem(Integer id) throws Exception {
        if(id==null){
            throw new Exception("主键不得为空");
        }
        NurseContent nurseContent=new NurseContent();
        nurseContent.setId(id);
        nurseContent.setIsDeleted(1);
        //查询当前护理项目是否在nurse_level_item表中
        QueryWrapper qwCount=new QueryWrapper();
        qwCount.eq("item_id",id);
        int count=nurseLevelItemMapper.selectCount(qwCount);
        if(count>0){
            QueryWrapper qw=new QueryWrapper();
            qw.eq("item_id",id);
            int row=nurseLevelItemMapper.delete(qw);
            //更新逻辑标志为1
            boolean flag=updateById(nurseContent);
            if(!(flag&&row>0)){
                throw new Exception("删除失败");
            }
            return ResultVo.success("删除成功");
        }
        //更新逻辑标志为1
        updateById(nurseContent);
        return ResultVo.success("删除成功");
    }

    @Override
    public ResultVo<Page<NurseContent>> listNurseItemPage(NurseItemDTO nurseItemDTO)throws Exception{
        if(nurseItemDTO==null){
            throw new Exception("参数不得为空");
        }
        Page<NurseContent>p=new Page<>(nurseItemDTO.getPageSize(),6);
        //查询 直接使用wrapper而不在xml文件中定义sql语句
        QueryWrapper qw=new QueryWrapper();
        if(nurseItemDTO.getNursingName()!=null&&nurseItemDTO.getNursingName()!=""){
            qw.like("nursing_name","%"+nurseItemDTO.getNursingName()+"%");
        }
        if(nurseItemDTO.getStatus()!=null){
            qw.eq("status",nurseItemDTO.getStatus());
        }
        qw.eq("is_deleted",0);
        //select * from nurse_content where is_deleted=0 and status=? and nursing_name like ? limit 1,getPageSize
        page(p,qw);
        return ResultVo.success(p);
    }
}
