package com.gop3.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by Drgn on 2020/2/10 20:22
 */
@Data
public class BookedInfoDTO {
    private String icon;//医生头像
    private String doctor_name;//医生姓名
    private Date bookTime;//预约时间
    private Integer reply;//受理情况，分为：受理中，预约成功，预约失败
}
