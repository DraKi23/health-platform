package com.gop3.service.intf;

import com.gop3.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    //查看所有文章
    List<ArticleDTO> findAllArticle();
    //模糊搜索文章
    List<ArticleDTO> SearchArticle(String keywords);
    //发表文章
    Boolean publishArticle(ArticleDTO articleDTO);
}
