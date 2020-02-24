package com.gop3.controller;

import com.gop3.dto.CasePictureDTO;
import com.gop3.dto.CommentDetailDTO;
import com.gop3.dto.CommentDetailReqDTO;
import com.gop3.dto.SimpleCommentDTO;
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
        CommentDetailDTO commentDetailDTO = commentService.getCommentDetailForMom(commentDetailReqDTO);
        return AjaxResponse.success(commentDetailDTO);
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

}
