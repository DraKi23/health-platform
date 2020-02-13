package com.gop3.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gop3.dto.AttenDoctorDTO;
import com.gop3.po.Doctor;

import java.util.Date;
import java.util.List;

/**
 * Create by jinli on 2020/1/21 21:24
 */
public interface AttentionService {
    //获取妈妈关注的医生列表
    List<AttenDoctorDTO> getAttenDoctorListById(String code) throws JsonProcessingException;
    //获取妈妈未关注的医生列表
    List<AttenDoctorDTO> getUnAttenDoctorListById(String code) throws JsonProcessingException;
    //获取某一位医生信息
    Doctor getDoctorByWxId(String code) throws JsonProcessingException;
    //添加妈妈关注的医生到关注表
    Boolean insertDoctorMother(String m_openid, String d_openid);
    //取消关注医生
    Boolean deleteDoctorMother(String m_openid, String d_openid);
}
