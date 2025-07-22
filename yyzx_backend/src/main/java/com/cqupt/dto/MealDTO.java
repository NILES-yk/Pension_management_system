package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="MealDTO类-查询膳食安排条件",description = "这是MealDTO类")
public class MealDTO {
    @ApiModelProperty(value="食谱编号")
    private Integer mealId;

    @ApiModelProperty(value="星期")
    private String weekDay;

    @ApiModelProperty(value="页码")
    private Integer pageSize;

    @ApiModelProperty(value="餐饮类型:早餐/中餐/晚餐")
    private Integer mealType;
}
