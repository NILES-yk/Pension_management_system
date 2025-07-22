package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * @author Wang Yanchen
 * @date 2025/06/23/10:08:58
 * @description 膳食管理VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MealVo类",description = "这是MealVo类")
public class MealVo{
    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="星期几")
    @TableField(value="week_day")
    private String weekDay;

    @ApiModelProperty(value="食品ID")
    @TableField(value="food_id")
    private Integer foodId;

    @ApiModelProperty(value="食品类型（1.早餐、2.午餐、3.晚餐）")
    @TableField(value="meal_type")
    private Integer mealType;

    @ApiModelProperty(value="口味（多糖、多盐、少糖、少盐）")
    @TableField(value="taste")
    private String taste;

    @ApiModelProperty(value="逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    //其他字段:Food
    @ApiModelProperty(value="食品名称")
    @TableField(value="food_name")
    private String foodName;

    @ApiModelProperty(value="食品类型")
    @TableField(value="food_type")
    private String foodType;

    @ApiModelProperty(value="价格")
    @TableField(value="price")
    private Double price;

    @ApiModelProperty(value="是否清真")
    @TableField(value="is_halal")
    private Integer isHalal;

    @ApiModelProperty(value="图片路径")
    @TableField(value="food_img")
    private String foodImg;
}
