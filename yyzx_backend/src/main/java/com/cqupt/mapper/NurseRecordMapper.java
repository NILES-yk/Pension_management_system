package com.cqupt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.NurseRecord;
import com.cqupt.vo.NurseRecordVo;
import org.apache.ibatis.annotations.Param;

public interface NurseRecordMapper extends BaseMapper<NurseRecord> {
    Page<NurseRecordVo>selectNurseRecordVo(@Param("page")Page<NurseRecordVo>page,
                                           @Param("customerId")Integer customerId)throws Exception;
}
