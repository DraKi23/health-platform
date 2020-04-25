package com.gop3.po;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2019/11/21 16:06
 */
@Data
public class Picture {
    private Integer id;//病历图片id
    private String picture;//病例图片url
    private Date creteTime;//创建时间
    private Mother mother;//关联妈妈表，多对一
}
