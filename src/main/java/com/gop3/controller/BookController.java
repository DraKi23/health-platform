package com.gop3.controller;

import com.gop3.dto.BookInfoDTO;
import com.gop3.dto.BookReplyDTO;
import com.gop3.dto.BookedInfoDTO;
import com.gop3.dto.MyDoctorInfoDTO;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/mom/myDocInfo/{mother_openid}")
    public AjaxResponse getMyDocInfoList(@PathVariable String mother_openid){
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
    @GetMapping("/mom/getUnreplyBook/{doctor_openid}")
   public List<BookReplyDTO> getUnreplyBookList(@PathVariable String doctor_openid){
        return bookService.getUnreplyBookList(doctor_openid);
   }
   /**
    * @Description:返回已经回复的的预约列表
    * @Author: jinli
    * @Date: 2020/2/25 14:20
    * @param doctor_openid:
    * @return: java.util.List<com.gop3.dto.BookReplyDTO>
    **/
    @GetMapping("/mom/getreplyBook/{doctor_openid}")
    public List<BookReplyDTO> getreplyBookList(@PathVariable String doctor_openid){
        return bookService.getreplyBookList(doctor_openid);
    }
}
