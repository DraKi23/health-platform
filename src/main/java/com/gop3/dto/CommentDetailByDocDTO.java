package com.gop3.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2020/2/23 22:34
 */
@Data
public class CommentDetailByDocDTO {
    private String did;//医生openID
    private String mid;//妈妈openID
    private Date bookTime;//上传时间
    private String content;//评论内容
    private String create_time;//评论时间
    private List<String> pictures;
}
