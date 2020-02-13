package com.gop3.controller;

import com.gop3.dto.BookInfoDTO;
import com.gop3.dto.BookedInfoDTO;
import com.gop3.dto.MyDoctorInfoDTO;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by Drgn on 2020/1/14 22:37
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * @Description: 获取妈妈预约的历史记录列表
     * @Author: Drgn
     * @Date: 2020/2/10 22:59
     * @param openid: 妈妈的微信openID
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/mom/bookedList/{openid}")
    public AjaxResponse getBookedInfoForMom(@PathVariable String openid){
        List<BookedInfoDTO> bookedInfoDTOList = bookService.getBookedListForMom(openid);
        return AjaxResponse.success(bookedInfoDTOList);
    }

    /**
     * @Description: 创建预约复诊记录
     * @Author: Drgn
     * @Date: 2020/2/11 22:17
     * @param bookInfoDTO: 预约复诊信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/mom/bookInfo")
    public AjaxResponse createBookInfo(BookInfoDTO bookInfoDTO){
        boolean createBookInfoSuccesss = false;
        createBookInfoSuccesss = bookService.createBookInfo(bookInfoDTO);
        return AjaxResponse.success(createBookInfoSuccesss);
    }

    /**
     * @Description: 获取关注医生列表
     * @Author: Drgn
     * @Date: 2020/2/11 22:18
     * @param openid: 妈妈的微信openID
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/mom/myDocInfo")
    public AjaxResponse getMyDocInfoList(String openid){
        List<MyDoctorInfoDTO> myDocInfoList = bookService.getMyDocInfoList(openid);
        return AjaxResponse.success(myDocInfoList);
    }

}
