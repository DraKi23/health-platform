package com.gop3.service.intf;

import com.gop3.dto.*;

import java.util.List;

/**
 * Create by Drgn on 2020/1/14 22:38
 */
public interface BookService {
    //妈妈相关
    //查看预约历史记录
    List<BookedInfoDTO> getBookedListForMom(String openid);
    //创建预约复诊记录
    boolean createBookInfo(BookInfoDTO book);
    //获取关注医生列表
    List<MyDoctorInfoDTO> getMyDocInfoList(String openid);

    // 医生相关
    //回复预约
    //通过某位医生的openid查找未处理预约记录
    List<BookReplyDTO> getUnreplyBookList(String doctor_openid);
    //通过某位医生的openid查找已经处理预约记录
    List<BookReplyDTO> getreplyBookList(String doctor_openid);
    // 医生获取某一位妈妈的预约详情
    BookInfoDetailDTO getBookInfoDetailForDoc(BookInfoDetailReqDTO bookInfoDetailReqDTO);

}
