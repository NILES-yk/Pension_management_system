package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqupt.pojo.NurseContent;
import com.cqupt.pojo.NurseLevel;
import com.cqupt.pojo.NurseLevelItem;
import com.cqupt.service.NurseContentService;
import com.cqupt.service.NurseLevelItemService;
import com.cqupt.service.NurseLevelService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/nurseLevel")
@Api(tags="护理级别管理")
@CrossOrigin
public class NurseLevelController {
    @Autowired
    private NurseLevelService nurseLevelService;

    @Autowired
    private NurseLevelItemService nurseLevelItemService;

    @Autowired
    private NurseContentService nurseContentService;

    @PostMapping("/addNurseLevel")
    @ApiOperation("添加护理级别")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name="levelName",value = "护理级别",required=true),
            @ApiImplicitParam(dataType = "int", name="levelStatus",value = "级别状态 1：启用；2：停用",required=true)
    })
    public ResultVo addNurseLevel(NurseLevel nurseLevel)throws Exception{
      nurseLevelService.save(nurseLevel);
      return ResultVo.success("护理级别添加成功");
    }

    @PostMapping("/updateNurseLevel")
    @ApiOperation("更新护理级别")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name="id",value = "主键",required=true),
            @ApiImplicitParam(dataType = "string", name="levelName",value = "护理级别",required=true)
    })
    public ResultVo updateNurseLevel(NurseLevel nurseLevel)throws Exception{
        nurseLevelService.updateById(nurseLevel);
        return ResultVo.success("护理级别更新成功");
    }

    @GetMapping("/removeNurseLevel")
    @ApiOperation("删除护理级别")
    public ResultVo removeNurseLevel(Integer id)throws Exception{
       nurseLevelService.removeById(id);
       return ResultVo.success("护理级别删除成功");
    }

    @GetMapping("/listNurseLevel")
    @ApiOperation("查询护理级别列表")
    public ResultVo listNurseLevel(NurseLevel nurseLevel)throws Exception{
        QueryWrapper qw=new QueryWrapper<>();
        if(nurseLevel.getLevelStatus()!=null){
            qw.eq("level_status",nurseLevel.getLevelStatus());
        }
        if(nurseLevel.getLevelName()!=null){
            qw.eq("level_name",nurseLevel.getLevelName());
        }
        return ResultVo.success(nurseLevelService.list(qw));
    }

    @GetMapping("/listItemToLevel")
    @ApiOperation("根据护理级别查询护理项目 不分页")
    public ResultVo<List<NurseContent>>listNurseItemByLevel(Integer levelId)throws Exception{
        return nurseContentService.listNurseItemByLevel(levelId);
    }

    @PostMapping("/addItemToLevel")
    @ApiOperation("护理项目的配置")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name="itemId",value = "关联护理项目ID",required=true),
            @ApiImplicitParam(dataType = "int", name="levelId",value = "关联护理级别ID",required=true)
    })
    public ResultVo addItemToLevel(NurseLevelItem nurseLevelItem)throws Exception{
        //判断当前级别是否存在相同的护理项目
        QueryWrapper qw=new QueryWrapper<>();
        qw.eq("level_id",nurseLevelItem.getLevelId());
        qw.eq("item_id",nurseLevelItem.getItemId());
        int count=nurseLevelItemService.count(qw);
        if(count>0){
            return ResultVo.fail("当前级别已存在相同项目");
        }
        nurseLevelItemService.save(nurseLevelItem);
        return ResultVo.success("添加成功");
    }

    @GetMapping("/removeNurseLevelItem")
    @ApiOperation("删除护理级别中的护理项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name="itemId",value = "关联护理项目ID",required=true),
            @ApiImplicitParam(dataType = "int", name="levelId",value = "关联护理级别ID",required=true)
    })
    public ResultVo removeNurseLevelItem(Integer levelId,Integer itemId)throws Exception{
        QueryWrapper qw=new QueryWrapper();
        qw.eq("level_id",levelId);
        qw.eq("item_id",itemId);
        nurseLevelItemService.remove(qw);
        return ResultVo.success("删除成功");
    }
}
