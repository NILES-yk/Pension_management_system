package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/*
 * @author Wang Yanchen
 * @date 2025/06/21/16:16:59
 * @description 食物实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Food实体",description = "这是Food实体")
public class Food  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

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
