package com.gop3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gop3.dto.RegDoctorDTO;
import com.gop3.dto.RegMotherDTO;
import com.gop3.dto.RegisterDTO;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.RegisterService;
import com.gop3.utils.OpenIdUtil;
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
    OpenIdUtil openIdUtil=new OpenIdUtil();

    /**
     * @Description: 响应前台，返回用户是否注册的响应体
     * @Author: Drgn
     * @Date: 2019/11/30 16:27
     * @param code: 微信用户的openid
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("user/{code}")
    public AjaxResponse getRegisterInfo(@PathVariable String code){
        RegisterDTO registerDTO = registerService.getRegisterInfo(code);
        return AjaxResponse.success(registerDTO);
    }

    /**
     * @Description:获取医生注册填写的信息，存入数据库
     * @Author: jinli
     * @Date: 2019/12/9 11:21
     * @param regDoctorDTO:医生注册填写的信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @RequestMapping(value = {"/doctorRegister"},method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addDoctor(@RequestBody RegDoctorDTO regDoctorDTO) throws JsonProcessingException {
        regDoctorDTO.setWx_openid(openIdUtil.getOpenid(regDoctorDTO.getCode()));
        Date currentTime  = new Date();
        regDoctorDTO.setCreateTime(currentTime );
        Boolean registerSuccess = false;
        registerSuccess = registerService.insertDoctorData(regDoctorDTO);
        return AjaxResponse.success(registerSuccess);
    }

    /**
     * @Description:获取妈妈注册填写的信息，存入数据库
     * @Author: jinli
     * @Date: 2019/12/9 22:06
     * @param regMotherDTO: 妈妈注册填写的信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @RequestMapping(value = {"/motherRegister"},method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addMother(@RequestBody(required = false) RegMotherDTO regMotherDTO) throws JsonProcessingException {
        regMotherDTO.setWx_openid(openIdUtil.getOpenid(regMotherDTO.getCode()));
        Date currentTime  = new Date();
        regMotherDTO.setCreateTime(currentTime );
        Boolean registerSuccess = false;
        registerSuccess = registerService.insertMotherData(regMotherDTO);
        return AjaxResponse.success(registerSuccess);
    }

}
