package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.Customer;
import com.cqupt.vo.CustomerInfoVo;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper extends BaseMapper<Customer> {
    Page<CustomerInfoVo>selectCustomerVo(@Param("page")Page<CustomerInfoVo> page,
                                         @Param("customerName")String customerName,
                                         @Param("oldType")Integer oldType,
                                         @Param("userId")Integer userId);
}
