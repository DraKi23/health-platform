package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/2/23 22:12
 */
@Data
public class UnResolveBookInfoDTO {
    private String wx_openid;//妈妈openID
    private String icon;//妈妈头像URL
    private String name;//妈妈姓名
    private Date bookTime;//上传时间
}