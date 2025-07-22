package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.BedDetailsDTO;
import com.cqupt.dto.ExchangeDTO;
import com.cqupt.mapper.BedDetailsMapper;
import com.cqupt.mapper.BedMapper;
import com.cqupt.mapper.CustomerMapper;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.BedDetails;
import com.cqupt.pojo.Customer;
import com.cqupt.service.BedDetailsService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class BedDetailsServiceImpl extends ServiceImpl<BedDetailsMapper, BedDetails> implements BedDetailsService {

    @Autowired
    private BedDetailsMapper bedDetailsMapper;

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private CustomerMapper customerMapper;

    //分页查询器
    @Override
    public ResultVo<Page<BedDetailsVo>> listBedDetailsPage(BedDetailsDTO bedDetailsDTO)throws Exception{
        Page<BedDetailsVo> page=new Page<>(bedDetailsDTO.getPageSize(),6); //限制分页查询显示的条数
        bedDetailsMapper.selectBedDetailsVo(page,bedDetailsDTO);
        return ResultVo.success(page);
    }

    //涉及多张表的修改,必须捆绑为一个事务
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo exchangeBed(ExchangeDTO exchangeDTO)throws Exception{
        //1.查询床位是否可用
        QueryWrapper queryWrapper = new QueryWrapper();
        Bed bed=bedMapper.selectById(exchangeDTO.getNewBedId());
        if(bed.getBedStatus()!=1){
            return ResultVo.fail("此床已经被占用");
        }

        //2.修改客户旧的床位信息(修改bed_details表):is_deleted为1 床位使用的结束时间为当前日期
        BedDetails bedDetails= new BedDetails();
        bedDetails.setId(exchangeDTO.getId()); //获取并设置旧床位的id
        bedDetails.setIsDeleted(1); //将旧床位的is_deleted属性置为1 隐藏
        bedDetails.setEndDate(new Date()); //结束时间是当前日期
        int row1=bedDetailsMapper.updateById(bedDetails); //返回更新的列数,判断是否更新成功

        //3.添加新的床位记录(修改bed_details表)
        BedDetails newBedDetails=new BedDetails(); //新床位不用管id,因为id是自动自增的
        newBedDetails.setIsDeleted(0); //设置新床位的is_deleted=0 显示
        newBedDetails.setCustomerId(exchangeDTO.getCustomerId()); //设置新床位的客户id
        newBedDetails.setBedId(exchangeDTO.getNewBedId()); //设置床位的id号
        newBedDetails.setEndDate(exchangeDTO.getEndDate());
        newBedDetails.setStartDate(new Date()); //开始时间是当前日期
        newBedDetails.setBedDetails(exchangeDTO.getBuildingNo()+"#"+bed.getBedNo());
        int row2=bedDetailsMapper.insert(newBedDetails);

        //4.把旧床位的状态改为空闲(修改bed表)(bed_status=1)
        Bed oldBed=new Bed();
        oldBed.setId(exchangeDTO.getOldBedId());
        oldBed.setBedStatus(1);
        int row3=bedMapper.updateById(oldBed);

        //5.设置新床位为有人的状态(修改bed表)(bed_status=2)
        Bed newBed=new Bed();
        newBed.setId(exchangeDTO.getNewBedId());
        newBed.setBedStatus(2);
        int row4=bedMapper.updateById(newBed);

        //6.修改客户的信息(修改customer表)(新的房间号，新的床位号，新的楼号)
        Customer customer=new Customer();
        customer.setId(exchangeDTO.getCustomerId());
        customer.setBedId(exchangeDTO.getNewBedId());
        customer.setBuildingNo(exchangeDTO.getBuildingNo());
        customer.setRoomNo(exchangeDTO.getNewRoomNo());
        int row5=customerMapper.updateById(customer);

        //判断是否每一个更新影响的行数都是>0的
        if(row1>0&&row2>0&&row3>0&&row4>0&&row5>0){
            return ResultVo.success("床位调换成功");
        }

        throw new Exception("床位调换失败");
    }

}
