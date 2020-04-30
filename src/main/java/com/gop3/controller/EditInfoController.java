package com.gop3.controller;

import com.gop3.dto.DoctorEditInfoDTO;
import com.gop3.dto.MotherEditInfoDTO;
import com.gop3.service.intf.EditInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Drgn on 2020/4/30 13:58
 */
@RestController
public class EditInfoController {
    @Autowired
    private EditInfoService editInfoService;

    /**
     * @Description: 获取妈妈的相关信息
     * @Author: Drgn
     * @Date: 2020/4/30 15:47
     * @param motherOpenid:
     * @return: com.gop3.dto.MotherEditInfoDTO
     **/
    @GetMapping("/mom/edit/show")
    public MotherEditInfoDTO getMotherInfo(@RequestParam String motherOpenid){
        return editInfoService.getMotherInfo(motherOpenid);
    }

    /**
     * @Description: 编辑修改妈妈的信息记录
     * @Author: Drgn
     * @Date: 2020/4/30 15:47
     * @param motherEditInfoDTO:
     * @return: boolean
     **/
    @GetMapping("/mom/edit")
    public boolean updateMotherInfo(@RequestBody MotherEditInfoDTO motherEditInfoDTO){
        return editInfoService.updateMotherInfo(motherEditInfoDTO);
    }

    /**
     * @Description: 获取医生的相关信息
     * @Author: Drgn
     * @Date: 2020/4/30 15:47
     * @param docOpenid:
     * @return: com.gop3.dto.DoctorEditInfoDTO
     **/
    @GetMapping("/doc/edit/show")
    public DoctorEditInfoDTO getDocInfo(@RequestParam String docOpenid){
        return editInfoService.getDocInfo(docOpenid);
    }

    /**
     * @Description: 编辑修改医生的信息记录
     * @Author: Drgn
     * @Date: 2020/4/30 15:48
     * @param doctorEditInfoDTO:
     * @return: boolean
     **/
    @GetMapping("/doc/edit")
    public boolean updateDocInfo(@RequestBody DoctorEditInfoDTO doctorEditInfoDTO){
        return editInfoService.updateDocInfo(doctorEditInfoDTO);
    }


}
