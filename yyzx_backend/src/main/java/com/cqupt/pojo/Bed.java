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
@ApiModel(value="Bed对象",description = "这是Bed实体对象")
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="房间编号")
    @TableField(value="room_no")
    private Integer roomNo;

    @ApiModelProperty(value="房间状态 1:空闲,2:有人,3:外出")
    @TableField(value="bed_status")
    private Integer bedStatus;

    @ApiModelProperty(value="备注")
    @TableField(value="remarks")
    private String remarks;

    @ApiModelProperty(value="床位编号")
    @TableField(value="bed_no")
    private String bedNo;

}
