package com.gop3.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2019/11/14 15:59
 */
@Data
public class Mother {
    private Integer id;//妈妈id
    private String name;//妈妈姓名
    private String wx_openid;//微信id
    private String phone;//电话号码
    private String address;//地址
    private String birthday;//宝宝出生日期
    private Integer pregnantWeeks;//怀孕周数
    private Integer babyWeeks;//宝宝出生周数
    private String icon;//妈妈头像url
    private Date createTime;//妈妈用户创建时间
    private Integer state;//妈妈用户状态，0表示正常、1表示禁用

    private List<Doctor> doctorList;//关联医生表，多对多
}
