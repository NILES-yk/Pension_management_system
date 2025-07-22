package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.CustomerInfoDTO;
import com.cqupt.mapper.BedDetailsMapper;
import com.cqupt.mapper.BedMapper;
import com.cqupt.mapper.CustomerMapper;
import com.cqupt.pojo.Bed;
import com.cqupt.pojo.BedDetails;
import com.cqupt.pojo.Customer;
import com.cqupt.service.CustomerService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    BedMapper bedMapper;

    @Autowired
    BedDetailsMapper bedDetailsMapper;

    @Autowired
    CustomerMapper customerMapper;

    //添加客户 涉及多表格数据更新，需要保持事务原子性
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo addCustomer(Customer customer)throws Exception{
        //1.查询床位是否可用  bed
        Bed bed=bedMapper.selectById(customer.getBedId());
        if(bed.getBedStatus()!=1){
            return ResultVo.fail("床位已被占用");
        }

        //2.生成客户信息  customer
        customer.setIsDeleted(0); //默认is_deleted=0
        customer.setUserId(-1); //默认设置没有管家
        customer.setFilePath("@/assets/tou.png");
        int row1=customerMapper.insert(customer);

        //3.生成入住详细信息  bedDetails
        BedDetails bedDetails=new BedDetails();
        bedDetails.setBedId(customer.getBedId()); //设置床位ID
        bedDetails.setIsDeleted(0); //默认设置为显示
        bedDetails.setCustomerId(customer.getId()); //设置顾客ID
        bedDetails.setStartDate(customer.getCheckinDate()); //设置开始时间
        bedDetails.setEndDate(customer.getExpirationDate()); //设置到期时间
        bedDetails.setBedDetails(customer.getBuildingNo()+"#"+customer.getRoomNo()); //设置床位信息
        int row2=bedDetailsMapper.insert(bedDetails);

        //4.修改床位状态  bed1
        Bed bed1=new Bed();
        bed1.setId(customer.getBedId());
        bed1.setBedStatus(2);
        int row3=bedMapper.updateById(bed1);

        //5.判断是否操作成功
        if(row1>0&&row2>0&&row3>0){
            return ResultVo.success("入住成功");
        }
        return ResultVo.error(new Exception("操作失败"));
    }

    //分页查询客户信息
    @Override
    public ResultVo<Page<CustomerInfoVo>> findCustomerInfo(CustomerInfoDTO customerInfoDTO)throws Exception{
        Page<CustomerInfoVo>page=new Page<>(customerInfoDTO.getPageSize(),6);
        customerMapper.selectCustomerVo(page,
                customerInfoDTO.getCustomerName(),
                customerInfoDTO.getOldType(),
                customerInfoDTO.getUserId());
        return ResultVo.success(page);
    }

    //删除客户及其床位信息
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo removeCustomer(Integer id,Integer bedId)throws Exception{
        //1.将客户is_deleted设置为1
        Customer customer=new Customer();
        customer.setId(id);
        customer.setIsDeleted(1);
        int row1=customerMapper.updateById(customer);

        //2.修改床位状态为空闲 bedStatus
        Bed bed=new Bed();
        bed.setId(bedId);
        bed.setBedStatus(1);
        int row2=bedMapper.updateById(bed);

        //3.将床位详情的is_deleted设置为1
        BedDetails bedDetails=new BedDetails();
        bedDetails.setIsDeleted(1);
        UpdateWrapper updateWrapper=new UpdateWrapper();
        updateWrapper.eq("customer_id",id);
        updateWrapper.eq("bed_id",bedId);
        updateWrapper.eq("is_deleted",0);
        int row3=bedDetailsMapper.update(bedDetails,updateWrapper);

        if(row1>0&&row2>0&&row3>0){
            return ResultVo.success("删除成功");
        }
        return ResultVo.error(new Exception("操作失败"));
    }

    //编辑客户信息 涉及多表格数据更新，需要保持事务原子性
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo editCustomer(Customer customer)throws Exception{
        //1.修改客户信息
        int row1=customerMapper.updateById(customer);
        //2.如果合同到期时间发生改变,则更新当前生效床位信息的退住时间为合同到期时间
        if(customer.getExpirationDate()!=null){
            BedDetails bedDetails=new BedDetails();
            //set
            bedDetails.setEndDate(customer.getExpirationDate());
            //where
            UpdateWrapper updateWrapper=new UpdateWrapper();
            updateWrapper.eq("customer_id",customer.getId());
            updateWrapper.eq("is_deleted",0);
            //等同于SQL语句:update bed_details set end_date=... where customer_id=... and is_deleted=0;
            int row2=bedDetailsMapper.update(bedDetails,updateWrapper);
            if(!(row1>0&&row2>0)){
                return ResultVo.error(new Exception("编辑失败"));
            }
        }
        return ResultVo.success("编辑成功");
    }

}
