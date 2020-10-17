package com.gop3.controller;

import com.gop3.dto.DoctorEditInfoDTO;
import com.gop3.dto.MotherEditInfoDTO;
import com.gop3.service.intf.EditInfoService;
import com.gop3.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping("/doc/edit")
    public boolean updateDocInfo(@RequestBody DoctorEditInfoDTO doctorEditInfoDTO){
        return editInfoService.updateDocInfo(doctorEditInfoDTO);
    }

    /**
     * @Description: 如果图片被修改时，走这条接口进行信息的修改
     * @Author: Drgn
     * @Date: 2020/10/17 23:34
     * @param doctorEditInfoDTO:
     * @param crePicture:
     * @return: boolean
     **/
    @PostMapping("/doc/edit/update")
    public boolean updateDocInfoIfUpdate(DoctorEditInfoDTO doctorEditInfoDTO, MultipartFile crePicture){
        String path = UploadImageUtil.uploadImage(crePicture);
        // 如果修改的图片不能被存储，将可修改的信息修改，图片的路径不被修改
        if (path == null){
            return editInfoService.updateDocInfo(doctorEditInfoDTO);
        }
        doctorEditInfoDTO.setCredentials(path);
        return editInfoService.updateDocInfoIfUpdatePhoto(doctorEditInfoDTO);
    }


}
