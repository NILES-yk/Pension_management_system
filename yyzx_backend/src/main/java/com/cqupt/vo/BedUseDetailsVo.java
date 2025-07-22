package com.cqupt.vo;

import com.cqupt.pojo.Room;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

/*
 * @author Wang Yanchen
 * @date 2025/06/23/09:00:06
 * @description 床位使用Vo类
 */
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="BedUseDetailsVo类",description = "这是BedUseDetailsVo类")
public class BedUseDetailsVo{
    @ApiModelProperty(value="总床位数")
    private Integer bedTotal;

    @ApiModelProperty(value="空闲床位数")
    private Integer bedAvailable;

    @ApiModelProperty(value="有人床位数")
    private Integer bedOccupied;

    @ApiModelProperty(value="外出床位数")
    private Integer bedOutward;

    @ApiModelProperty(value="房间和床位列表")
    private List<Room> roomList;
}
