package com.gop3.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by Drgn on 2020/2/15 15:06
 */
@Data
public class CasePictureDTO {
    private String code;//妈妈小程序用户信息
    private String did;//医生openID
    private List<String> picture;//病例照片列表
}
