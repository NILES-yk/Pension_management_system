package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="CustomerPreferenceDTO类-客户喜好查询条件",description = "这是CustomerPreferenceDTO类")
public class CustomerPreferenceDTO {
    @ApiModelProperty(value="喜好编号")
    private Integer preferenceId;

    @ApiModelProperty(value="顾客姓名")
    private String customerName;

    @ApiModelProperty(value="页码")
    private Integer pageSize;
}
