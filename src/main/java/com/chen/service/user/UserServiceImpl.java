package com.chen.service.user;

import com.chen.dao.BaseDao;
import com.chen.dao.user.UserDao;
import com.chen.dao.user.UserDaoImpl;
import com.chen.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements  UserService {
    // 业务层调用Dao层
    private UserDao userDao;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        connection = BaseDao.getConnection();
        try {
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return user;
    }

}
