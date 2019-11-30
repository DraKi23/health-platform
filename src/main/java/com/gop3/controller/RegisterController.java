package com.gop3.controller;

import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Drgn on 2019/11/30 16:14
 */
@RestController
@RequestMapping("/reg")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    /**
     * @Description: 响应前台，返回用户是否注册的响应体
     * @Author: Drgn
     * @Date: 2019/11/30 16:27
     * @param openid: 微信用户的openid
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("user/{openid}")
    public AjaxResponse isRegisterByOpenid(@PathVariable String openid){
        boolean registerSuccess = registerService.isRegisterByOpenid(openid);
        return AjaxResponse.success(registerSuccess);
    }
}
