package com.example.cachedemo.entity;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1952488462294220989L;

    private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
