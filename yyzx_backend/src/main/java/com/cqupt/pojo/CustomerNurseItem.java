package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;

/*
 * @author Wang Yanchen
 * @date 2025/06/21/15:26:08
 * @description 客户护理项目实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CustomerNurseItem实体",description = "这是CustomerNurseItem实体")
public class CustomerNurseItem implements Serializable {
    private static final long serialVersionUID = 1L;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date buyTime;

    @ApiModelProperty(value="服务到期日")
    @TableField(value="maturity_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date maturityTime;
}
