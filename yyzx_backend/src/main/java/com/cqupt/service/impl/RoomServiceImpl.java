package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.mapper.BedMapper;
import com.cqupt.mapper.RoomMapper;
import com.cqupt.pojo.Room;
import com.cqupt.service.RoomService;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedUseDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {

    @Autowired
    private BedMapper bedMapper;

    //查看每个房间的床位使用情况
    @Override
    public ResultVo<BedUseDetailsVo> findBedUseDetailsVo(String floor)throws Exception{
        //计算床位数目
        BedUseDetailsVo bedUseDetailsVo=bedMapper.selectBedCount();
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("room_floor",floor);
        //查询所有的房间
        List<Room>roomList=list(queryWrapper);

        //查询每个房间的床位情况
        for(Room room:roomList){
            QueryWrapper qwBed=new QueryWrapper();
            qwBed.eq("room_no",room.getRoomNo());
            room.setBedList(bedMapper.selectList(qwBed));
        }
        bedUseDetailsVo.setRoomList(roomList);
        return ResultVo.success(bedUseDetailsVo);
    }
}
