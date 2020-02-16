package com.gop3.mapper;

import com.gop3.dto.CasePictureDTO;
import com.gop3.dto.CommentDetailDTO;
import com.gop3.dto.CommentDetailReqDTO;
import com.gop3.dto.SimpleCommentDTO;
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
    CommentDetailDTO getCommentDetailForMom(CommentDetailReqDTO commentDetailReqDTO);
    // 获取妈妈与医生之间的病历表
    List<String> getCasePictureListForMom(CommentDetailReqDTO commentDetailReqDTO);

    // 创建上传给医生病例图片的记录
    int insertCasePicture(CasePictureDTO casePictureDTO);
}
