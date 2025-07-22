package com.cqupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.*;

@Data
@EqualsAndHashCode(callSuper = false) //自动生成equals()和hashCode()方法
@ApiModel(value="User对象",description = "这是User实体对象")
public class User implements Serializable {
    private static final long serialVersionUID = 1L; //序列化的ID号

    @ApiModelProperty(value="主键")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="创建时间")
    @TableField(value="create_time")
    private Date createTime;

    @ApiModelProperty(value="创建者")
    @TableField(value="create_by")
    private Integer createBy;

    @ApiModelProperty(value="更新时间")
    @TableField(value="update_time")
    private Date updateTime;

    @ApiModelProperty(value="更新者")
    @TableField(value="update_by")
    private Integer updateBy;

    @ApiModelProperty(value="是否删除 0:显示;1:隐藏")
    @TableField(value="is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value="真实姓名")
    @TableField(value="nick_name")
    private String nickName;

    @ApiModelProperty(value="系统账号")
    @TableField(value="user_name")
    private String userName;

    @ApiModelProperty(value="账号密码")
    @TableField(value="password")
    private String password;

    @ApiModelProperty(value="性别 0表示女,1表示男")
    @TableField(value="sex")
    private Integer sex;

    @ApiModelProperty(value="邮箱")
    @TableField(value="email")
    private String email;

    @ApiModelProperty(value="电话号码")
    @TableField(value="phone_number")
    private String phoneNumber;

    @ApiModelProperty(value="系统角色编号,1表示管理员,2表示健康管家")
    @TableField(value="role_id")
    private Integer roleId;

    @ApiModelProperty(value="当前用户角色菜单")
    @TableField(exist=false)
    private List<Menu>menuList;
}
