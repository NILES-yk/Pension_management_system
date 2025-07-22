package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.OutwardDTO;
import com.cqupt.mapper.OutwardMapper;
import com.cqupt.pojo.Outward;
import com.cqupt.service.OutwardService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.OutwardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OutwardServiceImpl extends ServiceImpl<OutwardMapper, Outward>implements OutwardService {
    @Autowired
    OutwardMapper outwardMapper;

    @Override
    public ResultVo<Page<OutwardVo>> queryOutwardPage(OutwardDTO outwardDTO)throws Exception{
        Page<OutwardVo>page=new Page<>(outwardDTO.getPageSize(),6);
        outwardMapper.selectOutwardPage(page,outwardDTO.getUserId());
        return ResultVo.success(page);
    }

    //审批外出
    @Override
    public ResultVo examineOutward(Outward outward)throws Exception{
        //审批状态更新
        UpdateWrapper uw=new UpdateWrapper();
        uw.eq("id",outward.getId());
        uw.set("audit_status",outward.getAuditStatus());
        outwardMapper.update(null,uw);
        return ResultVo.success("审批完成");
    }

    //撤销外出登记
    @Override
    public ResultVo delOutward(Integer id)throws Exception{
        UpdateWrapper uw=new UpdateWrapper();
        uw.eq("id",id);
        uw.set("is_deleted",1);
        outwardMapper.update(null,uw);
        return ResultVo.success("撤销完成");
    }

    //登记回院时间
    public ResultVo updateBackTime(Outward outward)throws Exception{
        UpdateWrapper uw=new UpdateWrapper();
        uw.eq("id",outward.getId());
        uw.set("actual_return_time",outward.getActualReturnTime());
        outwardMapper.update(outward,uw);
        return ResultVo.success("登记完成");
    }

}
