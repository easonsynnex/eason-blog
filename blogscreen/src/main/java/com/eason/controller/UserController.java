package com.eason.controller;

import com.eason.entity.BlogArticleCategory;
import com.eason.entity.User;
import com.eason.service.BlogArticleCategoryService;
import com.eason.service.UserService;
import com.eason.utils.FileUtils;
import com.eason.utils.email.EmailUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;
   /* @Autowired
    EmailUtils emailUtils;*/
	@Autowired
	JavaMailSender mailSender;

    @RequestMapping("/add")
    @ResponseBody
    public String addUser() throws Exception{
        User user = new User();
        user.setAge(24);
        user.setName("eason");
        user.setPassword("123456");
        userService.insertUser(user);
        return "success";
    }

    @RequestMapping("/queryUser/{name}")
    @ResponseBody
    public User queryUser(@PathVariable String name) throws Exception{
        User user = new User();
        user = userService.findByName(name);
        log.info("Log------------>"+user);

        return user;
    }
    @RequestMapping("/update")
    @ResponseBody
    public void updateUser() throws Exception{
        User user = new User();
        user.setId(2);
        user.setAge(22);
        user.setName("eason");
        user.setPassword("123456");
        userService.updataById(user);

    }

    @RequestMapping("/email")
    public void email() throws Exception{
    	String from = "1070388550@qq.com";
    	String to = "easony@synnex.com";
    	String subject = "Test";
    	String text = "test";
    	EmailUtils.sendEmail(from, to, subject, text, mailSender);
    }

    public void uploadImages(MultipartFile multipartFile) throws Exception{

    }
}
