package com.gop3.mapper;

import com.gop3.po.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Create by Drgn on 2019/11/30 15:49
 */
@Mapper
public interface DoctorMapper {

    //根据微信id获取医生对象
    Doctor getDoctorByOpenid(@Param("openid")String openid);
    //将医生注册的信息存入数据库
    Boolean insertDoctor(Doctor doctor);
}
