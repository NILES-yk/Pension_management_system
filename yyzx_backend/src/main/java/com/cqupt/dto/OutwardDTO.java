package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="OutwardDTO类",description = "这是OutwardDTO类")
public class OutwardDTO {
    @ApiModelProperty(value="用户编号")
    private Integer userId;

    @ApiModelProperty(value="页码")
    private Integer pageSize;
}
