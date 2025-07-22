package com.cqupt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.Room;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.BedUseDetailsVo;


public interface RoomService extends IService<Room> {
    ResultVo<BedUseDetailsVo>findBedUseDetailsVo(String floor)throws Exception;
}
