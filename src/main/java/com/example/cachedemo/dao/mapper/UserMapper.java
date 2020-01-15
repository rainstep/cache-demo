package com.example.cachedemo.dao.mapper;

import com.example.cachedemo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select user_id, user_name from user")
    List<User> selectAll();

    @Select("select user_id, user_name from user where user_id = #{userId}")
    User get(Integer userId);

    @Insert("insert into user (user_name) values (#{userName})")
    void insert(User user);

    @Update("update user set user_name = #{userName} where user_id = #{userId}")
    void update(User user);

    @Delete("delete from user where user_id = #{userId}")
    void delete(Integer userId);

}
