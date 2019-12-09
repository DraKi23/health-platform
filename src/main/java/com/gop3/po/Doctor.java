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
@AllArgsConstructor
@Builder
public class Doctor {
    Integer id;//医生id
    String name;//医生姓名
    String wx_openid;//微信id
    String phone;//电话号码
    String hospital;//医院
    String address;//地址
    String introduce;//医生介绍
    String icon;//医生用户头像url
    String credentials;//资格证书图片URL
    Date createTime;//医生用户创建时间
    Integer state;//医生用户状态，0表示正常、1表示禁用

    private List<Mother> motherList;//关联妈妈表，多对多
}
