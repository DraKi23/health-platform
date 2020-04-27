package com.gop3.service.impl;

import com.gop3.dto.ArticleDTO;
import com.gop3.mapper.ArticleMapper;
import com.gop3.mapper.DoctorMapper;
import com.gop3.service.intf.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * @Description:返回所有文章的信息
     * @Author: jinli
     * @Date: 2020/2/14 10:54
     * @return: java.util.List<com.gop3.po.Article>
     **/
    @Override
    public List<ArticleDTO> findAllArticle() {
        List<ArticleDTO> Articlelist= articleMapper.findAllArticle();
        for(ArticleDTO articleDTO: Articlelist) {
            articleDTO.setName(doctorMapper.getDoctorNameById(articleDTO.getDid()));
            articleDTO.setWx_openid(doctorMapper.getOpenidById(articleDTO.getDid()));
        }
        return articleMapper.findAllArticle();
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
        List<ArticleDTO> Articlelist= articleMapper.SearchArticle(keywords);
        for(ArticleDTO articleDTO: Articlelist) {
            articleDTO.setName(doctorMapper.getDoctorNameById(articleDTO.getDid()));
            articleDTO.setWx_openid(doctorMapper.getOpenidById(articleDTO.getDid()));
        }
        return Articlelist;
    }
    /**
     * @Description:发表文章
     * @Author: jinli
     * @Date: 2020/2/18 21:35
     * @param articleDTO:
     * @return: java.lang.Boolean
     **/
    @Override
    public Boolean publishArticle(ArticleDTO articleDTO) {
        //根据openid获取did
        articleDTO.setDid(doctorMapper.getDoctorIdByOpenid(articleDTO.getWx_openid()));
        System.out.println(articleDTO.getPicture());
        return articleMapper.insertArticle(articleDTO);
    }
}
