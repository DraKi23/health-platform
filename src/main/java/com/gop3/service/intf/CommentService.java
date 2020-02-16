package com.gop3.service.intf;

import com.gop3.dto.CasePictureDTO;
import com.gop3.dto.CommentDetailDTO;
import com.gop3.dto.CommentDetailReqDTO;
import com.gop3.dto.SimpleCommentDTO;

import java.util.List;

/**
 * Create by Drgn on 2020/2/15 14:35
 */
public interface CommentService {
    // 获取咨询医疗建议列表
    List<SimpleCommentDTO> getCommentListForMom(String motherOpenid);
    // 获取某条咨询医疗建议的详细信息
    CommentDetailDTO getCommentDetailForMom(CommentDetailReqDTO commentDetailReqDTO);
    // 上传妈妈病例图片列表
    boolean insertCasePictureInfo(CasePictureDTO casePictureDTO);
}
