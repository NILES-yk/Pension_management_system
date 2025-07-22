package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.CustomerNurseItemDTO;
import com.cqupt.mapper.CustomerMapper;
import com.cqupt.mapper.CustomerNurseItemMapper;
import com.cqupt.pojo.Customer;
import com.cqupt.pojo.CustomerNurseItem;
import com.cqupt.service.CustomerNurseItemService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.CustomerNurseItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerNurseItemServiceImpl extends ServiceImpl<CustomerNurseItemMapper, CustomerNurseItem> implements CustomerNurseItemService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    CustomerNurseItemMapper customerNurseItemMapper;

    @Override
    public ResultVo<Page<CustomerNurseItemVo>> listCustomerNurseItemPage(CustomerNurseItemDTO customerNurseItemDTO)throws Exception{
        Page<CustomerNurseItemVo> page = new Page<>(customerNurseItemDTO.getPageSize(),6);
        customerNurseItemMapper.selectCustomerNurseItemVoPage(page,
                customerNurseItemDTO.getCustomerId());
        return ResultVo.success(page);
    }

    @Override
    public ResultVo removeCustomerLevelAndItem(Integer levelId,Integer customerId)throws Exception{
        //更新客户的护理级别是null
        UpdateWrapper updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("level_id",null);
        updateWrapper.eq("id",customerId);
        int row1=customerMapper.update(null, updateWrapper);

        //删除客户当前级别的所有护理项目
        UpdateWrapper updateWrapper1 = new UpdateWrapper<>();
        updateWrapper1.set("is_deleted",1);
        updateWrapper1.eq("level_id",levelId);
        updateWrapper1.eq("customer_id",customerId);
        int row2=customerNurseItemMapper.update(null, updateWrapper1);
        if(!(row1>0&&row2>0)){
            throw new Exception("护理项目移除失败");
        }
        return ResultVo.success("移除成功");
    }

    @Override
    public ResultVo addItemToCustomer(List<CustomerNurseItem> customerNurseItemList)throws Exception{
        if(customerNurseItemList.size()>0){
            //判断是级别中的护理项目还是单独购买的护理项目
            if(customerNurseItemList.get(0).getLevelId()!=null){
                //购买级别的护理项目
                //设置客户的护理级别
                Customer customer=new Customer();
                customer.setId(customerNurseItemList.get(0).getCustomerId());
                customer.setLevelId(customerNurseItemList.get(0).getLevelId());
                //update customer set level_id=? where id=?
                int row1=customerMapper.updateById(customer);
                //批量添加护理项目
                boolean result=saveBatch(customerNurseItemList);
                if(!(row1>0&&result)){
                    throw new Exception("护理项目配置失败");
                }
            }
            else{
                //单独购买的护理项目
                saveBatch(customerNurseItemList);
            }
            return ResultVo.success("护理项目添加成功");
        }
        return ResultVo.fail("请选择需要添加的护理项目");
    }

    @Override
    public ResultVo selectIncludesItem(Integer customerId,Integer itemId)throws Exception{
        if(customerId==null || itemId==null){
            throw new Exception("用户ID和护理项目ID不能为空");
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("customer_id",customerId);
        queryWrapper.eq("item_id",itemId);
        queryWrapper.eq("is_deleted",0);
        int row=customerNurseItemMapper.selectCount(queryWrapper);
        if(row>0){
            return ResultVo.success("已配置");
        }
        return ResultVo.success("未配置");
    }
}
