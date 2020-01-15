package com.example.cachedemo.dao;

import com.example.cachedemo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User get(int userId);

    void insert(User user);

    void update(User user);

    void delete(int userId);

}
