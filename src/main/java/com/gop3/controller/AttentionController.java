package com.gop3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gop3.dto.*;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by jinli on 2020/1/22 10:24
 */
@RestController
public class AttentionController {
    @Autowired
    private AttentionService attentionService;
    /**
     * @Description:妈妈关注医生列表
     * @Author: jinli
     * @Date: 2020/2/13 11:56
     * @param wx_openid: 登陆凭证
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    @GetMapping("/attenDoctorList")
    public List<AttenDoctorDTO> getDoctorList(@RequestParam("wx_openid") String wx_openid) throws JsonProcessingException {
        List<AttenDoctorDTO> doctorList=attentionService.getAttenDoctorListById(wx_openid);
        return doctorList;
    }


    /**
     * @Description:妈妈未关注的医生列表
     * @Author: jinli
     * @Date: 2020/2/13 11:56
     * @param wx_openid: 登陆凭证
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    @GetMapping("/unattenDoctorList")
    public List<AttenDoctorDTO> getUnDoctorList(@RequestParam("wx_openid") String wx_openid) throws JsonProcessingException {
        List<AttenDoctorDTO> doctorList=attentionService.getUnAttenDoctorListById(wx_openid);
        return doctorList;

    }


    /**
     * @Description:获取某一位医生的详细信息
     * @Author: jinli
     * @Date: 2020/2/13 11:57
     * @param wx_openid:前台传来的
     * @return: com.gop3.po.Doctor
     **/
    @GetMapping("/getDoctor")
    public GetDoctorDTO getDoctor(@RequestParam("wx_openid") String wx_openid) throws JsonProcessingException {
        return attentionService.getDoctorByWxId(wx_openid);

    }
    /**
     * @Description:妈妈关注医生
     * @Author: jinli
     * @Date: 2020/2/13 14:45
     * @param m_openid:
     * @param d_openid:
     * @return: com.gop3.entity.AjaxResponse
     **/
    @GetMapping("/attendoctor")
    public AjaxResponse addDoctorMother(@RequestParam String m_openid, @RequestParam String d_openid){
        Boolean attenSuccess = false;
        attenSuccess = attentionService.insertDoctorMother(m_openid,d_openid);
        return AjaxResponse.success(attenSuccess);
    }

    /**
     * @Description:妈妈取消关注某一位医生
     * @Author: jinli
     * @Date: 2020/2/13 15:37
     * @param m_openid:
     * @param d_openid:
     * @return: com.gop3.entity.AjaxResponse
     **/
    @RequestMapping("/canceldoctor")
    public AjaxResponse deleteDoctorMother(@RequestParam String m_openid, @RequestParam String d_openid){
        System.out.println(m_openid);
        Boolean cancelSuccess = false;
        cancelSuccess = attentionService.deleteDoctorMother(m_openid,d_openid);
        return AjaxResponse.success(cancelSuccess);
    }
    /**
     * @Description:关注医生的妈妈列表
     * @Author: jinli
     * @Date: 2020/2/17 22:06
     * @param wx_openid:
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    @GetMapping("/attenMotherList")
    public List<AttenMotherDTO> getMotherList(@RequestParam("wx_openid") String wx_openid){
        List<AttenMotherDTO> motherList=attentionService.getAttenMotherListById(wx_openid);
        return motherList;
    }
    /**
     * @Description:获取某一位妈妈信息
     * @Author: jinli
     * @Date: 2020/2/17 23:03
     * @param wx_openid:
     * @return: com.gop3.dto.GetMotherDTO
     **/
    @GetMapping("/getMother")
    public GetMotherReturnDTO getMother(@RequestParam("wx_openid") String wx_openid) {
        return attentionService.getMotherByWxId(wx_openid);

    }

}
