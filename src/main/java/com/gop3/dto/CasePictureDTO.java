package com.gop3.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by Drgn on 2020/2/15 15:06
 */
@Data
public class CasePictureDTO {
    private String mid;//妈妈openID
    private String did;//医生openid
    private String pictureURL;//单张病例照片的URL
    private List<String> picture;//病例照片列表
}
