package com.gop3.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gop3.dto.RegDoctorDTO;
import com.gop3.dto.RegMotherDTO;
import com.gop3.dto.RegisterDTO;
import com.gop3.mapper.DoctorMapper;
import com.gop3.mapper.MotherMapper;
import com.gop3.po.Doctor;
import com.gop3.po.Mother;
import com.gop3.service.intf.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by Drgn on 2019/11/30 15:57
 */
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private MotherMapper motherMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * @Description: 根据微信openid判断该用户是否注册
     * @Author: Drgn
     * @Date: 2019/11/30 15:58
     * @param openid: 微信用户openid
     * @return: boolean
     **/
    @Override
    public RegisterDTO getRegisterInfo(String openid) {
        //设置标记，默认为false
        boolean registerSuccess = false;
        boolean isMother = false;
        boolean isDoctor = false;
        RegisterDTO registerDTO = new RegisterDTO();
        //在数据库中查找用户信息
        Mother mother = motherMapper.getMotherByOpenid(openid);
        Doctor doctor = doctorMapper.getDoctorByOpenid(openid);
        //设置用户是否注册的标志
        if(mother != null){
            isMother = true;
        }
        if(doctor != null) {
            isDoctor = true;
        }
        registerSuccess = isMother || isDoctor;
        registerDTO.setMother(isMother);
        registerDTO.setDoctor(isDoctor);
        registerDTO.setRegister(registerSuccess);
        return registerDTO;
    }

    /**
     * @Description:医生注册填写的信息存入数据库
     * @Author: jinli
     * @Date: 2019/12/9 11:23
     * @param doctorDTto: 注册填写的信息
     * @return: java.lang.Boolean
     **/
    public Boolean insertDoctorData(RegDoctorDTO doctorDTto) {
        Boolean loginSuccess=false;
        doctorDTto.setState(1);
        loginSuccess=doctorMapper.insertDoctor(doctorDTto);
        return loginSuccess;
    }

    /**
     * @Description:妈妈注册填写的信息存入数据库
     * @Author: jinli
     * @Date: 2019/12/9 22:04
     * @param regMotherDTO: 注册填写的信息
     * @return: java.lang.Boolean
     **/
    @Override
    public Boolean insertMotherData(RegMotherDTO regMotherDTO) {
        Boolean loginSuccess=false;
        regMotherDTO.setState(1);
        loginSuccess=motherMapper.insertMother(regMotherDTO);
        return loginSuccess;
    }

}
