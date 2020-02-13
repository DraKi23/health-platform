package com.gop3.service.intf;

import com.gop3.dto.BookInfoDTO;
import com.gop3.dto.BookedInfoDTO;
import com.gop3.dto.MyDoctorInfoDTO;

import java.util.List;

/**
 * Create by Drgn on 2020/1/14 22:38
 */
public interface BookService {
    //妈妈相关
    //查看预约历史记录
    List<BookedInfoDTO> getBookedListForMom(String code);
    //创建预约复诊记录
    boolean createBookInfo(BookInfoDTO book);
    //获取关注医生列表
    List<MyDoctorInfoDTO> getMyDocInfoList(String openid);


    //医生相关
//    //查看已处理的预约历史记录
//    List<BookVO> getBookedListForDoc(BookVO book);
//    //修改医生删除记录的标志位字段doc_deleted
//    boolean updateDocDeleted(BookVO book);
//    //查看未处理的预约记录
//    List<BookVO> getBookListForDoc(BookVO book);
//    //回复未处理的预约记录,修改预约复诊的状态位
//    boolean updateBookingState(BookVO book);
}
