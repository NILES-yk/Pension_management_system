package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.BackdownDTO;
import com.cqupt.pojo.Backdown;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.Customer;
import com.cqupt.service.BackdownService;
import com.cqupt.service.BedService;
import com.cqupt.service.CustomerService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BackdownVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backdown")
@Api(tags="退住管理")
@CrossOrigin
public class BackdownController {
    @Autowired
    private BackdownService backdownService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BedService bedService;

    @GetMapping("/listBackdownPage")
    @ApiOperation("退住记录动态分页查询")
    public ResultVo<Page<BackdownVo>> listBackdownPage(BackdownDTO backdownDTO) throws Exception {
        return backdownService.queryBackdownPage(backdownDTO);
    }

    @PostMapping("/addBackdown")
    @ApiOperation("添加退住审批")
    public ResultVo addBackdown(Backdown backdown) throws Exception {
        backdownService.save(backdown);
        return ResultVo.success("插入成功");
    }

    @PostMapping("/examineBackdown")
    @ApiOperation("审批退住申请")
    public ResultVo examineBackdown(Backdown backdown) throws Exception {
        Backdown bd=backdownService.getById(backdown.getId());
        //若审批通过，则修改床铺记录，对应床铺状态改为空闲
        if(backdown.getAuditStatus()==1){
           Customer cs=customerService.getById(bd.getCustomerId());
           Bed bed=new Bed();
           bed.setId(cs.getBedId());
           bed.setBedStatus(1);
           bedService.updateById(bed);
        }
        //继续设置其他信息
        return backdownService.examineBackdown(backdown);
    }

    @PostMapping("/removeBackdown")
    @ApiOperation("撤回退住申请")
    public ResultVo removeBackdown(Integer id) throws Exception {
        return backdownService.delBackdown(id);
    }

}
