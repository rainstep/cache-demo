package com.example.cachedemo.service;

import com.example.cachedemo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    User get(int userId);

    User add(String userName);

    User update(int userId, String userName);

    boolean delete(int userId);

    void add(User user);

    void update(User user);

}
