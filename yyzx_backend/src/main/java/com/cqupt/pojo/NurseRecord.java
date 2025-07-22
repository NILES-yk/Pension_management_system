package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="NurseRecord实体",description = "这是NurseRecord实体")
public class NurseRecord implements Serializable {
    private static final long serialVersionUID = 1L;

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

}
