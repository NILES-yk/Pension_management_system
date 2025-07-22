package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.CustomerInfoDTO;
import com.cqupt.pojo.Customer;
import com.cqupt.service.CustomerService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Api(tags="顾客信息管理")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    @ApiOperation("入住登记")
    public ResultVo addCustomer(Customer customer)throws Exception{
        customerService.addCustomer(customer);
        return ResultVo.success("添加成功");
    }

    @GetMapping("/listCustomerInfoPage")
    @ApiOperation("客户信息动态分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageSize",
                    value="页码",
                    dataType ="int",
                    paramType = "query",
                    required = true),
    })
    public ResultVo<Page<CustomerInfoVo>> listCustomerInfoPage(CustomerInfoDTO customerInfoDTO)throws Exception{
        return customerService.findCustomerInfo(customerInfoDTO);
    }

    @GetMapping("/remove")
    @ApiOperation("删除客户信息 根据key删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",
                    value="主键",
                    dataType = "int",
                    paramType = "query",
                    required = true)
    })
    public ResultVo removeCustomer(Integer id,Integer bedId)throws Exception{
        customerService.removeCustomer(id,bedId);
        return ResultVo.success("删除成功");
    }

    @PostMapping("/editCustomerInfo")
    @ApiOperation("编辑客户信息")
    public ResultVo editCustomerInfo(Customer customer)throws Exception{
        customerService.editCustomer(customer);
        return ResultVo.success("编辑成功");
    }

}
