package com.eason.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils  {
    private static Logger log = LogManager.getLogger(RedisUtils.class);
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void setExpire(String key, Object value, long time){
        redisTemplate.opsForValue().set(key, value);
        expire(key, time);
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /*
    过期时间
     */
    public boolean expire(String key, long time){
        try{
            if(time > 0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }
    }
}
