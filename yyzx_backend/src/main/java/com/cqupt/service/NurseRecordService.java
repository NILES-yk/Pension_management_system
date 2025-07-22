package com.cqupt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.dto.NurseRecordDTO;
import com.cqupt.pojo.NurseRecord;
import com.cqupt.utils.ResultVo;
import com.cqupt.vo.NurseRecordVo;


public interface NurseRecordService extends IService<NurseRecord> {
    ResultVo<Page<NurseRecordVo>>queryNurseRecordPage(NurseRecordDTO nurseRecordDTO)throws Exception;

    ResultVo addNurseRecord(NurseRecord nurseRecord)throws Exception;
}
