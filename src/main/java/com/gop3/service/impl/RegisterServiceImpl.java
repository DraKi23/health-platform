package com.gop3.service.impl;

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
    public boolean isRegisterByOpenid(String openid) {
        //设置标记，默认为false
        boolean registerSuccess = false;

        //在数据库中查找用户信息
        Mother mother = motherMapper.getMotherByOpenid(openid);
        Doctor doctor = doctorMapper.getDoctorByOpenid(openid);

        //若两类用户有一类不为空，则表示用户已经注册
        if(mother!=null || doctor!=null){
            registerSuccess = true;
        }
        return registerSuccess;
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
