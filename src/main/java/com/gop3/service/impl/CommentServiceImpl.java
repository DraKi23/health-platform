package com.gop3.service.impl;

import com.gop3.dto.*;
import com.gop3.mapper.CommentMapper;
import com.gop3.mapper.DoctorMapper;
import com.gop3.mapper.MotherMapper;
import com.gop3.service.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        List<SimpleCommentDTO> list = commentMapper.getCommentListForMom(motherOpenid);
        return list;
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
        // 根据医生和妈妈的openID和上传时间寻找对应的相片列表
        Integer motherOpenid = motherMapper.getMotherIdByOpenid(commentDetailReqDTO.getMid());
        Integer doctorOpenid = doctorMapper.getDoctorIdByOpenid(commentDetailReqDTO.getDid());
        commentDetailReqDTO.setMotherID(motherOpenid);
        commentDetailReqDTO.setDoctorID(doctorOpenid);
        // 根据前台的请求标识寻找相关评论信息
        CommentDetailForMomDTO commentDetailForMomDTO = commentMapper.getCommentDetailForMom(commentDetailReqDTO);
        if(commentDetailForMomDTO!=null){
            List<String> pictures = commentMapper.getCasePictureList(commentDetailReqDTO);
            commentDetailForMomDTO.setPicture(pictures);
        }
        return commentDetailForMomDTO;
    }

    /**
     * @Description: 创建病例上传和咨询评论记录
     * @Author: Drgn
     * @Date: 2020/4/13 12:20
     * @param casePictureDTO: 必要的创建信息
     * @return: boolean 是否创建成功
     **/
    @Override
    public boolean insertCaseAndCommentForMom(CasePictureDTO casePictureDTO) {
        // 获取表中医生和妈妈的ID
        Integer motherID = motherMapper.getMotherIdByOpenid(casePictureDTO.getMid());
        Integer doctorID = doctorMapper.getDoctorIdByOpenid(casePictureDTO.getDid());
        casePictureDTO.setMotherID(motherID);
        casePictureDTO.setDoctorID(doctorID);
        // 病例记录创建时间
//        Date submitTime = new Date();
//        casePictureDTO.setSubmitTime(submitTime);
        int flag = commentMapper.insertCaseInfo(casePictureDTO);
        if(flag > 0){// 如果创建case表记录成功，再创建comment表记录
            Integer caseID = commentMapper.getCaseID(casePictureDTO);
//            Date bookTime = new Date();
            casePictureDTO.setCaseID(caseID);
//            casePictureDTO.setBookTime(bookTime);
            int insertNum = commentMapper.insertCommentDetailByMom(casePictureDTO);
            if(insertNum > 0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * @Description: 创建妈妈上传病例的相关记录
     * @Author: Drgn
     * @Date: 2020/4/13 11:57
     * @param casePictureDTO: 病例上传的必要信息
     * @return: boolean 是否创建记录成功
     *
     * 1、先创建case记录
     * 2、再创建picture记录
     **/
    @Override
    public boolean insertCasePictureForMom(@RequestBody CasePictureDTO casePictureDTO) {
        Integer motherID = motherMapper.getMotherIdByOpenid(casePictureDTO.getMid());
        Integer doctorID = doctorMapper.getDoctorIdByOpenid(casePictureDTO.getDid());
//        Date createPictureTime = new Date();
        casePictureDTO.setMotherID(motherID);
        casePictureDTO.setDoctorID(doctorID);
        Integer caseID = commentMapper.getCaseID(casePictureDTO);
        casePictureDTO.setCaseID(caseID);
//        casePictureDTO.setCreatePictureTime(createPictureTime);
        int flag = commentMapper.insertCasePictures(casePictureDTO);
        if(flag > 0){
            return true;
        }
        return false;
    }



//    /**
//     * @Description: 上传妈妈病例图片列表
//     * @Author: Drgn
//     * @Date: 2020/2/16 17:35
//     * @param casePictureDTO: 前台上传的病例相关信息
//     * @return: boolean
//     *
//     * 上传病例图片给医生：
//     * 1、根据医生和妈妈的openID找到对应的表ID，完善casePictureDTO
//     * 2、创建case表【caseID】记录mother_picture表记录
//     * 3、创建comment表的记录
//     *
//     * 注：后台中，bookTime就是上传图片时间，create_time就是医生回复时间
//     * 前台的create_time可能指的是上传图片时间或者医生回复时间
//     **/
//    @Override
//    public boolean insertCasePictureInfo(CasePictureDTO casePictureDTO) {
//        boolean insertSuccess = false;
//        // 上传时间，即评论咨询记录创建时间
//        Date submitTime = new Date();
//        casePictureDTO.setSubmitTime(submitTime);
//        // 获取表中医生和妈妈的ID
//        Integer motherID = motherMapper.getMotherIdByOpenid(casePictureDTO.getMid());
//        Integer doctorID = doctorMapper.getDoctorIdByOpenid(casePictureDTO.getDid());
//        casePictureDTO.setMotherID(motherID);
//        casePictureDTO.setDoctorID(doctorID);
//        // 创建Case表记录
//        int flag = commentMapper.insertCaseInfo(casePictureDTO);
//        if(flag > 0){
//            // 创建时间，该时间指的是生成上传病例图片记录的时间
//            Date createPictureTime = new Date();
//            casePictureDTO.setCreatePictureTime(createPictureTime);
//            // 根据妈妈和医生openID和上传时间获取病历表的主键id
//            Integer caseID = commentMapper.getCaseID(casePictureDTO);
//            casePictureDTO.setCaseID(caseID);
//            String pictureURL = casePictureDTO.getPictureURL();
//            commentMapper.insertCasePictures(casePictureDTO);
//            // 创建医疗建议记录
//            Date bookTime = new Date();
//            casePictureDTO.setBookTime(bookTime);
//            commentMapper.insertCommentDetailByMom(casePictureDTO);
//            // 程序执行到此处，表示所有数据插入成功
//            insertSuccess = true;
//        }
//        return insertSuccess;
//    }

    /**
     * @Description: 获取医生未处理的妈妈等待咨询的信息列表
     * @Author: Drgn
     * @Date: 2020/2/24 23:18
     * @param doctorOpenid: 医生用户的openID
     * @return: java.util.List<com.gop3.dto.UnResolveBookInfoDTO>
     **/
    @Override
    public List<SimpleCommentDTO> getSimpleCommentListForDoc(String doctorOpenid) {
        List<UnResolveBookInfoDTO> unResolveBookInfoDTOS=commentMapper.getSimpleCommentListForDoc(doctorOpenid);
        List<SimpleCommentDTO> simpleCommentDTOS = new ArrayList<SimpleCommentDTO>();
        for (int i=0;i<unResolveBookInfoDTOS.size();i++){
            SimpleCommentDTO simpleCommentDTO=new SimpleCommentDTO();
            simpleCommentDTO.setMid(unResolveBookInfoDTOS.get(i).getWx_openid());
            simpleCommentDTO.setCreate_time(unResolveBookInfoDTOS.get(i).getBookTime());
            simpleCommentDTO.setIcon(unResolveBookInfoDTOS.get(i).getIcon());
            simpleCommentDTO.setName(unResolveBookInfoDTOS.get(i).getName());
            simpleCommentDTOS.add(simpleCommentDTO);
        }
        return simpleCommentDTOS;
    }
    /**
     * @Description:获取医生已经处理的妈妈等待咨询的信息列表
     * @Author: jinli
     * @Date: 2020/4/23 19:11
     * @param doctorOpenid:
     * @return: java.util.List<com.gop3.dto.UnResolveBookInfoDTO>
     **/
    @Override
    public List<SimpleCommentDTO> getDealtCommentListForDoc(String doctorOpenid) {
        List<UnResolveBookInfoDTO> unResolveBookInfoDTOS=commentMapper.getDealtCommentListForDoc(doctorOpenid);
        List<SimpleCommentDTO> simpleCommentDTOS = new ArrayList<SimpleCommentDTO>();
        for (int i=0;i<unResolveBookInfoDTOS.size();i++){
            SimpleCommentDTO simpleCommentDTO=new SimpleCommentDTO();
            simpleCommentDTO.setMid(unResolveBookInfoDTOS.get(i).getWx_openid());
            simpleCommentDTO.setCreate_time(unResolveBookInfoDTOS.get(i).getBookTime());
            simpleCommentDTO.setIcon(unResolveBookInfoDTOS.get(i).getIcon());
            simpleCommentDTO.setName(unResolveBookInfoDTOS.get(i).getName());
            simpleCommentDTOS.add(simpleCommentDTO);
        }
        return simpleCommentDTOS;
    }

    /**
     * @Description: 插入医生医疗建议的记录到数据库中
     * @Author: Drgn
     * @Date: 2020/2/24 23:18
     * @param commentDetailReqDTO: 前台上传的评论医疗建议
     * @return: int
     **/
    @Override
    public boolean updateCommentDetailByDoc(CommentDetailReqDTO commentDetailReqDTO) {
//        Date create_time = new Date();
//        commentDetailByDocDTO.setCreate_time(create_time);
        commentDetailReqDTO.setMotherID( motherMapper.getMotherIdByOpenid(commentDetailReqDTO.getMid()));
        commentDetailReqDTO.setDoctorID( doctorMapper.getDoctorIdByOpenid(commentDetailReqDTO.getDid()));
        int i = commentMapper.updateCommentDetailByDoc(commentDetailReqDTO);
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
        commentDetailReqDTO.setMotherID( motherMapper.getMotherIdByOpenid(commentDetailReqDTO.getMid()));
        commentDetailReqDTO.setDoctorID( doctorMapper.getDoctorIdByOpenid(commentDetailReqDTO.getDid()));
        CommentDetailByDocDTO commentDetailByDocDTO = commentMapper.getCommentDetailToDoc(commentDetailReqDTO);
        List<String> pictures = commentMapper.getCasePictureList(commentDetailReqDTO);
        if(pictures.size()!=0&&commentDetailByDocDTO!=null){
            commentDetailByDocDTO.setPicture(pictures);
        }
        return commentDetailByDocDTO;
    }
}
