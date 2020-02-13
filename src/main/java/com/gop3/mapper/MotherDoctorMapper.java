package com.gop3.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * Create by jinli on 2020/2/13 14:21
 */
@Mapper
public interface MotherDoctorMapper {
    //添加妈妈关注的医生到关注表
    Boolean insertDoctorMother(Integer mid, Integer did, Date create_time);
    //删除关注医生
    Boolean deleteDoctorMother(Integer mid, Integer did);
}
