package com.eason.mapper;

import com.eason.entity.BlogArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogArticleMapper {

    @Insert("Insert into blog_article(category_id,article_name,digest,article_content) VALUES (#{categoryId},#{articleName},#{digest},#{articleContent})")
    void saveArticle(BlogArticle blogArticle);

    @Select("Select article_id as articleId ,category_id as categoryId, article_name AS articleName, article_click AS articleClick," +
            " article_type AS articleType, article_content AS articleContent, article_up AS articleUp, entry_id AS entryId, entry_datetime AS entryDatetime" +
            " from blog_article where article_id=#{id}")
    BlogArticle getArticle(@Param("id") int id);

    @Select("Select article_id as articleId ,category_id as categoryId, article_name AS articleName, article_click AS articleClick," +
            " article_type AS articleType, article_content AS articleContent, article_up AS articleUp, entry_id AS entryId, entry_datetime AS entryDatetime" +
            " from blog_article where show_index = 1 limit 1")
    BlogArticle getLatestArticle();

    @Select("Select article_id as articleId ,category_id as categoryId, article_name AS articleName, article_click AS articleClick," +
            " article_type AS articleType, article_content AS articleContent, article_up AS articleUp, entry_id AS entryId, entry_datetime AS entryDatetime" +
            " from blog_article ORDER BY entry_datetime desc limit #{count}")
    List<BlogArticle> getRecentArticles(@Param("count") int count);
}
