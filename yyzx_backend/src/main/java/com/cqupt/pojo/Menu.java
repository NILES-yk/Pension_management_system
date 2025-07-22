package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Menu对象",description="这是Menu实体对象")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="一级菜单索引")
    @TableField(value="menus_index")
    private Integer menusIndex;

    @ApiModelProperty(value="菜单标题")
    @TableField(value="title")
    private String title;

    @ApiModelProperty(value="菜单图标")
    @TableField(value="icon")
    private String icon;

    @ApiModelProperty(value="菜单路径")
    @TableField(value="path")
    private String path;

    @ApiModelProperty(value="父级Id")
    @TableField(value="parent_id")
    private Integer parentId;

    @ApiModelProperty(value="子菜单")
    @TableField(exist=false) //在原表中没有
    private List<Menu> children;
}
