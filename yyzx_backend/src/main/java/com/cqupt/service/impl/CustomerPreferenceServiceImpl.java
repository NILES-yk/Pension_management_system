package com.cqupt.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.CustomerPreferenceDTO;
import com.cqupt.mapper.CustomerPreferenceMapper;
import com.cqupt.pojo.CustomerPreference;
import com.cqupt.service.CustomerPreferenceService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerPreferenceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerPreferenceServiceImpl extends ServiceImpl<CustomerPreferenceMapper, CustomerPreference> implements CustomerPreferenceService{

    @Autowired
    private CustomerPreferenceMapper customerPreferenceMapper;

    @Override
    public ResultVo<Page<CustomerPreferenceVo>> listCustomerPreferenceVoPage(CustomerPreferenceDTO customerPreferenceDTO) throws Exception {
        Page<CustomerPreferenceVo>page=new Page<>(customerPreferenceDTO.getPageSize(),6);
        //查询
        customerPreferenceMapper.selectCustomerPreferenceVo(page,customerPreferenceDTO.getCustomerName());
        return ResultVo.success(page);

    }
}
