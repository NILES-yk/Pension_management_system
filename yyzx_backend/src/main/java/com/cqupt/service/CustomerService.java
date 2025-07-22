package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.CustomerInfoDTO;
import com.cqupt.pojo.Customer;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerInfoVo;


public interface CustomerService extends IService<Customer> {
    ResultVo addCustomer(Customer customer)throws Exception;

    ResultVo<Page<CustomerInfoVo>> findCustomerInfo(CustomerInfoDTO customerInfoDTO)throws Exception;

    ResultVo removeCustomer(Integer id,Integer bedId)throws Exception;

    ResultVo editCustomer(Customer customer)throws Exception;
}
