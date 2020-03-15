package com.gop3.service.impl;

import com.gop3.dto.BookInfoDTO;
import com.gop3.dto.BookReplyDTO;
import com.gop3.dto.BookedInfoDTO;
import com.gop3.dto.MyDoctorInfoDTO;
import com.gop3.mapper.BookMapper;
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

    /*
     *  医生相关的功能
     */
//    @Override
//    public List<BookVO> getBookedListForDoc(BookVO book) {
//        return null;
//    }
//
//    @Override
//    public boolean updateDocDeleted(BookVO book) {
//        return false;
//    }
//
//    @Override
//    public List<BookVO> getBookListForDoc(BookVO book) {
//        return null;
//    }
//
//    @Override
//    public boolean updateBookingState(BookVO book) {
//        return false;
//    }
}
