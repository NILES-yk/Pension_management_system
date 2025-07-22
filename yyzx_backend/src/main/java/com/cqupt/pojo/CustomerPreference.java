package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CustomerPreference对象",description = "这是CustomerPreference对象")
public class CustomerPreference implements Serializable {
    private static final long serialVersionUID = 1L;

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
}
