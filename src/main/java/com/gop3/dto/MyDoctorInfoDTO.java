package com.gop3.dto;

import lombok.Data;

/**
 * Create by Drgn on 2020/2/11 21:40
 */
@Data
public class MyDoctorInfoDTO {
    private String doctor_openid;//医生openID
    private String doctor_name;//医生姓名
    private String hospital;//医生所在医院
    private String icon;//医生头像
}
