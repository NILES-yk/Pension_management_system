package com.cqupt.controller;

import com.cqupt.pojo.Food;
import com.cqupt.service.FoodService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
@Api(tags="食物管理")
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/listFood")
    @ApiOperation("查询所有食品列表")
    public ResultVo listFood()throws Exception{
        return ResultVo.success(foodService.list());
    }

}
