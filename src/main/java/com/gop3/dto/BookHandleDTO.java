package com.gop3.dto;

import lombok.Data;

/**
 * Create by jinli on 2020/4/23 17:54
 */
@Data
public class BookHandleDTO {
    private String did;//医生openid
    private String mid;//妈妈openid
    private String bookTime;
    private int isReturn;
}
