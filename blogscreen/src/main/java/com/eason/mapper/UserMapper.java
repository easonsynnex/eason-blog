package com.eason.mapper;

import com.eason.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    @Select("SELECT * FROM BLOG_USER WHERE NAME = #{name}")
    @Cacheable(key="#p0")
    User findByName(@Param("name") String name);

    @Insert("Insert into blog_user(NAME,AGE,PASSWORD) VALUES (#{name},#{age},#{password})")
    void insertUser(User user);

        /*
    @Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。

　　@CachePut，指定key，将更新的结果同步到redis中(不管怎样都会执行)

　　@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
     */

    @CachePut(key = "#user.name")
    @Update("update blog_user set name=#{name} where id=#{id}")
    public void updataById(User user);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    @Delete("delete from blog_user where id=#{id}")
    public void deleteById(@Param("id") String id);
}
