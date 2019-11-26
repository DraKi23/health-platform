package com.gop3.po;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2019/11/21 16:04
 */
@Data
public class Caze {
    private Integer id;//病例id
    private Date createTime;//创建时间

    private Mother mother;//关联妈妈表，一对一
    private Doctor doctor;//关联医生表，一对一
    private Picture picture;//关联病例图片表，一对一
}
