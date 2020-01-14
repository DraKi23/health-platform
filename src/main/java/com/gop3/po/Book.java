package com.gop3.po;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/1/14 21:38
 */
@Data
public class Book {
    private Integer id;//表主键
    private Integer did;//医生ID
    private Integer mid;//妈妈ID
    private String name;//预约者姓名
    private String phone;//预约者联系方式
    private Date bookTime;//预约时间
    private Integer isReturn;//预约信息是否处理或者回复
    private Date create_time;//记录创建时间
}
