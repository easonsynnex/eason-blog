package com.eason.service.serviceImpl;

import com.eason.entity.BlogArticle;
import com.eason.mapper.BlogArticleMapper;
import com.eason.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogArticleServiceImpl implements BlogArticleService{

    @Autowired
    BlogArticleMapper blogArticleMapper;
    @Override
    public void saveArticle(BlogArticle article) {
        blogArticleMapper.saveArticle(article);
    }

    @Override
    public BlogArticle getArticle(int id) {
        BlogArticle blogArticle = blogArticleMapper.getArticle(id);
        return blogArticle;
    }

    @Override
    public BlogArticle getLatestArticle() {
        BlogArticle blogArticle = blogArticleMapper.getLatestArticle();
        String content = blogArticle.getArticleContent();
        return blogArticle;
    }

    @Override
    public List<BlogArticle> getRecentArticles(int count) {
        List<BlogArticle> recentArticles =  blogArticleMapper.getRecentArticles(count);
        return recentArticles;
    }

    public String getContentRemoveHtmlTag(String content){
        String regx = "</?*>";
        return "";
    }
}
