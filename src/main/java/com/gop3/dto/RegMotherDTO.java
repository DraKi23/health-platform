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
    //添加字段
    private  String code;//登陆凭证

    private String icon;//妈妈头像url
    private String name;//妈妈姓名
    private String wx_openid;//微信openid
    private String phone;//电话号码
    private String address;//地址
    private String birthday;//出生日期
    private Integer prenancy_weeks;//怀孕周数
    private Integer baby_weeks;//宝宝出生周数

    private Date createTime;//妈妈用户创建时间
    private Integer state;//妈妈用户状态，0表示正常、1表示禁用

    private List<Doctor> doctorList;//关联医生表，多对多

}

