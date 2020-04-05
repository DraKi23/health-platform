package com.gop3.service.impl;

import com.gop3.dto.*;
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
    public CommentDetailForMomDTO getCommentDetailForMom(CommentDetailReqDTO commentDetailReqDTO) {
        System.out.println("我在种类大家乐福吖尬聊：" + commentDetailReqDTO);
        // 根据医生和妈妈的openID和上传时间寻找对应的相片列表
        Integer motherOpenid = motherMapper.getMotherIdByOpenid(commentDetailReqDTO.getMid());
        Integer doctorOpenid = doctorMapper.getDoctorIdByOpenid(commentDetailReqDTO.getDid());
        commentDetailReqDTO.setMotherID(motherOpenid);
        commentDetailReqDTO.setDoctorID(doctorOpenid);
        // 根据前台的请求标识寻找相关评论信息
        CommentDetailForMomDTO commentDetailForMomDTO = commentMapper.getCommentDetailForMom(commentDetailReqDTO);
        List<String> pictures = commentMapper.getCasePictureList(commentDetailReqDTO);
        commentDetailForMomDTO.setPicture(pictures);
        return commentDetailForMomDTO;
    }

    /**
     * @Description: 上传妈妈病例图片列表
     * @Author: Drgn
     * @Date: 2020/2/16 17:35
     * @param casePictureDTO: 前台上传的病例相关信息
     * @return: boolean
     *
     * 上传病例图片给医生：
     * 1、根据医生和妈妈的openID找到对应的表ID，完善casePictureDTO
     * 2、创建case表【caseID】记录mother_picture表记录
     * 3、创建comment表的记录
     **/
    @Override
    public boolean insertCasePictureInfo(CasePictureDTO casePictureDTO) {
        boolean insertSuccess = false;
        // 上传时间，即评论咨询记录创建时间
        Date submitTime = new Date();
        casePictureDTO.setSubmitTime(submitTime);
        // 获取表中医生和妈妈的ID
        Integer motherID = motherMapper.getMotherIdByOpenid(casePictureDTO.getMid());
        Integer doctorID = doctorMapper.getDoctorIdByOpenid(casePictureDTO.getDid());
        casePictureDTO.setMotherID(motherID);
        casePictureDTO.setDoctorID(doctorID);
        System.out.println(casePictureDTO);
        // 创建Case表记录
        int flag = commentMapper.insertCaseInfo(casePictureDTO);
        if(flag > 0){
            // 创建时间，该时间指的是生成上传病例图片记录的时间
            Date createPictureTime = new Date();
            casePictureDTO.setCreatePictureTime(createPictureTime);
            // 根据妈妈和医生openID和上传时间获取病历表的主键id
            Integer caseID = commentMapper.getCaseID(casePictureDTO);
            System.out.println("caseID = "+caseID);
            System.out.println(casePictureDTO);
            casePictureDTO.setCaseID(caseID);
            String pictureURL = casePictureDTO.getPictureURL();
            commentMapper.insertCasePictures(casePictureDTO);
            // 创建医疗建议记录
            Date bookTime = new Date();
            casePictureDTO.setBookTime(bookTime);
            System.out.println(casePictureDTO);
            commentMapper.insertCommentDetailByMom(casePictureDTO);
            // 程序执行到此处，表示所有数据插入成功
            insertSuccess = true;
        }
        return insertSuccess;
    }

    /**
     * @Description: 获取医生未处理的妈妈等待咨询的信息列表
     * @Author: Drgn
     * @Date: 2020/2/24 23:18
     * @param doctorOpenid: 医生用户的openID
     * @return: java.util.List<com.gop3.dto.UnResolveBookInfoDTO>
     **/
    @Override
    public List<UnResolveBookInfoDTO> getSimpleCommentListForDoc(String doctorOpenid) {
        return commentMapper.getSimpleCommentListForDoc(doctorOpenid);
    }

    /**
     * @Description: 插入医生医疗建议的记录到数据库中
     * @Author: Drgn
     * @Date: 2020/2/24 23:18
     * @param commentDetailByDocDTO: 前台上传的评论医疗建议
     * @return: int
     **/
    @Override
    public boolean insertCommentDetailByDoc(CommentDetailByDocDTO commentDetailByDocDTO) {
        Date create_time = new Date();
        commentDetailByDocDTO.setCreate_time(create_time);
        int i = commentMapper.insertCommentDetailByDoc(commentDetailByDocDTO);
        return i>0?true:false;
    }

    /**
     * @Description: 获取某一妈妈被处理的详情信息
     * @Author: Drgn
     * @Date: 2020/2/24 23:18
     * @param commentDetailReqDTO: 前台请求的医疗建议详情请求标识
     * @return: com.gop3.dto.CommentDetailByDocDTO
     **/
    @Override
    public CommentDetailByDocDTO getCommentDetailToDoc(CommentDetailReqDTO commentDetailReqDTO) {
        CommentDetailByDocDTO commentDetailByDocDTO = commentMapper.getCommentDetailToDoc(commentDetailReqDTO);
        List<String> pictures = commentMapper.getCasePictureList(commentDetailReqDTO);
        Integer motherOpenid = motherMapper.getMotherIdByOpenid(commentDetailReqDTO.getMid());
        Integer doctorOpenid = doctorMapper.getDoctorIdByOpenid(commentDetailReqDTO.getDid());
        commentDetailByDocDTO.setPictures(pictures);
        return commentDetailByDocDTO;
    }
}
