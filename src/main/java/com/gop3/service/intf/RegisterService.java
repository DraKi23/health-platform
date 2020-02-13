package com.gop3.service.intf;

import com.gop3.dto.RegisterDTO;
import com.gop3.po.Doctor;
import com.gop3.po.Mother;

/**
 * Create by Drgn on 2019/11/30 15:54
 */
public interface RegisterService {
    //判断用户是否注册
    RegisterDTO getRegisterInfo(String openid);
    //医生注册信息写入数据库
    Boolean insertDoctorData(Doctor doctor);
    //妈妈注册信息写入数据库
    Boolean insertMotherData(Mother mother);
}
