package com.gop3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gop3.dto.AttenDoctorDTO;
import com.gop3.dto.GetDoctorDTO;
import com.gop3.entity.AjaxResponse;
import com.gop3.po.Doctor;
import com.gop3.service.intf.AttentionService;
import com.gop3.utils.OpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by jinli on 2020/1/22 10:24
 */
@RestController
public class AttentionController {
    @Autowired
    AttentionService attentionService;
    /**
     * @Description:妈妈关注医生列表
     * @Author: jinli
     * @Date: 2020/2/13 11:56
     * @param wx_openid: 登陆凭证
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    @RequestMapping("/attenDoctorList")
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
    @RequestMapping("/unattenDoctorList")
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
    @RequestMapping("/getDoctor")
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
    @RequestMapping("/attendoctor")
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


}
