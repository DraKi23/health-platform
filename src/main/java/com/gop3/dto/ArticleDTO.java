package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by jinli on 2020/2/15 21:56
 */
@Data
public class ArticleDTO {
    private String title;//文章标题
    private String wx_openid;//医生openid
    private Integer did;//医生id
    private String name;//医生姓名
    private String description;//文章描述
    private String context;//文章内容
    private String picture;//文章插图url
    private String create_time;//文章创建时间
    private Integer type;//权限类型
}
