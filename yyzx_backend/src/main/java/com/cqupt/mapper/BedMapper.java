package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqupt.pojo.Bed;
import com.cqupt.vo.BedUseDetailsVo;

public interface BedMapper extends BaseMapper<Bed> {
    BedUseDetailsVo selectBedCount();

}
