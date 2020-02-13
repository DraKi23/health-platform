package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by jinli on 2020/2/12 13:31
 */
@Data
public class RegDoctorDTO {
    Integer id;//医生id
    String name;//医生姓名
    String code;//微信登陆凭证
    String wx_openid;//微信id
    String phone;//电话号码
    String hospital;//医院
    String address;//地址
    String introduce;//医生介绍
    String icon;//医生用户头像url
    String credentials;//资格证书图片URL
    Date createTime;//医生用户创建时间
    Integer state;//医生用户状态，0表示正常、1表示禁用
}
