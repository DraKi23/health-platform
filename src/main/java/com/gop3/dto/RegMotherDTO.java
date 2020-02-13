package com.gop3.dto;

import com.gop3.po.Doctor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by jinli on 2020/2/12 21:48
 */
@Data
public class RegMotherDTO {
    Integer id;//妈妈id
    String name;//妈妈姓名
    String wx_openid;//微信id
    String phone;//电话号码
    String address;//地址
    String birthday;//宝宝出生日期
    Integer pregnantWeeks;//怀孕周数
    Integer babyWeeks;//宝宝出生周数
    String icon;//妈妈头像url
    Date createTime;//妈妈用户创建时间
    Integer state;//妈妈用户状态，0表示正常、1表示禁用

    private List<Doctor> doctorList;//关联医生表，多对多
    //添加字段
    private  String code;//登陆凭证
}

