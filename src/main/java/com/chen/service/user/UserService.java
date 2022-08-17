package com.chen.service.user;

import com.chen.pojo.User;

public interface UserService {
    // 用户登录
    public User login(String userCode, String password);
}
