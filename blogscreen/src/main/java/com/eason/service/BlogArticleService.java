package com.eason.service;

import com.eason.entity.BlogArticle;

import java.util.List;

public interface BlogArticleService {
    public void saveArticle(BlogArticle article);
    public BlogArticle getArticle(int id);
    public BlogArticle getLatestArticle();
    public List<BlogArticle> getRecentArticles(int count);
}
