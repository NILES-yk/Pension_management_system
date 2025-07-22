package com.cqupt.controller;

import com.cqupt.pojo.Room;
import com.cqupt.service.RoomService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedUseDetailsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/room")
@Api(tags="房间管理")
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/findBedUseDetails")
    @ApiOperation("查询床位的示意图")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",
                    name="floor",value="楼层",required=true) //查询时楼层值必须给出
    })
    private ResultVo<BedUseDetailsVo>findBedUseDetailsVo(String floor)throws Exception{
        return roomService.findBedUseDetailsVo(floor);
    }

    @GetMapping("/listRoom")
    @ApiOperation("查询床位的列表")
    private ResultVo<List<Room>>listRoom()throws Exception{
        return ResultVo.success(roomService.list());
    }
}
