package com.chen.dao.user;

import com.chen.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    // 得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
    public int updatePwd(Connection connection, Long id, String newPassword) throws SQLException;
}
