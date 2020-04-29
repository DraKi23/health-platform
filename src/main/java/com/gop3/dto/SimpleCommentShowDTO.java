package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by jinli on 2020/4/28 12:57
 */
@Data
public class SimpleCommentShowDTO {
    private String did;//医生openid
    private String icon;//医生头像
    private String name;//医生姓名
    private String bookTime;//上传日期
}
