package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BackdownDTO类-查询回院记录",description = "这是BackdownDTO类")
public class BackdownDTO {
    @ApiModelProperty(value="用户编号")
    private Integer userId;

    @ApiModelProperty(value="页码")
    private Integer pageSize;
}
