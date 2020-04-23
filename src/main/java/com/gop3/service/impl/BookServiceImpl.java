package com.gop3.service.impl;

import com.gop3.dto.*;
import com.gop3.mapper.BookMapper;
import com.gop3.mapper.DoctorMapper;
import com.gop3.mapper.MotherMapper;
import com.gop3.service.intf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2020/1/14 22:38
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private MotherMapper motherMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    /*
     * 妈妈相关的预约复诊功能
     */
    /**
     * @Description: 获取妈妈的预约复诊历史记录
     * @Author: Drgn
     * @Date: 2020/1/16 22:43
     * @param openid: 妈妈的openid
     * @return: java.util.List<com.gop3.entity.BookVO>
     **/
    @Override
    public List<BookedInfoDTO> getBookedListForMom(String openid) {
        return bookMapper.getAllBookedListForMom(openid);
    }

    /**
     * @Description: 创建妈妈提交的新预约复诊记录
     * @Author: Drgn
     * @Date: 2020/1/19 14:32
     * @param book: 预约信息对象
     * @return: boolean 判断插入预约记录是否成功
     **/
    @Override
    public boolean createBookInfo(BookInfoDTO book) {
        Integer mid = bookMapper.getMomId(book.getMother_openid());
        Integer did = bookMapper.getDocId(book.getDoctor_openid());
        Date currentTime  = new Date();
        book.setMid(mid);
        book.setDid(did);
        book.setCreateTime(currentTime);
        boolean createBookInfoFlag = bookMapper.createBookInfo(book);
        return createBookInfoFlag;
    }

    /**
     * @Description: 获取妈妈的关注医生列表
     * @Author: Drgn
     * @Date: 2020/2/11 22:10
     * @param openid: 妈妈的openids
     * @return: java.util.List<com.gop3.dto.MyDoctorInfoDTO>
     **/
    @Override
    public List<MyDoctorInfoDTO> getMyDocInfoList(String openid) {
        return bookMapper.getMyDocInfoList(openid);
    }

    /**
     * @Description:
     * @Author: jinli
     * @Date: 2020/2/25 13:54
     * @param doctor_openid:
     * @return: java.util.List<com.gop3.dto.BookReplyDTO>
     **/
    @Override
    public List<BookReplyDTO> getUnreplyBookList(String doctor_openid) {
        return bookMapper.getUnreplyBookList(doctor_openid);
    }

    @Override
    public List<BookReplyDTO> getreplyBookList(String doctor_openid) {
        return bookMapper.getReplyBookList(doctor_openid);
    }

    /**
     * @Description: 处理获取妈妈预约详情的逻辑
     * @Author: Drgn
     * @Date: 2020/4/22 19:17
     * @param bookInfoDetailReqDTO: 必要请求信息
     * @return: com.gop3.dto.BookInfoDetailDTO 返回的数据
     **/
    @Override
    public BookInfoDetailDTO getBookInfoDetailForDoc(BookInfoDetailReqDTO bookInfoDetailReqDTO) {
        // 根据openID获取表中的id
        Integer motherID = motherMapper.getMotherIdByOpenid(bookInfoDetailReqDTO.getMid());
        Integer doctorID = doctorMapper.getDoctorIdByOpenid(bookInfoDetailReqDTO.getDid());
        bookInfoDetailReqDTO.setMotherID(motherID);
        bookInfoDetailReqDTO.setDoctorID(doctorID);
        // 查询需要的数据
        BookInfoDetailDTO detailDTO = bookMapper.getBookInfoDetailForDoc(bookInfoDetailReqDTO);
        // 设置是否怀孕和出生
        int isPregnant = detailDTO.getPregnant_weeks()>0 ? 1:-1;
        int isBorn = detailDTO.getBaby_weeks()>0? 1:-1;
        detailDTO.setIsPregnant(isPregnant);
        detailDTO.setIsBorn(isBorn);
        return detailDTO;
    }
    /**
     * @Description:医生处理预约
     * @Author: jinli
     * @Date: 2020/4/23 11:47
     * @param doctor_openid: 医生openid
     * @param mother_openid: 妈妈openid
     * @param bookTime: 预约时间
     * @param isReturn: 处理情况
     * @return: java.lang.Boolean
     **/
    @Override
    public Boolean handleBook(String doctor_openid, String mother_openid, String bookTime, int isReturn) {
        int doctorId=doctorMapper.getDoctorIdByOpenid(doctor_openid);
        int motherId=motherMapper.getMotherIdByOpenid(mother_openid);
        System.out.println("萨哈的："+motherId);
        System.out.println("萨哈的："+doctorId);
        return bookMapper.updateBookState(doctorId,motherId,bookTime,isReturn);
    }
}
