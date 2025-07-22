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
 * @date 2025/06/23/10:03:19
 * @description 客户喜好VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CustomerPreferenceVo类",description = "这是CustomerPreferenceVo类")
public class CustomerPreferenceVo{
    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="顾客ID")
    @TableField(value="customer_id")
    private Integer customerId;

    @ApiModelProperty(value="饮食喜好")
    @TableField(value="preferences")
    private String preferences;

    @ApiModelProperty(value="注意事项")
    @TableField(value="attention")
    private String attention;

    @ApiModelProperty(value="备注")
    @TableField(value="remark")
    private String remark;

    @ApiModelProperty(value="逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    //其他字段:Customer
    @ApiModelProperty(value="客户姓名")
    @TableField(value="customer_name")
    private String customerName;

    @ApiModelProperty(value="客户年龄")
    @TableField(value="customer_age")
    private Integer customerAge;

    @ApiModelProperty(value="客户性别 0：男  1：女")
    @TableField(value="customer_sex")
    private Integer customerSex;
}
