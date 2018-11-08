package com.eason.mapper;

import com.eason.entity.BlogArticleCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
@CacheConfig(cacheNames = "articleCategory")
public interface BlogArticleCategoryMapper {

    @Select("select category_id as categoryId, category_name as categoryName from blog_article_category")
    List<BlogArticleCategory> getAllCategory();
}
