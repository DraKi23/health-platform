package com.gop3.service.impl;

import com.gop3.dto.*;
import com.gop3.mapper.AttentionMapper;
import com.gop3.mapper.DoctorMapper;
import com.gop3.mapper.MotherMapper;
import com.gop3.service.intf.AttentionService;
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
    private MotherMapper motherMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private AttentionMapper attentionMapper;
    /**
     * @Description:妈妈关注的医生列表
     * @Author: jinli
     * @Date: 2020/2/13 10:49
     * @param wx_openid:
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    public List<AttenDoctorDTO> getAttenDoctorListById(String wx_openid){
        Integer mid=motherMapper.getMotherIdByOpenid(wx_openid);
        List<AttenDoctorDTO> doctorList=attentionMapper.getAttenDoctorListById(mid);
        return doctorList;
    }
    /**
     * @Description:妈妈未关注医生列表
     * @Author: jinli
     * @Date: 2020/2/13 10:49
     * @param wx_openid:
     * @return: java.util.List<com.gop3.dto.AttenDoctorDTO>
     **/
    @Override
    public List<AttenDoctorDTO> getUnAttenDoctorListById(String wx_openid) {
        Integer mid=motherMapper.getMotherIdByOpenid(wx_openid);
        List<AttenDoctorDTO> doctorList=attentionMapper.getUnAttenDoctorListById(mid);
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
    public GetDoctorDTO getDoctorByWxId(String wx_openid )  {
        GetDoctorDTO getDoctorDTO=attentionMapper.getGetDoctorDTOByOpenid(wx_openid);
        return getDoctorDTO;
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
        return attentionMapper.insertDoctorMother(mid,did,currentTime);
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
        return attentionMapper.deleteDoctorMother(mid,did);
    }
    /**
     * @Description:关注医生的妈妈列表
     * @Author: jinli
     * @Date: 2020/2/17 22:03
     * @param wx_openid:
     * @return: java.util.List<com.gop3.dto.AttenMotherDTO>
     **/
    @Override
    public List<AttenMotherDTO> getAttenMotherListById(String wx_openid) {
        Integer did=doctorMapper.getDoctorIdByOpenid(wx_openid);
        List<AttenMotherDTO> doctorList=attentionMapper.getAttenMonterListById(did);
        return doctorList;
    }
    /**
     * @Description:获取某一位医生信息
     * @Author: jinli
     * @Date: 2020/2/17 22:57
     * @param wx_openid:
     * @return: com.gop3.dto.GetMotherDTO
     **/
    @Override
    public GetMotherReturnDTO getMotherByWxId(String wx_openid) {
        GetMotherReturnDTO getMotherReturnDTO=new GetMotherReturnDTO();
        GetMotherDTO getMotherDTO=attentionMapper.getGetMotherDTOByOpenid(wx_openid);
        if(getMotherDTO.getBaby_weeks()==null){
            getMotherReturnDTO.setIsBorn(-1);
        }
        else{
            getMotherReturnDTO.setIsBorn(1);
        }
        if (getMotherReturnDTO.getPregnant_weeks()==null){
            getMotherReturnDTO.setIsPregnant(-1);
        }
        else{
            getMotherReturnDTO.setIsPregnant(1);
        }
        getMotherReturnDTO.setAddress(getMotherDTO.getAddress());
        getMotherReturnDTO.setBaby_weeks(getMotherDTO.getBaby_weeks());
        getMotherReturnDTO.setBirthday(getMotherDTO.getBirthday());
        getMotherReturnDTO.setIcon(getMotherDTO.getIcon());
        getMotherReturnDTO.setName(getMotherDTO.getName());
        getMotherReturnDTO.setPhone(getMotherDTO.getPhone());
        getMotherReturnDTO.setPregnant_weeks(getMotherDTO.getPrenancy_weeks());
        return getMotherReturnDTO;
    }

}
