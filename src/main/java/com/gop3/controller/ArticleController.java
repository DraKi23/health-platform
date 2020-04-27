package com.gop3.controller;

import com.gop3.dto.ArticleDTO;
import com.gop3.entity.AjaxResponse;
import com.gop3.service.intf.ArticleService;
import com.gop3.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Create by jinli on 2020/2/14 10:55
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @Description:无参数返回所有文章信息
     * @Author: jinli
     * @Date: 2020/2/14 10:57
     * @return: java.util.List<com.gop3.po.Article>
     **/
    @RequestMapping("/checkAllAricle")
    public List<ArticleDTO> findAllArticle(){
        return articleService.findAllArticle();
    }

    /**
     * @Description:搜索文章
     * @Author: jinli
     * @Date: 2020/2/15 22:02
     * @param keywords:
     * @return: java.util.List<com.gop3.dto.ArticleDTO>
     **/
    @RequestMapping("/searchAricle")
    public List<ArticleDTO> SearchArticle(@RequestParam("keywords") String keywords){
        return articleService.SearchArticle(keywords);
    }
    /**
     * @Description:发表文章
     * @Author: jinli
     * @Date: 2020/2/18 22:25
     * @param articleDTO:
     * @return: com.gop3.entity.AjaxResponse
     **/
    @RequestMapping("/publishArticle")
    public AjaxResponse publishArticle(@RequestBody ArticleDTO articleDTO, MultipartFile articlePicture) {
        String path = UploadImageUtil.uploadImage(articlePicture);
        articleDTO.setPicture(path);
        boolean publishSuccess= articleService.publishArticle(articleDTO);
        return AjaxResponse.success(publishSuccess);
    }
}
