package com.gop3.dto;

import lombok.Data;

/**
 * Create by jinli on 2020/4/25 23:00
 */
@Data
public class GetMotherReturnDTO {
    private String name;//妈妈姓名
    private String phone;//电话号码
    private String address;//地址
    private String birthday;//宝宝出生日期
    private Integer pregnant_weeks;//怀孕周数
    private Integer baby_weeks;//宝宝出生周数
    private String icon;//妈妈头像url
    private Integer isPregnant;//是否怀孕，传送值-1或1）-1：未怀孕；1：怀孕
    private Integer isBorn;//是否出生，传送值-1或1）-1：未出生；1：出生
}
