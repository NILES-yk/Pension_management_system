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
 * @date 2025/06/23/09:18:32
 * @description 护理记录VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="NurseRecordVo类",description = "这是NurseRecordVo类")
public class NurseRecordVo{
    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty("逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value="客户ID")
    @TableField(value="customer_id")
    private Integer customerId;

    @ApiModelProperty(value="护理项目ID")
    @TableField(value="item_id")
    private Integer itemId;

    @ApiModelProperty(value="护理时间")
    @TableField(value="nursing_time")
    private Date nursingTime;

    @ApiModelProperty(value="护理内容")
    @TableField(value="nursing_content")
    private String nursingContent;

    @ApiModelProperty(value="护理数量")
    @TableField(value="nursing_count")
    private Integer nursingCount;

    @ApiModelProperty(value="护理人员ID")
    @TableField(value="user_id")
    private Integer userId;

    //其他字段:NurseContent+User
    @ApiModelProperty(value="编号")
    @TableField(value="serial_number")
    private String serialNumber;

    @ApiModelProperty(value="名称")
    @TableField(value="nursing_name")
    private String nursingName;

    @ApiModelProperty(value="真实姓名")
    @TableField(value="nickname")
    private String nickName;

    @ApiModelProperty(value="电话号码")
    @TableField(value="phone_number")
    private String phoneNumber;
}
