package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.BackdownDTO;
import com.cqupt.mapper.BackdownMapper;
import com.cqupt.pojo.Backdown;
import com.cqupt.service.BackdownService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BackdownVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BackdownServiceImpl extends ServiceImpl<BackdownMapper, Backdown> implements BackdownService {
    @Autowired
    BackdownMapper backdownMapper;

    @Override
    public ResultVo<Page<BackdownVo>> queryBackdownPage(BackdownDTO backdownDTO)throws Exception{
        Page<BackdownVo>page=new Page<>(backdownDTO.getPageSize(),6);
        backdownMapper.selectBackdownPage(page,backdownDTO.getUserId());
        return ResultVo.success(page);
    }

    //审批退住申请
    @Override
    public ResultVo examineBackdown(Backdown backdown)throws Exception{
        //审批状态auditStatus
        UpdateWrapper uw=new UpdateWrapper();
        uw.eq("id",backdown.getId());
        uw.set("audit_status",backdown.getAuditStatus());
        //审批时间auditTime
        uw.set("audit_time",backdown.getAuditTime());
        //审批人auditPerson
        uw.set("audit_person",backdown.getAuditPerson());
        backdownMapper.update(backdown, uw);
        return ResultVo.success("审批完成");
    }

    //撤回退住申请
    @Override
    public ResultVo delBackdown(Integer id)throws Exception{
        UpdateWrapper uw=new UpdateWrapper();
        uw.eq("id",id);
        uw.set("is_deleted",1);
        backdownMapper.update(null,uw);
        return ResultVo.success("撤回成功");
    }
}
