package com.gop3.service.impl;

import com.gop3.dto.DoctorEditInfoDTO;
import com.gop3.dto.MotherEditInfoDTO;
import com.gop3.mapper.DoctorMapper;
import com.gop3.mapper.MotherMapper;
import com.gop3.service.intf.EditInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by Drgn on 2020/4/30 15:41
 */
@Service
@Transactional
public class EditInfoServiceImpl implements EditInfoService {

    @Autowired
    private MotherMapper motherMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * @Description: 获取妈妈的相关信息
     * @Author: Drgn
     * @Date: 2020/4/30 16:06
     * @param motherOpenID:
     * @return: com.gop3.dto.MotherEditInfoDTO
     **/
    @Override
    public MotherEditInfoDTO getMotherInfo(String motherOpenID) {
        return motherMapper.getMotherInfo(motherOpenID);
    }

    /**
     * @Description: 修改妈妈的相关信息
     * @Author: Drgn
     * @Date: 2020/4/30 16:07
     * @param motherEditInfoDTO:
     * @return: boolean
     **/
    @Override
    public boolean updateMotherInfo(MotherEditInfoDTO motherEditInfoDTO) {
        return motherMapper.updateMotherInfo(motherEditInfoDTO);
    }

    /**
     * @Description: 获取医生的相关信息
     * @Author: Drgn
     * @Date: 2020/4/30 16:07
     * @param doctorOpenid:
     * @return: com.gop3.dto.DoctorEditInfoDTO
     **/
    @Override
    public DoctorEditInfoDTO getDocInfo(String doctorOpenid) {
        return doctorMapper.getDocInfo(doctorOpenid);
    }

    /**
     * @Description: 修改医生的相关信息
     * @Author: Drgn
     * @Date: 2020/4/30 16:07
     * @param doctorEditInfoDTO:
     * @return: boolean
     **/
    @Override
    public boolean updateDocInfo(DoctorEditInfoDTO doctorEditInfoDTO) {
        return doctorMapper.updateDocInfo(doctorEditInfoDTO);
    }

    /**
     * @Description: 修改医生的相关信息
     * @Author: Drgn
     * @Date: 2020/4/30 16:07
     * @param doctorEditInfoDTO:
     * @return: boolean
     **/
    @Override
    public boolean updateDocInfoIfUpdatePhoto(DoctorEditInfoDTO doctorEditInfoDTO) {
        return doctorMapper.updateDocInfoIfUpdatePhoto(doctorEditInfoDTO);
    }
}
