package com.gop3.service.intf;

import com.gop3.dto.AttenDoctorDTO;
import com.gop3.dto.AttenMotherDTO;
import com.gop3.dto.GetDoctorDTO;
import com.gop3.dto.GetMotherDTO;

import java.util.List;

/**
 * Create by jinli on 2020/1/21 21:24
 */
public interface AttentionService {
    //获取妈妈关注的医生列表
    List<AttenDoctorDTO> getAttenDoctorListById(String wx_openid);
    //获取妈妈未关注的医生列表
    List<AttenDoctorDTO> getUnAttenDoctorListById(String wx_openid);
    //获取某一位医生信息
    GetDoctorDTO getDoctorByWxId(String wx_openid);
    //添加妈妈关注的医生到关注表
    Boolean insertDoctorMother(String m_openid, String d_openid);
    //取消关注医生
    Boolean deleteDoctorMother(String m_openid, String d_openid);
    //获取医生被关注的妈妈列表
    List<AttenMotherDTO> getAttenMotherListById(String wx_openid);
    //获取某一位妈妈信息
    GetMotherDTO getMotherByWxId(String wx_openid);
}
