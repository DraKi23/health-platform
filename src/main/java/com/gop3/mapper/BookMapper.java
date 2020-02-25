package com.gop3.mapper;

import com.gop3.dto.BookInfoDTO;
import com.gop3.dto.BookReplyDTO;
import com.gop3.dto.BookedInfoDTO;
import com.gop3.dto.MyDoctorInfoDTO;
import com.gop3.po.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by Drgn on 2020/1/14 21:53
 */
@Mapper
public interface BookMapper {

    //通过妈妈的微信id获取妈妈的id
    Integer getMomId(String mom_openid);
    //通过医生的微信id获取医生的id
    Integer getDocId(String doc_openid);

    //妈妈相关
    //预约复诊历史记录查询(目前需要实现)
    List<BookedInfoDTO> getAllBookedListForMom(String openid);
    //预约复诊信息创建（目前需要实现）
    boolean createBookInfo(BookInfoDTO book);
    //获取关注医生列表
    List<MyDoctorInfoDTO> getMyDocInfoList(String openid);

//    //预约复诊信息查看
//    Book getBookInfoForMom(String openid);
//    //预约复诊信息修改
//    boolean updateBookInfo(Book book);
//    //预约复诊信息取消/删除
//    boolean deleteBookInfo(Book book);

    //这里有一个矛盾：删除历史记录，只要有医生或者妈妈任意一方删除历史记录，就会在数据库里删除一条记录
    //可是可能另一方可能想保存记录，所以应该如何处理？？？？？
//    //预约复诊历史记录删除
//    boolean deleteBookedInfo(Book book);
//    //修改妈妈的删除记录位mom_deleted
//    boolean updateDelStateForMom(Book book);
//    //修改医生的删除记录位doc_deleted
//    boolean updateDelStateForDoc(Book book);
//    //查询妈妈的删除记录位mom_deleted
//    Integer getMomDeleted(Book book);
//    //查询医生的删除记录位doc_deleted
//    Integer getDocDeleted(Book book);

    //医生相关
    //已处理预约信息列表查询
    List<Book> getAllBookedListForDoc(String openid);
    //未处理预约信息列表查看
    List<Book> getBookListForDoc(String openid);
    //未处理预约信息详细查看
    Book getBookInfoForDoc(String openid);
    //未处理预约信息处理（修改预约信息状态isReturn）
    boolean updateBookingState(Book book);

    //复诊回复
    //通过某位医生的openid查找未处理预约记录
    List<BookReplyDTO> getUnreplyBookList(String doctor_openid);
    //通过某位医生的openid查找已经处理预约记录
    List<BookReplyDTO> getreplyBookList(String doctor_openid);

}
