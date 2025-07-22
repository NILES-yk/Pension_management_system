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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Role实体",description = "这是Role实体")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="创建时间")
    @TableField(value="create_time")
    private Date createTime;

    @ApiModelProperty(value="更新时间")
    @TableField(value="update_time")
    private Date updateTime;

    @ApiModelProperty(value="更新者")
    @TableField(value="update_by")
    private Integer updateBy;

    @ApiModelProperty(value="是否删除 0:显示;1:隐藏")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value="系统角色名")
    @TableField(value="name")
    private String name;

}
