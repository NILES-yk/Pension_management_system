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
 * @date 2025/06/23/08:37:56
 * @description 客户护理项目VO类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CustomerNurseItemVo类",description = "这是CustomerNurseItemVo类")
public class CustomerNurseItemVo{
    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="护理项目编号")
    @TableField(value="item_id")
    private Integer itemId;

    @ApiModelProperty(value="客户编号")
    @TableField(value="customer_id")
    private Integer customerId;

    @ApiModelProperty(value="护理级别编号")
    @TableField(value="level_id")
    private Integer levelId;

    @ApiModelProperty(value="购买数量")
    @TableField(value="nurse_number")
    private Integer nurseNumber;

    @ApiModelProperty(value="逻辑删除标记（0：显示；1：隐藏）")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value="服务购买日期")
    @TableField(value="buy_time")
    private Date buyTime;

    @ApiModelProperty(value="服务到期日")
    @TableField(value="maturity_time")
    private Date maturityTime;

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

    @ApiModelProperty(value="编号")
    @TableField(value="serial_number")
    private String serialNumber;

    @ApiModelProperty(value="联系电话")
    @TableField(value="contact_tel")
    private String contactTel;

    @ApiModelProperty(value="所属楼房")
    @TableField(value="building_no")
    private String buildingNo;

    @ApiModelProperty(value="床号")
    @TableField(value="bed_id")
    private Integer bedId;

    @ApiModelProperty(value="护理级别")
    @TableField(value="level_name")
    private String levelName;

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
    private String executionTime;


}
