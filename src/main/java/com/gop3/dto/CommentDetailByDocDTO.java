package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/2/23 22:34
 */
@Data
public class CommentDetailByDocDTO {
    private String did;//医生openID
    private String mid;//妈妈openID
    private Date create_time;//上传时间
    private String content;//评论内容
}
