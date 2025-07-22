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
@ApiModel(value="NurseContent对象",description = "这是NurseContent对象")
public class NurseContent implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="编号")
    @TableField(value="serial_number")
    private String serialNumber;

    @ApiModelProperty(value="名称")
    @TableField(value="nursing_name")
    private String nursingName;

    @ApiModelProperty(value="价格")
    @TableField(value="service_price")
    private String servicePrice;

    @ApiModelProperty(value="描述")
    @TableField(value="message")
    private String message;

    @ApiModelProperty(value="状态 1：启用；2：停用")
    @TableField(value="status")
    private Integer status;

    @ApiModelProperty(value="执行周期")
    @TableField(value="execution_cycle")
    private String executionCycle;

    @ApiModelProperty(value="执行次数")
    @TableField(value="execution_times")
    private String executionTimes;

    @ApiModelProperty(value="逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;
}
