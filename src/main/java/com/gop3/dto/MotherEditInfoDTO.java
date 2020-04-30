package com.gop3.dto;

import lombok.Data;

/**
 * Create by Drgn on 2020/4/30 15:27
 */
@Data
public class MotherEditInfoDTO {
    private String wx_openid;//妈妈的openID
    private String icon;//妈妈的头像
    private String name;//妈妈姓名
    private String phone;//妈妈电话号码
    private String address;//妈妈住址
    private Integer pregnant_weeks;//妈妈怀孕周数
    private Integer baby_weeks;//宝宝出生周数
}
