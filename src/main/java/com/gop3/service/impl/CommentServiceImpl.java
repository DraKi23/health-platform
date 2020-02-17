package com.gop3.service.impl;

import com.gop3.dto.CasePictureDTO;
import com.gop3.dto.CommentDetailDTO;
import com.gop3.dto.CommentDetailReqDTO;
import com.gop3.dto.SimpleCommentDTO;
import com.gop3.mapper.CommentMapper;
import com.gop3.mapper.DoctorMapper;
import com.gop3.mapper.MotherMapper;
import com.gop3.service.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2020/2/15 14:36
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private MotherMapper motherMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * @Description: 获取咨询医疗建议列表
     * @Author: Drgn
     * @Date: 2020/2/16 17:34
     * @param motherOpenid: 妈妈的openID
     * @return: java.util.List<com.gop3.dto.SimpleCommentDTO>
     **/
    @Override
    public List<SimpleCommentDTO> getCommentListForMom(String motherOpenid) {
        return commentMapper.getCommentListForMom(motherOpenid);
    }

    /**
     * @Description: 获取某条咨询医疗建议的详细信息
     * @Author: Drgn
     * @Date: 2020/2/16 17:34
     * @param commentDetailReqDTO: 前台请求的信息
     * @return: com.gop3.dto.CommentDetailDTO
     **/
    @Override
    public CommentDetailDTO getCommentDetailForMom(CommentDetailReqDTO commentDetailReqDTO) {
        // 根据前台的请求标识寻找相关评论信息
        CommentDetailDTO commentDetailDTO = commentMapper.getCommentDetailForMom(commentDetailReqDTO);
        // 根据医生和妈妈的openID和上传时间寻找对应的相片列表
        Integer motherOpenid = motherMapper.getMotherIdByOpenid(commentDetailReqDTO.getMid());
        Integer doctorOpenid = doctorMapper.getDoctorIdByOpenid(commentDetailReqDTO.getDid());
        List<String> pictures = commentMapper.getCasePictureListForMom(commentDetailReqDTO);
        commentDetailDTO.setPicture(pictures);
        return commentDetailDTO;
    }

    /**
     * @Description: 上传妈妈病例图片列表
     * @Author: Drgn
     * @Date: 2020/2/16 17:35
     * @param casePictureDTO: 前台上传的病例相关信息
     * @return: boolean
     **/
    @Override
    public boolean insertCasePictureInfo(CasePictureDTO casePictureDTO) {
        boolean insertSuccess = false;
        Date submitTime = new Date();
        casePictureDTO.setSubmitTime(submitTime);
        boolean flag = insertCasePictureInfo(casePictureDTO);
        if(flag){
            Date createPictureTime = new Date();
            casePictureDTO.setCreatePictureTime(createPictureTime);
            // 根据妈妈和医生openID和上传时间获取病历表的主键id
            Integer caseID = commentMapper.getCaseID(casePictureDTO);
            casePictureDTO.setCaseID(caseID);
            // 获取前台上传的病历图片集合
            List<String> pictures = casePictureDTO.getPictures();
            // 遍历每一张病例图片并插入到数据库对应的表中
            for(String pictureURL:pictures){
                casePictureDTO.setPictureURL(pictureURL);
                commentMapper.insertCasePictures(casePictureDTO);
            }
            // 程序执行到此处，表示所有数据插入成功
            insertSuccess = true;
        }
        return insertSuccess;
    }
}
