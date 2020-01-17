package com.example.cachedemo.dao.impl;

import com.example.cachedemo.dao.UserDao;
import com.example.cachedemo.dao.mapper.UserMapper;
import com.example.cachedemo.entity.User;
import com.example.cachedemo.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<User> findByUserIdIn(List<Integer> userIdList) {
        if (userIdList == null || userIdList.size() == 0) return new ArrayList<>();
        UserExample example = new UserExample();
        example.createCriteria().andUserIdIn(userIdList);
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findByUserNameLike(String userName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameLike(userName);
        return userMapper.selectByExample(example);
    }

    @Override
    public User get(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(int userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void batchInsert(List<User> userList) {
        if (userList == null || userList.size() == 0) return;
        userMapper.batchInsert(userList);
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
