package com.gop3.mapper;

import com.gop3.dto.AttenDoctorDTO;
import com.gop3.dto.GetDoctorDTO;
import com.gop3.dto.RegDoctorDTO;
import com.gop3.po.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2019/11/30 15:49
 */
@Mapper
public interface DoctorMapper {

    //根据微信id获取医生对象
    Doctor getDoctorByOpenid(@Param("openid")String openid);
    //将医生注册的信息存入数据库
    Boolean insertDoctor(RegDoctorDTO regDoctorDTO);
    //根据id查找妈妈关注的医生列表
    List<AttenDoctorDTO> getAttenDoctorListById(@Param("mid")Integer mid);
    //根据微信id查找妈妈未关注的医生列表
    List<AttenDoctorDTO> getUnAttenDoctorListById(@Param("mid")Integer mid);
    //通过微信openid查找到医生的id
    Integer getDoctorIdByOpenid(@Param("openid")String openid);
    //根据微信id获取医生对象
    GetDoctorDTO getGetDoctorDTOByOpenid(@Param("openid")String openid);
    //通过医生id查找医生姓名
    String getDoctorNameById(@Param("id")Integer id);
    //通过id查找openid
    String getOpenidById(@Param("id")Integer id);

}
