package com.gop3.dto;

import lombok.Data;

/**
 * Create by Drgn on 2020/4/30 15:27
 */
@Data
public class DoctorEditInfoDTO {
    private String wx_openid;//医生的openID
    private String icon;//医生头像
    private String name;//医生姓名
    private String phone;//医生电话号码
    private String hospital;//医生所在医院
    private String address;//医生住处地址
    private String introduce;//医生个人简介
    private String credentials;//医生资格证书URL
}
