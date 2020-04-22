package com.gop3.dto;

import lombok.Data;

/**
 * Create by Drgn on 2020/4/22 18:27
 */
@Data
public class BookInfoDetailReqDTO {
    private String mid;//妈妈的openID
    private String did;//医生的openID
    private Integer motherID;//妈妈表id
    private Integer doctorID;//医生表id
    private String bookTime;//妈妈预约的时间
}
