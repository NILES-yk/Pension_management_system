package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.NurseRecordDTO;
import com.cqupt.dto.OutwardDTO;
import com.cqupt.pojo.NurseRecord;
import com.cqupt.service.NurseRecordService;
import com.cqupt.service.OutwardService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.NurseRecordVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nurseRecord")
@Api(tags="护理记录管理")
@CrossOrigin
public class NurseRecordController {
    @Autowired
    private NurseRecordService nurseRecordService;

    @Autowired
    private OutwardService outwardService;

    @GetMapping("/listNurseRecord")
    @ApiOperation("护理记录动态分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="pageSize",value = "页码",required = true),
            @ApiImplicitParam(dataType = "int",name = "customerId",value = "客户ID",required = true)
    })
    public ResultVo<Page<NurseRecordVo>> listNurseRecordVo(NurseRecordDTO nurseRecordDTO) throws Exception {
        return nurseRecordService.queryNurseRecordPage(nurseRecordDTO);
    }

    @PostMapping("/addNurseRecord")
    @ApiOperation("生成护理记录")
    public ResultVo addNurseRecord(NurseRecord nurseRecord) throws Exception {
        return nurseRecordService.addNurseRecord(nurseRecord);
    }

    @GetMapping("/removeNurseRecord")
    @ApiOperation("移除护理记录")
    public ResultVo removeNurseRecord(Integer id) throws Exception {
        NurseRecord nurseRecord =new NurseRecord();
        nurseRecord.setIsDeleted(1);
        nurseRecord.setId(id);
        //update nurse_record set is_deleted=1 where id=?
        nurseRecordService.updateById(nurseRecord);
        return ResultVo.success("移除成功");
    }

    @GetMapping("/queryOutwardVo")
    @ApiOperation("查询外出记录")
    public ResultVo queryOutwardVo(OutwardDTO outwardDTO) throws Exception {
        return outwardService.queryOutwardPage(outwardDTO);
    }

}
