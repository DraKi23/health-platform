package com.gop3.po;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2019/11/14 16:22
 */
@Data
public class Doctor {
    private Integer id;//医生id
    private String name;//医生姓名
    private String wx_openid;//微信id
    private String phone;//电话号码
    private String hospital;//医院
    private String address;//地址
    private String introduce;//医生介绍
    private String icon;//医生用户头像url
    private String credentials;//资格证书图片URL
    private Date create_time;//医生用户创建时间
    private Integer state;//医生用户状态，0表示正常、1表示禁用

    private List<Mother> motherList;//关联妈妈表，多对多
}
