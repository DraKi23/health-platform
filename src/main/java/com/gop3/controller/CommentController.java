package com.gop3.controller;

import com.gop3.dto.*;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.CommentService;
import com.gop3.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Drgn on 2020/2/15 14:36
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * @Description: 获取咨询医疗建议列表
     * @Author: Drgn
     * @Date: 2020/2/17 16:24
     * @param mid: 妈妈的openID
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/comment/simple")
    /*public AjaxResponse getCommentListForMom(@RequestParam String mid){
        List<SimpleCommentDTO> commentList = commentService.getCommentListForMom(mid);
        return AjaxResponse.success(commentList);
    }*/
    public List<SimpleCommentShowDTO> getCommentListForMom(@RequestParam String mid){
        List<SimpleCommentShowDTO> commentList = commentService.getCommentListForMom(mid);
        return commentList;
    }

    /**
     * @Description: 获取某条咨询医疗建议的详细信息
     * @Author: Drgn
     * @Date: 2020/2/17 16:25
     * @param commentDetailReqDTO: 前台请求的信息标识
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/comment/detail")
    public AjaxResponse getCommentDetailForMom(CommentDetailReqDTO commentDetailReqDTO){
        CommentDetailForMomDTO commentDetailForMomDTO = commentService.getCommentDetailForMom(commentDetailReqDTO);
        return AjaxResponse.success(commentDetailForMomDTO);
    }

//    /**
//     * @Description: 上传妈妈病例图片列表
//     * @Author: Drgn
//     * @Date: 2020/2/17 16:25
//     * @param casePictureDTO: 前台上传的病例相关信息
//     * @return: com.gop3.entity.AjaxResponse
//     **/
//    @PostMapping("/case/pictures")
//    public AjaxResponse insertCasePictureInfo(CasePictureDTO casePictureDTO, MultipartFile casePicture){
//        String path = UploadImageUtil.uploadImage(casePicture);
//        casePictureDTO.setPictureURL(path);
//        boolean insertSuccess = commentService.insertCasePictureInfo(casePictureDTO);
//        return AjaxResponse.success(insertSuccess);
//    }

    /**
     * @Description: 创建上传病例和请求咨询的相关记录
     * @Author: Drgn
     * @Date: 2020/4/13 12:45
     * @param casePictureDTO: 必要的创建信息
     * @return: com.gop3.entity.AjaxResponse 是否成功创建
     **/
    @PostMapping("/case/comment")
    public AjaxResponse insertCaseAndCommentForMom(@RequestBody CasePictureDTO casePictureDTO){
        boolean flag = commentService.insertCaseAndCommentForMom(casePictureDTO);
        return AjaxResponse.success(flag);
    }

    /**
     * @Description: 创建上传的病例图片记录
     * @Author: Drgn
     * @Date: 2020/4/13 12:48
     * @param casePictureDTO: 必要的创建信息
     * @param casePicture: 接收的图片资源
     * @return: com.gop3.entity.AjaxResponse 是否成功创建
     **/
    @PostMapping("/case/picture")
    public AjaxResponse insertCasePicture(CasePictureDTO casePictureDTO, MultipartFile casePicture){
        String path = UploadImageUtil.uploadImage(casePicture);
        casePictureDTO.setPictureURL(path);
        boolean insertSuccess = commentService.insertCasePictureForMom(casePictureDTO);
        return AjaxResponse.success(insertSuccess);
    }

    /**
     * @Description: 获取医生未处理的妈妈等待咨询的信息列表
     * @Author: Drgn
     * @Date: 2020/2/24 23:35
     * @param doctorOpenid: 医生openID
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/doc/simple")
    public List<SimpleCommentDTO> getSimpleCommentInfo(@RequestParam("did") String doctorOpenid){
        List<SimpleCommentDTO> simpleCommentList= commentService.getSimpleCommentListForDoc(doctorOpenid);
        return simpleCommentList;
    }
    /**
     * @Description:获取医生已经处理的妈妈等待咨询的信息列表
     * @Author: jinli
     * @Date: 2020/4/23 19:13
     * @param doctorOpenid: 医生openID
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/doc/dealt")
    public List<SimpleCommentDTO> getDealtCommentInfo(@RequestParam("did") String doctorOpenid){
        List<SimpleCommentDTO> dealtCommentList= commentService.getDealtCommentListForDoc(doctorOpenid);
        return dealtCommentList;
    }
    /**
     * @Description: 插入医生医疗建议的记录到数据库中
     * @Author: Drgn
     * @Date: 2020/2/24 23:39
     * @param commentDetailReqDTO: 前台传入后台的医疗建议
     * @return: com.gop3.entity.AjaxResponse
     **/
    @PostMapping("/doc/add/detail")
    public AjaxResponse createCommentDetailByDoc(@RequestBody CommentDetailReqDTO commentDetailReqDTO){
        return AjaxResponse.success(commentService.updateCommentDetailByDoc(commentDetailReqDTO));
    }

    /**
     * @Description: 获取某一妈妈被处理的详情信息
     * @Author: Drgn
     * @Date: 2020/2/24 23:42
     * @param commentDetailReqDTO: 青苔请求的医疗建议详情标识
     * @return: com.gop3.entity.AjaxResponse
     **/
    @PostMapping("/doc/show/detail")
    public CommentDetailByDocDTO getCommentDetailToDoc(@RequestBody CommentDetailReqDTO commentDetailReqDTO){
        return commentService.getCommentDetailToDoc(commentDetailReqDTO);
    }

}
