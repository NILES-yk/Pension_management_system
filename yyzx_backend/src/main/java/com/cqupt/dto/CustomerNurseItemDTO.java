package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="CustomerNurseItemDTO类-查询客户护理项目条件",description = "这是CustomerNurseItemDTO类")
public class CustomerNurseItemDTO {
    @ApiModelProperty(value="客户编号")
    private Integer customerId;

    @ApiModelProperty(value="页码")
    private Integer pageSize;
}
