package com.gop3.mapper;

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
}
