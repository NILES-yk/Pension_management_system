package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.OutwardDTO;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.pojo.Outward;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.OutwardVo;


public interface OutwardService extends IService<Outward> {
    //分页查询
    ResultVo<Page<OutwardVo>> queryOutwardPage(OutwardDTO outwardDTO)throws Exception;

    //审批外出
    ResultVo examineOutward(Outward outward)throws Exception;

    //撤销外出登记
    ResultVo delOutward(Integer id)throws Exception;

    //登记回院时间
    ResultVo updateBackTime(Outward outward)throws Exception;
}
