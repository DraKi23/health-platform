package com.gop3.mapper;

import com.gop3.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create by Drgn on 2020/2/15 15:19
 */
@Mapper
public interface CommentMapper {
    // 获取咨询医疗建议列表
    List<SimpleCommentDTO> getCommentListForMom(@Param("motherOpenid") String motherOpenid);
    // 获取某条咨询医疗建议的详细信息
    CommentDetailForMomDTO getCommentDetailForMom(CommentDetailReqDTO commentDetailReqDTO);
    // 获取妈妈与医生之间的病历表图片列表
    List<String> getCasePictureList(CommentDetailReqDTO commentDetailReqDTO);
    // 创建上传给医生病例记录
    int insertCaseInfo(CasePictureDTO casePictureDTO);
    // 创建病例图片记录
    int insertCasePictures(CasePictureDTO casePictureDTO);
    // 创建医疗建议记录
    int insertCommentDetailByMom(CasePictureDTO casePictureDTO);
    // 查找病例表记录id
    Integer getCaseID(CasePictureDTO casePictureDTO);

    // 获取医生未处理的妈妈等待咨询的信息列表
    List<UnResolveBookInfoDTO> getSimpleCommentListForDoc(@Param("doctorOpenid") String doctorOpenid);
    // 插入医生医疗建议的记录到数据库中
    int insertCommentDetailByDoc(CommentDetailByDocDTO commentDetailByDocDTO);
    // 获取某一妈妈被处理的详情信息
    CommentDetailByDocDTO getCommentDetailToDoc(CommentDetailReqDTO commentDetailReqDTO);
    // 获取医生已经处理的妈妈等待咨询的信息列表
    List<UnResolveBookInfoDTO> getDealtCommentListForDoc(@Param("doctorOpenid") String doctorOpenid);

}
