package com.gop3.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UploadImageUtil {

    private UploadImageUtil(){}

    public final static String UPLOAD_PATH_PREFIX = "static/images/";

    /**
     * @Description: 上传图片
     * @Author: Drgn
     * @Date: 2020/3/25 22:52
     * @param file: 图片文件
     * @return: java.lang.String 表示要存入数据库的相对路径
     **/
    public static String uploadImage(MultipartFile file){
        if(file == null){
            return null;
        }

        // 1、图片后缀校验
        String fileName = file.getOriginalFilename();
        String name = fileName.toLowerCase();
        if( !name.matches("^.+\\.(jpg|png|gif)$") ){
            return null;
        }

        // 2、安全校验
        try {
            BufferedImage read = ImageIO.read(file.getInputStream());
            int width = read.getWidth();
            int height = read.getHeight();
            if(width==0 || height==0){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3、分类存储校验
        // 创建文件要存储的文件夹名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        String format = sdf.format(new Date());
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        //存放上传文件的文件夹
        File subFile = new File(realPath + format);
        if (!subFile.isDirectory()) {
            //递归生成文件夹
            subFile.mkdirs();
        }

        // 4、重名问题
        String uuid = UUID.randomUUID().toString().replace("-","");
        // 获取指定字符的下标
        int index = fileName.lastIndexOf(".");
        String fileType = fileName.substring(index);
        String newFileName = uuid + fileType;

        // 5、上传图片
        try {
            File newFile = new File(subFile.getAbsolutePath() + File.separator + newFileName);
            file.transferTo(newFile);
            return format + newFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}