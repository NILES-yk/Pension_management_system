package com.cqupt.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.MealDTO;
import com.cqupt.mapper.MealMapper;
import com.cqupt.pojo.Meal;
import com.cqupt.service.MealService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.MealVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements MealService {

    @Autowired
    private MealMapper mealMapper;

    //进行动态分页查询
    @Override
    public ResultVo<Page<MealVo>> listMealPage(MealDTO mealDTO)throws Exception{
        if(mealDTO==null){
            throw new Exception("参数无效");
        }
        Page<MealVo> page = new Page<>(mealDTO.getPageSize(),6);
        //查询
        mealMapper.selectMealVo(page,mealDTO.getWeekDay(),mealDTO.getMealType());
        return ResultVo.success(page);
    }
}
