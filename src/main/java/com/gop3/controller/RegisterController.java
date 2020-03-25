package com.gop3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gop3.dto.RegDoctorDTO;
import com.gop3.dto.RegMotherDTO;
import com.gop3.dto.RegisterDTO;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.RegisterService;
import com.gop3.utils.OpenIdUtil;
import com.gop3.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * Create by Drgn on 2019/11/30 16:14
 */
@RestController
@RequestMapping("/reg")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * @Description: 响应前台，返回用户是否注册的响应体
     * @Author: Drgn
     * @Date: 2019/11/30 16:27
     * @param openid: 微信用户的openid
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/user/info")
    public AjaxResponse getRegisterInfo(@RequestParam("wx_openid") String openid){
        RegisterDTO registerDTO = registerService.getRegisterInfo(openid);
        return AjaxResponse.success(registerDTO);
    }

    /**
     * @Description: 获取用户的openID
     * @Author: Drgn
     * @Date: 2020/2/15 16:11
     * @param code: 用后的小程序用户信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/user/openid")
    public AjaxResponse getOpenid(@RequestParam String code){
        String openid = null;
        try {
            openid = OpenIdUtil.getOpenid(code);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return AjaxResponse.success(openid);
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
    public AjaxResponse addDoctor(RegDoctorDTO regDoctorDTO, MultipartFile file) throws JsonProcessingException {
        //regDoctorDTO.setWx_openid(OpenIdUtil.getOpenid(regDoctorDTO.getCode()));
        String filePath = UploadImageUtil.uploadImage(file);
        if(filePath!=null){
            regDoctorDTO.setCredentials(filePath);
        }
        System.out.println(regDoctorDTO);
        Date currentTime  = new Date();
        regDoctorDTO.setCreateTime(currentTime);
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
       // regMotherDTO.setWx_openid(OpenIdUtil.getOpenid(regMotherDTO.getCode()));
        Date currentTime  = new Date();
        regMotherDTO.setCreateTime(currentTime );
        Boolean registerSuccess = false;
        registerSuccess = registerService.insertMotherData(regMotherDTO);
        return AjaxResponse.success(registerSuccess);
    }

}
