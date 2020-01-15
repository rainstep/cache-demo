package com.example.cachedemo.service.cache;

import com.example.cachedemo.entity.User;

import java.util.List;


public interface UserCacheService {
    List<User> findAllCache();

    void clearAllCache();

    User getCache(int userId);

    void clearCache(int userId);

}
