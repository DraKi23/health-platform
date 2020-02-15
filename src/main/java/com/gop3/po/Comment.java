package com.gop3.po;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2019/11/21 16:08
 */
@Data
public class Comment {
    private Integer id;//评论id
    private String content;//评论内容
    private Date createTime;//创建时间
    private Integer did;//医生id
    private Integer mid;//妈妈id
}
