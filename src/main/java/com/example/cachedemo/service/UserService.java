package com.example.cachedemo.service;

import com.example.cachedemo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    List<User>findByUserIdIn(List<Integer> userIdList);

    Map<Integer, User> findMapByUserIdIn(List<Integer> userIdList);

    List<User> findByUserNameLike(String userName);

    List<User> findByUserNameStartWith(String userName);

    List<User> findByUserNameEndWith(String userName);

    User get(int userId);

    User add(String userName);

    User update(int userId, String userName);

    boolean delete(int userId);

    void add(User user);

    void update(User user);

    void batchInsert(List<User> userList);

    List<User> batchAdd(List<String> userNameList);
}
