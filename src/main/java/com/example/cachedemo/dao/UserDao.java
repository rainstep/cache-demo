package com.example.cachedemo.dao;

import com.example.cachedemo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    List<User> findByUserNameLike(String userName);

    List<User> findByUserIdIn(List<Integer> userIdList);

    User get(int userId);

    void insert(User user);

    void update(User user);

    void delete(int userId);

    void batchInsert(List<User> userList);
}
