package com.gop3.dto;

import lombok.Data;

/**
 * Create by jinli on 2020/2/12 22:08
 */
@Data
public class AttenDoctorDTO {
    private  String name;//医生姓名
    private  String wx_openid;//微信id
    private  String hospital;//医院
    private  String icon;//医生头像
}
