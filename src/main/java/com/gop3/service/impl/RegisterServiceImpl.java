package com.gop3.service.impl;

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
    MotherMapper motherMapper;
    @Autowired
    DoctorMapper doctorMapper;

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
     * @param doctor: 注册填写的信息
     * @return: java.lang.Boolean
     **/
    @Override
    public Boolean insertDoctorData(Doctor doctor) {
        Boolean loginSuccess=false;
        loginSuccess=doctorMapper.insertDoctor(doctor);
        return loginSuccess;
    }

    /**
     * @Description:妈妈注册填写的信息存入数据库
     * @Author: jinli
     * @Date: 2019/12/9 22:04
     * @param mother: 注册填写的信息
     * @return: java.lang.Boolean
     **/
    @Override
    public Boolean insertMotherData(Mother mother) {
        Boolean loginSuccess=false;
        loginSuccess=motherMapper.insertMother(mother);
        return loginSuccess;
    }

}
