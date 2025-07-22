package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.NurseRecordDTO;
import com.cqupt.mapper.CustomerNurseItemMapper;
import com.cqupt.mapper.NurseRecordMapper;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.pojo.NurseRecord;
import com.cqupt.service.NurseRecordService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.NurseRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NurseRecordServiceImpl extends ServiceImpl<NurseRecordMapper, NurseRecord> implements NurseRecordService {
    @Autowired
    private NurseRecordMapper nurseRecordMapper;
    @Autowired
    private CustomerNurseItemMapper customerNurseItemMapper;

    @Override
    public ResultVo<Page<NurseRecordVo>>queryNurseRecordPage(NurseRecordDTO nurseRecordDTO)throws Exception{
        Page<NurseRecordVo>page=new Page<>(nurseRecordDTO.getPageSize(),6);
        //查询
        nurseRecordMapper.selectNurseRecordVo(page,nurseRecordDTO.getCustomerId());
        return ResultVo.success(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo addNurseRecord(NurseRecord nurseRecord)throws Exception{
        //生成护理记录
        nurseRecord.setIsDeleted(0);
        //存储护理记录
        boolean flag=save(nurseRecord);
        //查询用户当前护理项目的余量
        QueryWrapper qw=new QueryWrapper();
        qw.eq("customer_id",nurseRecord.getCustomerId());
        qw.eq("item_id",nurseRecord.getItemId());
        qw.eq("is_deleted",0);
        CustomerNurseItem customerNurseItem=new CustomerNurseItem();
        //修改客户护理项目的数量
        UpdateWrapper uw=new UpdateWrapper();
        //余量-当前护理使用数量
        uw.set("nurse_number",customerNurseItem.getNurseNumber()-nurseRecord.getNursingCount());
        uw.eq("customer_id",nurseRecord.getCustomerId());
        uw.eq("item_id",nurseRecord.getItemId());
        uw.eq("is_deleted",0);
        //update customer_nurse_item set nurse_number=? where customer_id=? and item_id=? and is_deleted=0
        int row=customerNurseItemMapper.update(null,uw);
        if(!(flag&&row>0)){
           throw new Exception("生成护理项目失败");
        }
        return ResultVo.success("护理记录生成成功");
    }
}
