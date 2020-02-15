package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/2/15 14:53
 */
@Data
public class SimpleCommentDTO {
    private String did;//医生openid
    private String icon;//医生头像
    private String name;//医生姓名
    private Date create_time;//上传日期
}
