package com.cqupt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.CustomerNurseItemDTO;
import com.cqupt.pojo.Customer;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.service.CustomerNurseItemService;
import com.cqupt.service.CustomerService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerNurseItemVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customerNurseItem")
@Api(tags="客户护理项目管理")
@CrossOrigin
public class CustomerNurseItemController {

    @Autowired
    private CustomerNurseItemService customerNurseItemService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addItemToCustomer")
    @ApiOperation("为顾客单个/批量添加护理项目")
    public ResultVo addItemToCustomer(@RequestBody List<CustomerNurseItem>customerNurseItemList)throws Exception{
        customerNurseItemService.addItemToCustomer(customerNurseItemList);
        return ResultVo.success("护理项目添加成功");
    }

    @GetMapping("/listCustomerItem")
    @ApiOperation("查询某个顾客的护理项目 分页")
    public ResultVo<Page<CustomerNurseItemVo>>listCustomerItem(CustomerNurseItemDTO customerNurseItemDTO)throws Exception{
        return ResultVo.success(customerNurseItemService.listCustomerNurseItemPage(customerNurseItemDTO));
    }

    @PostMapping("/enewNurseItem")
    @ApiOperation("客户续费")
    public ResultVo enewNurseItem(CustomerNurseItem customerNurseItem)throws Exception{
        customerNurseItemService.updateById(customerNurseItem);
        return ResultVo.success("续费成功");
    }

    @GetMapping("/isIncludesItemCustomer")
    @ApiOperation("判断客户是否已经配置了某个指定的项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="customerId",value="客户编号",required = true),
            @ApiImplicitParam(dataType = "int",name="itemId",value="护理项目编号",required = true)
    })
    public ResultVo isIncludesItemCustomer(Integer customerId,Integer itemId)throws Exception{
        return customerNurseItemService.selectIncludesItem(customerId,itemId);
    }

    @GetMapping("/removeCustomerItem")
    @ApiOperation("移除客户某个护理级别的所有项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name="levelId", value="护理级别ID", required=true),
            @ApiImplicitParam(dataType = "int", name="customerId", value="客户ID", required=true)
    })
    public ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId) throws Exception {
        // 1. 移除护理项目
        QueryWrapper<CustomerNurseItem> wrapper = new QueryWrapper<>();
        wrapper.eq("level_id", levelId)
                .eq("customer_id", customerId)
                .eq("is_deleted", 0);

        List<CustomerNurseItem> list = customerNurseItemService.list(wrapper);
        for (CustomerNurseItem item : list) {
            item.setIsDeleted(1);
            customerNurseItemService.updateById(item);
        }

        Customer customer = customerService.getById(customerId);
        customer.setLevelId(null);
        customerService.updateById(customer);

        return ResultVo.success("成功移除了" + list.size() + "个护理项目");

    }

}
