package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserDTO类-用户查询的条件",description = "这是UserDTO类")
public class UserDTO {
    @ApiModelProperty(value="页码")
    private Integer pageSize;

    @ApiModelProperty(value="系统角色编号,1表示管理员,2表示健康管家")
    private Integer roleId;

    @ApiModelProperty(value="用户真实姓名")
    private String nickName;

}
