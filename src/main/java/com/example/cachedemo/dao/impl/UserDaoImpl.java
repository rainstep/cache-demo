package com.example.cachedemo.dao.impl;

import com.example.cachedemo.dao.UserDao;
import com.example.cachedemo.dao.mapper.UserMapper;
import com.example.cachedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User get(int userId) {
        return userMapper.get(userId);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(int userId) {
        userMapper.delete(userId);
    }

}
