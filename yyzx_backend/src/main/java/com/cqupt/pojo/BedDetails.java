package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BedDetails实体",description = "这是BedDetails实体")
public class BedDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="床位起始日期")
    @TableField(value="start_date")
    private Date startDate;

    @ApiModelProperty(value="床位结束日期")
    @TableField(value="end_date")
    private Date endDate;

    @ApiModelProperty(value="床位详情信息")
    @TableField(value="bed_details")
    private String bedDetails;

    @ApiModelProperty(value="顾客ID")
    @TableField(value="customer_id")
    private Integer customerId;

    @ApiModelProperty(value="床位ID")
    @TableField(value="bed_id")
    private Integer bedId;

    @ApiModelProperty(value="逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;
}
