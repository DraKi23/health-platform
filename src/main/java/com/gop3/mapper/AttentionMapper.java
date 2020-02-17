package com.gop3.mapper;

import com.gop3.dto.AttenDoctorDTO;
import com.gop3.dto.AttenMotherDTO;
import com.gop3.dto.GetDoctorDTO;
import com.gop3.dto.GetMotherDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Create by jinli on 2020/2/13 14:21
 */
@Mapper
public interface AttentionMapper {
    //根据id查找妈妈关注的医生列表
    List<AttenDoctorDTO> getAttenDoctorListById(@Param("mid")Integer mid);
    //根据微信id查找妈妈未关注的医生列表
    List<AttenDoctorDTO> getUnAttenDoctorListById(@Param("mid")Integer mid);
    //根据微信id获取医生对象
    GetDoctorDTO getGetDoctorDTOByOpenid(@Param("openid")String openid);
    //添加妈妈关注的医生到关注表
    Boolean insertDoctorMother(Integer mid, Integer did, Date create_time);
    //删除关注医生
    Boolean deleteDoctorMother(Integer mid, Integer did);
    //通过医生id查找关注他的妈妈列表
    List<AttenMotherDTO> getAttenMonterListById(@Param("did") Integer did);
    //根据微信id获取医生对象
    GetMotherDTO getGetMotherDTOByOpenid(@Param("openid") String openid);

}
