package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.dto.ExchangeDTO;
import com.cqupt.pojo.BedDetails;
import com.cqupt.service.BedDetailsService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedDetailsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bedDetails")
@Api(tags="床位详情管理")
@CrossOrigin
public class BedDetailsController {
    @Autowired
    private BedDetailsService bedDetailsService;

    @GetMapping("/listBedDetailsVoPage")
    @ApiOperation("床位的详细列表动态分页查询")
    public ResultVo<Page<BedDetailsVo>> listBedDetailsVoPage(BedDetailsDTO bedDetailsDTO)throws Exception{
        return bedDetailsService.listBedDetailsPage(bedDetailsDTO);
    }

    @PostMapping("/updateBedDetails")
    @ApiOperation("更新床位详情信息,只能修改床位的结束时间")
    public ResultVo updateBedDetails(BedDetails bedDetails)throws Exception{
        bedDetailsService.updateById(bedDetails);
        return ResultVo.success("修改成功");
    }

    @GetMapping("/deleteBedDetails")
    @ApiOperation("删除床位详情信息记录")
    public ResultVo deleteBedDetails(Integer id)throws Exception{
        bedDetailsService.removeById(id);
        return ResultVo.success("删除成功");
    }

    @PostMapping("/exchangeBed")
    @ApiOperation("床位调换")
    public ResultVo exchangeBed(ExchangeDTO exchangeDTO)throws Exception{
        return bedDetailsService.exchangeBed(exchangeDTO);
    }
}
