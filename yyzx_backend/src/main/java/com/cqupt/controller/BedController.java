package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqupt.pojo.Bed;
import com.cqupt.service.BedService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/bed")
@Api(tags="床位管理")
@CrossOrigin
public class BedController {

    @Autowired
    private BedService bedService;

    @GetMapping("/findBed")
    @ApiOperation("查询床位详情")
    public ResultVo<List<Bed>> findBed(Bed bed){
        // 查询条件的包装器
        QueryWrapper queryWrapper = new QueryWrapper();
        if (bed.getRoomNo() != null) {
            queryWrapper.eq("room_no", bed.getRoomNo());
        }
        if (bed.getBedStatus() != null) {
            queryWrapper.eq("bed_status", bed.getBedStatus());
        }
        return ResultVo.success(bedService.list(queryWrapper));
    }
}
