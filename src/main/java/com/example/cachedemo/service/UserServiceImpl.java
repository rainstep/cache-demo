package com.example.cachedemo.service;

import com.example.cachedemo.dao.UserDao;
import com.example.cachedemo.entity.User;
import com.example.cachedemo.service.cache.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    private UserCacheService userCacheService;
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findByUserIdIn(List<Integer> userIdList) {
        return userDao.findByUserIdIn(userIdList);
    }

    @Override
    public Map<Integer, User> findMapByUserIdIn(List<Integer> userIdList) {
        List<User> list = userDao.findByUserIdIn(userIdList);
        Map<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.getUserId(), user);
        }
        return userMap;
    }

    @Override
    public List<User> findByUserNameLike(String userName) {
        if (userName == null) userName = "%";
        else userName = "%" + userName + "%";
        return userDao.findByUserNameLike(userName);
    }

    @Override
    public List<User> findByUserNameStartWith(String userName) {
        if (userName == null) userName = "%";
        else userName = userName + "%";
        return userDao.findByUserNameLike(userName);
    }

    @Override
    public List<User> findByUserNameEndWith(String userName) {
        if (userName == null) userName = "%%";
        else userName = "%" + userName;
        return userDao.findByUserNameLike(userName);
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

    @Override
    public void batchInsert(List<User> userList) {
        userDao.batchInsert(userList);
    }

    @Override
    public List<User> batchAdd(List<String> userNameList) {
        if (userNameList == null || userNameList.size() == 0) return new ArrayList<>();
        List<User> userList = new ArrayList<>();
        for (String userName : userNameList) {
            User user = new User();
            user.setUserName(userName);
            userList.add(user);
        }
        userDao.batchInsert(userList);
        return userList;
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
