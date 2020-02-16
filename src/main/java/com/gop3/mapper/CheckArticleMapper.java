package com.gop3.mapper;

import com.gop3.dto.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckArticleMapper {
    //查看所有文章
     List<ArticleDTO> findAllArticle();
     //搜索文章
    List<ArticleDTO> SearchArticle(@Param("keywords") String keywords);
}
