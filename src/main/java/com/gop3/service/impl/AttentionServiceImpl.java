package com.gop3.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gop3.dto.AttenDoctorDTO;
import com.gop3.mapper.DoctorMapper;
import com.gop3.mapper.MotherDoctorMapper;
import com.gop3.mapper.MotherMapper;
import com.gop3.po.Doctor;
import com.gop3.service.intf.AttentionService;
import com.gop3.utils.OpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Create by jinli on 2020/1/21 21:24
 */
@Service
@Transactional
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    MotherMapper motherMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    MotherDoctorMapper motherDoctorMapper;
    /**
     * @Description:妈妈关注的医生列表
     * @Author: jinli
     * @Date: 2020/2/13 10:49
     * @param code:
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    public List<AttenDoctorDTO> getAttenDoctorListById(String code) throws JsonProcessingException {
        String wx_openid=OpenIdUtil.getOpenid(code);
        Integer mid=motherMapper.getMotherIdByOpenid(wx_openid);
        List<AttenDoctorDTO> doctorList=doctorMapper.getAttenDoctorListById(mid);
        return doctorList;
    }
    /**
     * @Description:妈妈未关注医生列表
     * @Author: jinli
     * @Date: 2020/2/13 10:49
     * @param code:
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    @Override
    public List<AttenDoctorDTO> getUnAttenDoctorListById(String code) throws JsonProcessingException {
        String wx_openid=OpenIdUtil.getOpenid(code);
        Integer mid=motherMapper.getMotherIdByOpenid(wx_openid);
        List<AttenDoctorDTO> doctorList=doctorMapper.getUnAttenDoctorListById(mid);
        return doctorList;
    }
    /**
     * @Description:查询某一位医生的信息
     * @Author: jinli
     * @Date: 2020/2/13 10:50
     * @param wx_openid:前台传来的
     * @return: com.gop3.po.Doctor
     **/
    @Override
    public Doctor getDoctorByWxId(String wx_openid )  {
        Doctor doctor=doctorMapper.getDoctorByOpenid(wx_openid);
        return doctor;
    }
  /**
   * @Description:
   * @Author: jinli
   * @Date: 2020/2/13 14:40
   * @param m_openid:
   * @param d_openid:
   * @return: java.lang.Boolean
   **/
    @Override
    public Boolean insertDoctorMother(String m_openid, String d_openid) {
        Integer mid=motherMapper.getMotherIdByOpenid(m_openid);
        Integer did=doctorMapper.getDoctorIdByOpenid(d_openid);
        Date currentTime  = new Date();
        return motherDoctorMapper.insertDoctorMother(mid,did,currentTime);
    }
    /**
     * @Description:取消关注，删除关注表信息
     * @Author: jinli
     * @Date: 2020/2/13 15:24
     * @param m_openid:
     * @param d_openid:
     * @return: java.lang.Boolean
     **/
    @Override
    public Boolean deleteDoctorMother(String m_openid, String d_openid) {
        Integer mid=motherMapper.getMotherIdByOpenid(m_openid);
        Integer did=doctorMapper.getDoctorIdByOpenid(d_openid);
        return motherDoctorMapper.deleteDoctorMother(mid,did);
    }

}
