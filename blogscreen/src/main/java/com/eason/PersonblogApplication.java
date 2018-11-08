package com.eason;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
@ServletComponentScan
@EnableAutoConfiguration
@EnableCaching
@ComponentScan
//@EnableScheduling//开启定时任务
public class PersonblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonblogApplication.class, args);
	}
}
