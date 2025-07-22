package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.MealDTO;
import com.cqupt.pojo.Meal;
import com.cqupt.service.MealService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.MealVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meal")
@Api(tags="膳食日历管理")
@CrossOrigin
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/listMealPage")
    @ApiOperation("膳食查询(分页) 可以根据星期和膳食类型(早餐、中餐、晚餐)进行查询")
    public ResultVo<Page<MealVo>>listMealPage(MealDTO mealDTO)throws Exception{
        return mealService.listMealPage(mealDTO);
    }

    @PostMapping("/addMeal")
    @ApiOperation("添加膳食")
    public ResultVo addMeal(Meal meal)throws Exception{
        mealService.save(meal);
        return ResultVo.success("添加成功");
    }

    @PostMapping("/updateMeal")
    @ApiOperation("更新膳食")
    public ResultVo updateMeal(Meal meal)throws Exception{
        mealService.updateById(meal);
        return ResultVo.success("更新成功");
    }

    @GetMapping("/removeMeal")
    @ApiOperation("删除膳食")
    public ResultVo removeMeal(Integer id)throws Exception{
        mealService.removeById(id);
        return ResultVo.success("删除成功");
    }
}
