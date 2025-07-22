package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="NurseRecordDTO类-客户护理记录查询条件",description = "这是NurseRecordDTO类")
public class NurseRecordDTO {
    @ApiModelProperty(value="客户编号")
    private Integer customerId;

    @ApiModelProperty(value="页码")
    private Integer pageSize;
}
