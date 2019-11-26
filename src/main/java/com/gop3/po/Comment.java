package com.gop3.po;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2019/11/21 16:08
 */
@Data
public class Comment {
    private Integer id;//评论id
    private String context;//评论内容
    private Date createTime;//创建时间

    private Caze caze;//关联病历表，一对一
    private Doctor doctor;//关联医生表，一对一
    private Mother mother;//关联妈妈表，一对一
}
