package com.gop3.dto;

import lombok.Data;

/**
 * Create by jinli on 2020/2/16 14:16
 */
@Data
public class GetDoctorDTO {
    private String name;//医生姓名
    private String phone;//电话号码
    private String hospital;//医院
    private String address;//地址
    private String introduce;//医生介绍
    private String icon;//医生用户头像url
    private String credentials;//资格证书图片URL
}
