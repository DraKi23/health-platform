package com.gop3.po;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2019/11/21 15:58
 */
@Data
public class Article {
    private Integer id;//文章id
    private String title;//文章标题
    private String description;//文章描述
    private String text;//文章内容
    private String picture;//文章插图url
    private Date createTime;//文章创建时间
    private int type;//文章类型，1表所有人可见、2表关注我的可见、3表仅自己可见

    private Doctor doctor;//关联医生表，一对一
}
