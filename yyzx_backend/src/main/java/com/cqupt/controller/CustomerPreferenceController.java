package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.CustomerPreferenceDTO;
import com.cqupt.pojo.CustomerPreference;
import com.cqupt.service.CustomerPreferenceService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerPreferenceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerPreference")
@Api(tags="顾客饮食喜好管理")
@CrossOrigin
public class CustomerPreferenceController {

    @Autowired
    private CustomerPreferenceService customerPreferenceService;

    @PostMapping("/addCustomerPreference")
    @ApiOperation("为单个客户添加客户喜好")
    @ApiImplicitParams({
            @ApiImplicitParam(name="customerId",
                    value="顾客ID",
                    dataType = "int",
                    paramType = "query",
                    required=true),
            @ApiImplicitParam(name="preferences",
                    value="饮食喜好",
                    dataType = "string",
                    paramType = "query",
                    required=true)
    })
    public ResultVo addCustomerPreference(CustomerPreference customerPreference)throws Exception{
        customerPreferenceService.save(customerPreference);
        return ResultVo.success("添加成功");
    }

    @PostMapping("/updateCustomerPreference")
    @ApiOperation("更新客户的喜好")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",
                    value="主键",
                    dataType = "int",
                    paramType = "query",
                    required=true

            ),
            @ApiImplicitParam(name="customerId",
                    value="顾客ID",
                    dataType = "int",
                    paramType = "query",
                    required=true)
    })
    public ResultVo updateCustomerPreference(CustomerPreference customerPreference)throws Exception{
        customerPreferenceService.updateById(customerPreference);
        return ResultVo.success("更新成功");
    }

    @GetMapping("removeCustomerPreference")
    @ApiOperation("删除客户喜好")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",
                    value="主键",
                    dataType = "int",
                    paramType = "query",
                    required=true)
    })
    public ResultVo removeCustomerPreference(Integer id)throws Exception{
        customerPreferenceService.removeById(id);
        return ResultVo.success("删除成功");
    }

    @GetMapping("/listPreferencePage")
    @ApiOperation("客户喜好动态分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize",
                    value = "页码",
                    dataType = "int",
                    paramType = "query",
                    required = true),
    })
    public ResultVo<Page<CustomerPreferenceVo>> listCustomerPreferenceVoPage(CustomerPreferenceDTO customerPreferenceDTO) throws Exception {
        return customerPreferenceService.listCustomerPreferenceVoPage(customerPreferenceDTO);
    }
}
