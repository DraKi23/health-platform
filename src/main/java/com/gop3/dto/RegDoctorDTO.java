package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by jinli on 2020/2/12 13:31
 */
@Data
public class RegDoctorDTO {
    private Integer id;//医生id
    private String name;//医生姓名
    private String code;//微信登陆凭证
    private String wx_openid;//微信id
    private String phone;//电话号码
    private String hospital;//医院
    private String address;//地址
    private String introduce;//医生介绍
    private String icon;//医生用户头像url
    private String credentials;//资格证书图片URL
    private Date createTime;//医生用户创建时间
    private Integer state;//医生用户状态，0表示正常、1表示禁用
}
