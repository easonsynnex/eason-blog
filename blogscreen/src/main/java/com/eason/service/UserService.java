package com.eason.service;

import com.eason.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    public User findByName(String name);
    @Transactional
    public void insertUser(User user);

    public void updataById(User user);

    public void deleteById(String id);
}
