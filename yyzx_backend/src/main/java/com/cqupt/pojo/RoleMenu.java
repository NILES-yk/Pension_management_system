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
@ApiModel(value="RoleMenu实体",description = "这是RoleMenu实体")
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="角色编号")
    @TableField(value="role_id")
    private Integer roleId;

    @ApiModelProperty(value="菜单编号")
    @TableField(value="menu")
    private Integer menu;
}
