package com.cqupt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/*
 * @author Wang Yanchen
 * @date 2025/06/23/09:33:26
 * @description 退住登记VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BackdownVo类",description = "这是BackdownVo类")
public class BackdownVo {
    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="备注")
    @TableField(value="remarks")
    private String remarks;

    @ApiModelProperty(value="逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value="客户ID")
    @TableField(value="customer_id")
    private Integer customerId;

    @ApiModelProperty(value="退住时间")
    @TableField(value="retreat_time")
    private Date retreatTime;

    @ApiModelProperty(value="退住类型 0-正常退住  1-死亡退住 2-保留床位")
    @TableField(value="retreat_type")
    private Integer retreatType;

    @ApiModelProperty(value="退住原因")
    @TableField(value="retreat_reason")
    private String retreatReason;

    @ApiModelProperty(value="审批状态  0-已提交 1-同意  2-拒绝")
    @TableField(value="audit_status")
    private Integer auditStatus;

    @ApiModelProperty(value="审批人")
    @TableField(value="audit_person")
    private String auditPerson;

    @ApiModelProperty(value="审批时间")
    @TableField(value="audit_time")
    private Date auditTime;

    //其他字段:Bed+Customer
    @ApiModelProperty(value="客户姓名")
    @TableField(value="customer_name")
    private String customerName;

    @ApiModelProperty(value="床位详情")
    private String bedDetails;

    @ApiModelProperty(value="用户id")
    private Integer userId;

    @ApiModelProperty(value="入住时间")
    @TableField(value="checkin_name")
    private Date checkinDate;
}
