package com.gop3.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2020/2/15 15:06
 */
@Data
public class CommentDetailDTO {
    private String icon;//医生头像
    private String name;//医生姓名
    private Date create_time;//上传日期
    private List<String> picture;//病历表照片列表
    private String content;//评论内容
}
