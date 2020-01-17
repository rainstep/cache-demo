package com.example.cachedemo.controller;

import com.example.cachedemo.entity.User;
import com.example.cachedemo.service.UserService;
import com.example.cachedemo.service.cache.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;
    private UserCacheService userCacheService;

    // 全部用户
    @GetMapping("/list")
    public List<User> list() {
        return userService.findAll();
    }

    // 全部缓存用户
    @GetMapping("/cacheList")
    public List<User> cacheUserList() {
        return userCacheService.findAllCache();
    }


    // 用户详细
    @GetMapping("/get")
    public User get(Integer userId) {
        return userService.get(userId);
    }

    // 缓存用户详情
    @GetMapping("/getCache")
    public User getCache(Integer userId) {
        return userCacheService.getCache(userId);
    }

    // 新增用户
    @GetMapping("/add")
    public List<User> add(String userName) {
        userService.add(userName);
        return userService.findAll();
    }

    // 更新用户
    @GetMapping("/update")
    public List<User> update(Integer userId, String userName) {
        userService.update(userId, userName);
        return userService.findAll();
    }

    // 删除用户
    @GetMapping("/delete")
    public List<User> delete(Integer userId) {
        userService.delete(userId);
        return userService.findAll();
    }

    // 清除全部缓存用户
    @GetMapping("/clearCacheList")
    public List<User> clearCacheList() {
        userCacheService.clearAllCache();
        return userCacheService.findAllCache();
    }

    // 清除缓存用户
    @GetMapping("/clearCache")
    public User clearCache(Integer userId) {
        userCacheService.clearCache(userId);
        return userCacheService.getCache(userId);
    }


    /* Setters */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserCacheService(UserCacheService userCacheService) {
        this.userCacheService = userCacheService;
    }
    /* Setters */
}
