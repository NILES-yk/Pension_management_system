package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BedDetailsDTO类-床位管理查询条件",description = "这是BedDetailsDTO类")
public class BedDetailsDTO {

    @ApiModelProperty(value="页码")
    private Integer pageSize;

    @ApiModelProperty(value="客户姓名")
    private String customerName;

    @ApiModelProperty(value="床位是否生效（0：生效；1：失效）")
    private Integer isDeleted;

    @ApiModelProperty(value="开始时间")
    private Date startDate;

    @ApiModelProperty(value="结束时间")
    private Date endDate;
}
