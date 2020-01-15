package com.example.cachedemo.service.cache;

import com.example.cachedemo.dao.UserDao;
import com.example.cachedemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCacheServiceImpl implements UserCacheService {
    public static final Logger logger = LoggerFactory.getLogger(UserCacheService.class);
    private UserDao userDao;

    @Cacheable(value = "allCacheUserList")
    @Override
    public List<User> findAllCache() {
        logger.info("allCacheUserList");
        return userDao.findAll();
    }

    @CacheEvict(value = "allCacheUserList")
    @Override
    public void clearAllCache() {
        logger.info("clear allCacheUserList");
    }


    @Cacheable(value = "cacheUser", key = "#userId")
    @Override
    public User getCache(int userId) {
        logger.info("cacheUser, userId = {}", userId);
        return userDao.get(userId);
    }

    @CacheEvict(value = "cacheUser", key = "#userId")
    @Override
    public void clearCache(int userId) {
        logger.info("clear cacheUser, userId = {}", userId);
    }

    /* Setters */
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
