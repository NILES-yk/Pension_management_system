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
 * @date 2025/06/23/08:30:30
 * @description 床位信息VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BedDetailsVo对象",description = "这是BedDetailsVo对象")
public class BedDetailsVo{
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

    //其他字段
    @ApiModelProperty(value="客户姓名")
    @TableField(value="customer_name")
    private String customerName;

    @ApiModelProperty(value="客户年龄")
    @TableField(value="customer_age")
    private Integer customerAge;

    @ApiModelProperty(value="客户性别 0：男  1：女")
    @TableField(value="customer_sex")
    private Integer customerSex;

    @ApiModelProperty(value="房间编号")
    @TableField(value="room_no")
    private String roomNo;
}
