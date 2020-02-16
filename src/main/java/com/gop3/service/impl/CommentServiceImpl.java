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

        return null;
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
        return false;
    }
}
