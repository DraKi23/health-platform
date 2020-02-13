package com.gop3.mapper;

import com.gop3.dto.RegMotherDTO;
import com.gop3.po.Mother;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Create by Drgn on 2019/11/26 23:11
 */
@Mapper
public interface MotherMapper {

    //根据微信id获取妈妈对象
    Mother getMotherByOpenid(@Param("openid")String openid);
    //将妈妈注册的信息存入数据库
    Boolean insertMother(RegMotherDTO regMotherDTO);
    //通过微信openid查找到妈妈的id
    Integer getMotherIdByOpenid(@Param("openid")String openid);
}
