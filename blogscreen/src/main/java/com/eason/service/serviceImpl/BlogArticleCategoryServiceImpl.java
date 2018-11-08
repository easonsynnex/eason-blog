package com.eason.service.serviceImpl;

import com.eason.entity.BlogArticleCategory;
import com.eason.mapper.BlogArticleCategoryMapper;
import com.eason.service.BlogArticleCategoryService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogArticleCategoryServiceImpl implements BlogArticleCategoryService {
    @Autowired
    BlogArticleCategoryMapper blogArticleCategoryMapper;
    @Override
    public List<BlogArticleCategory> getAllCategory() {
        return blogArticleCategoryMapper.getAllCategory();
    }
}
