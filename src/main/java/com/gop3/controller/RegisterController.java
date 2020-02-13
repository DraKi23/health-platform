package com.gop3.controller;

import com.gop3.dto.RegisterDTO;
import com.gop3.entity.AjaxResponse;
import com.gop3.po.Doctor;
import com.gop3.po.Mother;
import com.gop3.service.intf.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    public AjaxResponse getRegisterInfo(@PathVariable String openid){
        RegisterDTO registerDTO = registerService.getRegisterInfo(openid);
        return AjaxResponse.success(registerDTO);
    }

    /**
     * @Description:获取医生注册填写的信息，存入数据库
     * @Author: jinli
     * @Date: 2019/12/9 11:21
     * @param doctor:医生注册填写的信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @RequestMapping(value = {"/doctorRegister"},method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addDoctor(@RequestBody(required = false) Doctor doctor) {
        //@requestparam获取不到json格式的前台数据
        //存入数据库的，要把表的字段编码修改（一个字段一个字段修改才起作用，修改整张表无效）
        Date currentTime  = new Date();
        doctor.setCreateTime(currentTime );
        Boolean registerSuccess = false;
        registerSuccess = registerService.insertDoctorData(doctor);
        return AjaxResponse.success(registerSuccess);
    }

    /**
     * @Description:获取妈妈注册填写的信息，存入数据库
     * @Author: jinli
     * @Date: 2019/12/9 22:06
     * @param mother: 妈妈注册填写的信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @RequestMapping(value = {"/motherRegister"},method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addMother(@RequestBody(required = false) Mother mother) {
        Date currentTime  = new Date();
        mother.setCreateTime(currentTime );
        Boolean registerSuccess = false;
        registerSuccess = registerService.insertMotherData(mother);
        return AjaxResponse.success(registerSuccess);
    }

}
