package com.eason.service.serviceImpl;

import com.eason.entity.User;
import com.eason.mapper.UserMapper;
import com.eason.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updataById(User user) {
        userMapper.updataById(user);
    }

    @Override
    public void deleteById(String id) {
        userMapper.deleteById(id);
    }


}
