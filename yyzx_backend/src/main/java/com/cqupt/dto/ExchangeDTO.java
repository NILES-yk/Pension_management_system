package com.cqupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ExchangeDTO类-床位调换参数",description = "这是ExchangeDTO类")
public class ExchangeDTO {
    @ApiModelProperty(value="床位详情编号")
    private Integer id;

    @ApiModelProperty(value="客户编号")
    private Integer customerId;

    @ApiModelProperty(value="新楼号")
    private String buildingNo;

    @ApiModelProperty(value="新房间号")
    private String newRoomNo;

    @ApiModelProperty(value="新床位编号")
    private Integer newBedId;

    @ApiModelProperty(value="旧床位编号")
    private Integer oldBedId;

    @ApiModelProperty(value="床位使用结束时间")
    private Date endDate;
}
