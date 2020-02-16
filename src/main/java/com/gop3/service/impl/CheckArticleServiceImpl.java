package com.gop3.service.impl;

import com.gop3.dto.ArticleDTO;
import com.gop3.mapper.CheckArticleMapper;
import com.gop3.mapper.DoctorMapper;
import com.gop3.service.intf.CheckArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CheckArticleServiceImpl implements CheckArticleService {
    @Autowired
    CheckArticleMapper checkArticleMapper;
    @Autowired
    DoctorMapper doctorMapper;

    /**
     * @Description:返回所有文章的信息
     * @Author: jinli
     * @Date: 2020/2/14 10:54
     * @return: java.util.List<com.gop3.po.Article>
     **/
    @Override
    public List<ArticleDTO> findAllArticle() {
        List<ArticleDTO> Articlelist=checkArticleMapper.findAllArticle();
        for(ArticleDTO articleDTO: Articlelist) {
            articleDTO.setName(doctorMapper.getDoctorNameById(articleDTO.getDid()));
            articleDTO.setWx_openid(doctorMapper.getOpenidById(articleDTO.getDid()));
        }
        return checkArticleMapper.findAllArticle();
    }
    /**
     * @Description:搜索文章
     * @Author: jinli
     * @Date: 2020/2/15 22:00
     * @param keywords: 搜索框的内容
     * @return: java.util.List<com.gop3.dto.ArticleDTO>
     **/
    @Override
    public List<ArticleDTO> SearchArticle(String keywords) {
        List<ArticleDTO> Articlelist=checkArticleMapper.SearchArticle(keywords);
        for(ArticleDTO articleDTO: Articlelist) {
            articleDTO.setName(doctorMapper.getDoctorNameById(articleDTO.getDid()));
            articleDTO.setWx_openid(doctorMapper.getOpenidById(articleDTO.getDid()));
        }
        return Articlelist;
    }
}
