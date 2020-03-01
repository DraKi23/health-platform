package com.gop3.controller;

import com.gop3.dto.*;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/comment/simple/{mid}")
    public AjaxResponse getCommentListForMom(@PathVariable String mid){
        List<SimpleCommentDTO> commentList = commentService.getCommentListForMom(mid);
        return AjaxResponse.success(commentList);
    }

    /**
     * @Description: 获取某条咨询医疗建议的详细信息
     * @Author: Drgn
     * @Date: 2020/2/17 16:25
     * @param commentDetailReqDTO: 前台请求的信息标识
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/comment/detail")
    public AjaxResponse getCommentDetailForMom(@RequestBody CommentDetailReqDTO commentDetailReqDTO){
        CommentDetailForMomDTO commentDetailForMomDTO = commentService.getCommentDetailForMom(commentDetailReqDTO);
        return AjaxResponse.success(commentDetailForMomDTO);
    }

    /**
     * @Description: 上传妈妈病例图片列表
     * @Author: Drgn
     * @Date: 2020/2/17 16:25
     * @param casePictureDTO: 前台上传的病例相关信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @PostMapping("/case/pictures")
    public AjaxResponse insertCasePictureInfo(CasePictureDTO casePictureDTO){
        boolean insertSuccess = commentService.insertCasePictureInfo(casePictureDTO);
        return AjaxResponse.success(insertSuccess);
    }

    /**
     * @Description: 获取医生未处理的妈妈等待咨询的信息列表
     * @Author: Drgn
     * @Date: 2020/2/24 23:35
     * @param doctorOpenid: 医生openID
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/doc/simple/{did}")
    public AjaxResponse getSimpleCommentInfo(@PathVariable("did") String doctorOpenid){
        List<UnResolveBookInfoDTO> simpleCommentList= commentService.getSimpleCommentListForDoc(doctorOpenid);
        return AjaxResponse.success(simpleCommentList);
    }

    /**
     * @Description: 插入医生医疗建议的记录到数据库中
     * @Author: Drgn
     * @Date: 2020/2/24 23:39
     * @param commentDetailByDocDTO: 前台传入后台的医疗建议
     * @return: com.gop3.entity.AjaxResponse
     **/
    @PostMapping("/doc/add/detail")
    public AjaxResponse createCommentDetailByDoc(@RequestBody CommentDetailByDocDTO commentDetailByDocDTO){
        return AjaxResponse.success(commentService.insertCommentDetailByDoc(commentDetailByDocDTO));
    }

    /**
     * @Description: 获取某一妈妈被处理的详情信息
     * @Author: Drgn
     * @Date: 2020/2/24 23:42
     * @param commentDetailReqDTO: 青苔请求的医疗建议详情标识
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/doc/show/detail")
    public AjaxResponse getCommentDetailToDoc(@RequestBody CommentDetailReqDTO commentDetailReqDTO){
        return AjaxResponse.success(commentService.getCommentDetailToDoc(commentDetailReqDTO));
    }

}
