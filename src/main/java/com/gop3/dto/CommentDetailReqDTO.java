package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/2/15 14:57
 */
@Data
public class CommentDetailReqDTO {
    private String mid;//妈妈openid
    private String did;//医生openID
    private Date create_time;//上传日期
}
