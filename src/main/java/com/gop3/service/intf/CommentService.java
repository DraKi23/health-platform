package com.gop3.service.intf;

import com.gop3.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create by Drgn on 2020/2/15 14:35
 */
public interface CommentService {
    // 获取咨询医疗建议列表
    List<SimpleCommentDTO> getCommentListForMom(String motherOpenid);
    // 获取某条咨询医疗建议的详细信息
    CommentDetailForMomDTO getCommentDetailForMom(CommentDetailReqDTO commentDetailReqDTO);

    // 创建上传病例和咨询建议记录
    boolean insertCaseAndCommentForMom(CasePictureDTO casePictureDTO);
    // 创建上传的病例图片记录
    boolean insertCasePictureForMom(CasePictureDTO casePictureDTO);
    // 获取医生未处理的妈妈等待咨询的信息列表
    List<UnResolveBookInfoDTO> getSimpleCommentListForDoc(String doctorOpenid);
    // 获取医生已经处理的妈妈等待咨询的信息列表
    List<SimpleCommentDTO> getDealtCommentListForDoc(String doctorOpenid);
    // 插入医生医疗建议的记录到数据库中
    boolean insertCommentDetailByDoc(CommentDetailByDocDTO commentDetailByDocDTO);
    // 获取某一妈妈被处理的详情信息
    CommentDetailByDocDTO getCommentDetailToDoc(CommentDetailReqDTO commentDetailReqDTO);

}
