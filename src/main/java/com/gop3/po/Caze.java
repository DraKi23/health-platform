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
    private Integer mid;//妈妈id
    private Integer did;//医生id
    private Integer pid;//病例图片id
}
