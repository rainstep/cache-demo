package com.example.cachedemo.service;

import com.example.cachedemo.dao.UserDao;
import com.example.cachedemo.entity.User;
import com.example.cachedemo.service.cache.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private UserCacheService userCacheService;
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User get(int userId) {
        return userDao.get(userId);
    }


    @Override
    public User add(String userName) {
        User user = new User();
        user.setUserName(userName);
        userDao.insert(user);
//        userCacheService.clearAllCache();
        return user;
    }

    @Override
    public User update(int userId, String userName) {
        User user = this.get(userId);
        user.setUserName(userName);
        userDao.update(user);
//        userCacheService.clearAllCache();
//        userCacheService.clearCache(userId);
        return user;
    }

    @Override
    public boolean delete(int userId) {
        userDao.delete(userId);
//        userCacheService.clearAllCache();
//        userCacheService.clearCache(userId);
        return true;
    }

    @Override
    public void add(User user) {
        userCacheService.clearAllCache();
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
//        userCacheService.clearAllCache();
//        userCacheService.clearCache(user.getUserId());
    }


    /* Setters */
    @Autowired
    public void setUserCacheService(UserCacheService userCacheService) {
        this.userCacheService = userCacheService;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    /* Setters */

}
