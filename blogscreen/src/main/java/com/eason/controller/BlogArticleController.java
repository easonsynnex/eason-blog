package com.eason.controller;

import com.eason.entity.BlogArticle;
import com.eason.entity.BlogArticleCategory;
import com.eason.service.BlogArticleCategoryService;
import com.eason.service.BlogArticleService;
import com.eason.utils.FileUtils;
import com.eason.utils.RedisUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class BlogArticleController {
    private static Logger log = LogManager.getLogger(BlogArticle.class);
    private static final int SHOW_RECENT_ARTICLE_COUNT = 10;

    @Autowired
    BlogArticleService blogArticleService;

    @Autowired
    BlogArticleCategoryService blogArticleCategoryService;

    @Autowired
    RedisUtils redisUtils;

    @Value("${img.location}")
    private String imgLocation;

    /**
     * @Author: eason
     * @Description: 首页
     * @Date: 17:13 2018/5/6
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) throws Exception{
        BlogArticle blogArticle = blogArticleService.getLatestArticle();
        List<BlogArticle> recentArticles = blogArticleService.getRecentArticles(SHOW_RECENT_ARTICLE_COUNT);
        //如果内容太多截取部分
        String content = blogArticle.getArticleContent().substring(0,200);
        blogArticle.setArticleContent(content + "...");
        request.setAttribute("lateArticle", blogArticle);
        request.setAttribute("recentArticles", recentArticles);
        return "index";
    }

    /**
     * @Author: eason
     * @Description: writeArticle
     * @Date: 12:00 2018/5/6
     */
    @RequestMapping("/writeArticle")
    public String writeArticle() throws Exception{
        return "writeArticle";
    }

    /*
    保存文章信息
     */
    @RequestMapping("/save")
    @ResponseBody
    public void saveArticle(@Param("articleName") String articleName ,
                            @Param("digest") String digest,
                            @Param("content") String content,
                            @Param("category") Integer category,
                            HttpServletRequest request) throws Exception{
        BlogArticle article = new BlogArticle();
        article.setArticleName(articleName);
        article.setDigest(digest);
        article.setArticleContent(content);
        article.setCategoryId(category);
        blogArticleService.saveArticle(article);
    }

    /*
    展示文章
     */
    @RequestMapping("/show/{id}")
    public String showArticle(@PathVariable int id, HttpServletRequest request) throws Exception{
        BlogArticle blogArticle = blogArticleService.getArticle(id);
        request.setAttribute("blog", blogArticle);
        Object category = getAllCategory(request);
        request.setAttribute("allCategory", category);
        return "article";
    }

    /*
    获取文章所有分类
     */
    @RequestMapping("/getAllCategory")
    @ResponseBody
    public List<BlogArticleCategory> getAllCategory(HttpServletRequest request) throws Exception{
        List<BlogArticleCategory> blogArticleCategory = (List<BlogArticleCategory>)redisUtils.get("allCategory");
        if(blogArticleCategory == null || blogArticleCategory.isEmpty()){
            blogArticleCategory = blogArticleCategoryService.getAllCategory();
            redisUtils.set("allCategory", blogArticleCategory);
        }
        return blogArticleCategory;
    }

    /*
    上传图片
     */
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public void uploadImg(HttpServletRequest request, HttpServletResponse response) throws Exception{
        FileUtils.ckeditor(request, response, imgLocation);
        System.out.println("UPLOAD IMAGE --------->");
    }
}
