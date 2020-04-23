package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/2/10 21:59
 */
@Data
public class BookInfoDTO {
    private String mother_openid;//妈妈的微信openID
    private Integer mid;//妈妈的ID
    private String name;//妈妈的姓名
    private String phone;//预约的手机号码
    private String doctor_openid;//医生的openID
    private Integer did;//医生的ID
    private Date bookTime;//预约时间
    private Date createTime;//创建记录时间


}
