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
 * @date 2025/06/23/09:24:25
 * @description 外出登记VO类
 */
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="OutwardVo类",description = "这是OutwardVo类")
public class OutwardVo {
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

    @ApiModelProperty(value="外出事由")
    @TableField(value="outgoing_reason")
    private String outgoingReason;

    @ApiModelProperty(value="外出时间")
    @TableField(value="outgoing_time")
    private Date outgoingTime;

    @ApiModelProperty(value="预计回院时间")
    @TableField(value="expected_return_time")
    private Date expectedReturnTime;

    @ApiModelProperty(value="实际回院时间")
    @TableField(value="actual_return_time")
    private Date actualReturnTime;

    @ApiModelProperty(value="陪同人")
    @TableField(value="escorted")
    private String escorted;

    @ApiModelProperty(value="与老人关系")
    @TableField(value="relation")
    private String relation;

    @ApiModelProperty(value="陪同人电话")
    @TableField(value="escorted_tel")
    private String escortedTel;

    @ApiModelProperty(value="审批状态  0-已提交 1-同意  2-拒绝")
    @TableField(value="audit_status")
    private Integer auditStatus;

    @ApiModelProperty(value="审批人")
    @TableField(value="audit_person")
    private String auditPerson;

    @ApiModelProperty(value="审批时间")
    @TableField(value="audit_time")
    private Date auditTime;

    //其他字段:Customer+User+NurseContent
    @ApiModelProperty(value="护理人真实姓名")
    @TableField(value="nickname")
    private String nickName;

    @ApiModelProperty(value="护理人电话号码")
    @TableField(value="phone_number")
    private String phoneNumber;

    @ApiModelProperty(value="客户姓名")
    @TableField(value="customer_name")
    private String customerName;

}
