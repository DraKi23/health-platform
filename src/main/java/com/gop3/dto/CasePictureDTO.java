package com.gop3.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2020/2/15 15:06
 */
@Data
public class CasePictureDTO {
    private String mid;//妈妈openID
    private String did;//医生openid
    private Integer motherID;//妈妈的表id
    private Integer doctorID;//医生的表id
    private Integer caseID;//病例的表ID
    private String pictureURL;//单张病例照片的URL
    private List<String> picture;//病例照片列表
    private Date submitTime;//病例上传时间
    private Date createPictureTime;//创建病例照片表记录时间
}
