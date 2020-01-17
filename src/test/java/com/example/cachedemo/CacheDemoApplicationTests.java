package com.example.cachedemo;

import com.example.cachedemo.entity.User;
import com.example.cachedemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CacheDemoApplicationTests {
    public static final Logger logger = LoggerFactory.getLogger(CacheDemoApplicationTests.class);

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    void contextLoads() {


    }

    @Test
    void batchInsert() {
        List<String> userNameList = new ArrayList<>();
        int count = 10;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMDDHHmmss");
        String timeStr = dateFormat.format(new Date());
        for (int i = 0; i < count; i++) {
            userNameList.add("user_" + timeStr + "_" + (i + 1));
        }
        List<User> userList = userService.batchAdd(userNameList);
        assert userList.size() == count;
    }

}
