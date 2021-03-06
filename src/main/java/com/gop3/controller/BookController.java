package com.gop3.controller;

import com.gop3.dto.*;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Create by Drgn on 2020/1/14 22:37
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @Description: 获取妈妈预约的历史记录列表
     * @Author: Drgn
     * @Date: 2020/2/10 22:59
     * @param mother_openid: 妈妈的小程序用户信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/mom/bookedList")
    public AjaxResponse getBookedInfoForMom(@RequestParam String mother_openid){
        List<BookedInfoDTO> bookedInfoDTOList = bookService.getBookedListForMom(mother_openid);
        return AjaxResponse.success(bookedInfoDTOList);
    }

    /**
     * @Description: 创建预约复诊记录
     * @Author: Drgn
     * @Date: 2020/2/11 22:17
     * @param bookInfoDTO: 预约复诊信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @PostMapping("/mom/bookInfo")
    public AjaxResponse createBookInfo(@RequestBody BookInfoDTO bookInfoDTO){
        boolean createBookInfoSuccess = bookService.createBookInfo(bookInfoDTO);
        return AjaxResponse.success(createBookInfoSuccess);
    }

    /**
     * @Description: 获取关注医生列表
     * @Author: Drgn
     * @Date: 2020/2/11 22:18
     * @param mother_openid: 妈妈的小程序用户信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/mom/myDocInfo")
    public AjaxResponse getMyDocInfoList(@RequestParam String mother_openid){
        List<MyDoctorInfoDTO> myDocInfoList = bookService.getMyDocInfoList(mother_openid);
        return AjaxResponse.success(myDocInfoList);
    }
    /**
     * @Description:返回还未处理的的预约列表
     * @Author: jinli
     * @Date: 2020/2/25 14:20
     * @param doctor_openid:
     * @return: java.util.List<com.gop3.dto.BookReplyDTO>
     **/
    @GetMapping("/mom/getUnreplyBook")
   public List<BookReplyDTO> getUnreplyBookList(@RequestParam String doctor_openid){
        return bookService.getUnreplyBookList(doctor_openid);
   }
   /**
    * @Description:返回已经回复的的预约列表
    * @Author: jinli
    * @Date: 2020/2/25 14:20
    * @param doctor_openid:
    * @return: java.util.List<com.gop3.dto.BookReplyDTO>
    **/
    @GetMapping("/mom/getreplyBook")
    public List<BookReplyDTO> getreplyBookList(@RequestParam String doctor_openid){
        return bookService.getreplyBookList(doctor_openid);
    }

    /**
     * @Description: 返回预约复诊的详情
     * @Author: Drgn
     * @Date: 2020/4/22 18:38
     * @param bookInfoDetailReqDTO: 必要的请求标识信息
     * @return: com.gop3.dto.BookInfoDetailDTO 返回的预约信息
     **/
    @GetMapping("/doc/detailbook")
    public BookInfoDetailDTO getBookInfoDetail(BookInfoDetailReqDTO bookInfoDetailReqDTO){
        return bookService.getBookInfoDetailForDoc(bookInfoDetailReqDTO);
    }
    /**
     * @Description:将医生处理妈妈预约复诊的结果存进数据库
     * @Author: jinli
     * @Date: 2020/4/23 11:51
     * @param did:openid
     * @param mid:openid
     * @param bookTime:
     * @param isReturn:
     * @return: java.lang.Boolean
     **/
    @GetMapping("/doc/handlebook")
     public Boolean handleBook(@RequestParam String did,
                               @RequestParam String mid,
                               @RequestParam String bookTime,
                               @RequestParam int isReturn){
         return bookService.handleBook(did,mid,bookTime,isReturn);
     }

}
