package com.gop3.service.intf;

import com.gop3.dto.DoctorEditInfoDTO;
import com.gop3.dto.MotherEditInfoDTO;

/**
 * Create by Drgn on 2020/4/30 15:37
 */
public interface EditInfoService {
    // 妈妈相关
    // 查看资料
    MotherEditInfoDTO getMotherInfo(String motherOpenID);
    // 编辑资料
    boolean updateMotherInfo(MotherEditInfoDTO motherEditInfoDTO);

    // 医生相关
    // 查看资料
    DoctorEditInfoDTO getDocInfo(String doctorOpenid);
    // 编辑资料
    boolean updateDocInfo(DoctorEditInfoDTO doctorEditInfoDTO);

    boolean updateDocInfoIfUpdatePhoto(DoctorEditInfoDTO doctorEditInfoDTO);
}
