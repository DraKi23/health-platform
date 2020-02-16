package com.gop3.controller;

import com.gop3.dto.ArticleDTO;
import com.gop3.service.intf.CheckArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by jinli on 2020/2/14 10:55
 */
@RestController
public class CheckArticleController {
    @Autowired
    CheckArticleService checkArticleService;

    /**
     * @Description:无参数返回所有文章信息
     * @Author: jinli
     * @Date: 2020/2/14 10:57
     * @return: java.util.List<com.gop3.po.Article>
     **/
    @RequestMapping("/checkAllAricle")
    public List<ArticleDTO> findAllArticle(){
        return checkArticleService.findAllArticle();
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
        return checkArticleService.SearchArticle(keywords);
    }
}
