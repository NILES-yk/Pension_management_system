package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CustomerInfoDTO类-客户信息查询条件",description = "这是CustomerInfoDTO类")
public class CustomerInfoDTO {

    @ApiModelProperty(value="页码")
    private Integer pageSize;

    @ApiModelProperty(value="客户姓名")
    private String customerName;

    @ApiModelProperty(value="系统健康管家")
    private Integer userId;

    @ApiModelProperty(value="老人的类型 1-自理老人 2-护理老人 3-无管家")
    private Integer oldType;

}
