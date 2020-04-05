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
    private Integer motherID;//妈妈id
    private Integer doctorID;//医生id
    private Date bookTime;//上传咨询时间
    private String create_time;//回复日期
}
