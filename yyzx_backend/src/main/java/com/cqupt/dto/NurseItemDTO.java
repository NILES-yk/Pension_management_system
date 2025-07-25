package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="NurseItemDTO类-护理项目查询条件",description = "这是NurseItemDTO类")
public class NurseItemDTO {
    @ApiModelProperty(value="状态 1:启用  2:停用")
    private Integer status;

    @ApiModelProperty(value="页码")
    private Integer pageSize;

    @ApiModelProperty(value="名称")
    private String nursingName;
}
