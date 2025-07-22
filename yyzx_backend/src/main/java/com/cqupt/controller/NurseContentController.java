package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.NurseItemDTO;
import com.cqupt.pojo.NurseContent;
import com.cqupt.service.NurseContentService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nurseContent")
@Api(tags="护理项目管理")
@CrossOrigin
public class NurseContentController {
    @Autowired
    private NurseContentService nurseContentService;

    @PostMapping("/addNurseItem")
    @ApiOperation("添加护理项目")
    public ResultVo addNurseItem(NurseContent nurseContent)throws Exception{
       nurseContentService.save(nurseContent);
       return ResultVo.success("插入成功");
    }

    @GetMapping("/findNurseItemPage")
    @ApiOperation("查询护理项目-分页")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="pageSize",value="页码",required=true)
    })
    public ResultVo<Page<NurseContent>>findNurseItemPage(NurseItemDTO nurseItemDTO)throws Exception{
        return ResultVo.success(nurseContentService.listNurseItemPage(nurseItemDTO));
    }

    @PostMapping("/updateNurseItem")
    @ApiOperation("修改护理项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="status",value="状态",required=true),
            @ApiImplicitParam(dataType = "int",name="id",value = "主键",required=true)
    })
    public ResultVo updateNurseItem(NurseContent nurseContent)throws Exception{
        return nurseContentService.updateNurseItem(nurseContent);
    }

    @GetMapping("/delNurseItem")
    @ApiOperation("删除护理项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="id",value="主键",required=true)
    })
    public ResultVo delNurseItem(Integer id)throws Exception{
        return nurseContentService.delNurseItem(id);
    }
}
