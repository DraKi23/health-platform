package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by jinli on 2020/2/25 13:10
 */
@Data
public class BookReplyDTO {
    private  String icon;//妈妈头像
    private  String name;//妈妈姓名
    private Date bookTime;//预约时间
    private String isReturn;//处理情况
    private String wx_openid;//妈妈openid
}
