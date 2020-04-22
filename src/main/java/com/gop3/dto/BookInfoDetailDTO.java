package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/4/22 18:10
 */
@Data
public class BookInfoDetailDTO {
    private String icon;//妈妈头像
    private String name;//妈妈姓名
    private String address;//地址
    private Integer isPregnant;//是否怀孕,-1表示未怀孕，1表示怀孕
    private Integer pregnant_weeks;//怀孕周数
    private Integer isBorn;//宝宝是否出生，-1表示未出生，1表示已出生
    private Integer baby_weeks;//宝宝出生周数
    private Date bookTime;//预约时间
    private Integer isReturn;//受理情况，未处理(-1)、拒绝(0)、接受(1)
}
