package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.OutwardDTO;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.Customer;
import com.cqupt.pojo.Outward;
import com.cqupt.service.BedService;
import com.cqupt.service.CustomerService;
import com.cqupt.service.OutwardService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.OutwardVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/outward")
@Api(tags="外出管理")
@CrossOrigin
public class OutwardController {
    @Autowired
    OutwardService outwardService;
    @Autowired
    private BedService bedService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/listOutwardPage")
    @ApiOperation("出院记录动态分页查询")
    public ResultVo<Page<OutwardVo>> listOutwardPage(OutwardDTO outwardDTO)throws Exception{
        return outwardService.queryOutwardPage(outwardDTO);
    }

    @PostMapping("/examineOutward")
    @ApiOperation("审批外出")
    public ResultVo examineOutward(Outward outward)throws Exception{
        Outward od=outwardService.getById(outward.getId());
        //若审批通过，则修改床铺记录，对应床铺状态改为外出
        if(outward.getAuditStatus()==1){
            Customer cs=customerService.getById(od.getCustomerId());
            Bed bed=new Bed();
            bed.setId(cs.getBedId());
            bed.setBedStatus(3);
            bedService.updateById(bed);
        }
        //继续设置其他信息
        return outwardService.examineOutward(outward);
    }

    @PostMapping("/removeOutward")
    @ApiOperation("撤销外出申请")
    public ResultVo removeOutward(Integer id)throws Exception{
        return outwardService.delOutward(id);
    }

    @PostMapping("/updateBackTime")
    @ApiOperation("登记回院时间")
    public ResultVo updateBackTime(Outward outward)throws Exception{
        Outward od=outwardService.getById(outward.getId());
        Customer cs=customerService.getById(od.getCustomerId());
        Bed bed=new Bed();
        bed.setId(cs.getBedId());
        //人已经回来，更改床位状态
        bed.setBedStatus(2);
        bedService.updateById(bed);
        return outwardService.updateBackTime(outward);
    }

    @PostMapping("/addOutward")
    @ApiOperation("添加外出审批")
    public ResultVo addOutward(Outward outward)throws Exception{
        outwardService.save(outward);
        return ResultVo.success("添加成功");
    }

}
