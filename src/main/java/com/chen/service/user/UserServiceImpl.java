package com.chen.service.user;

import com.chen.dao.BaseDao;
import com.chen.dao.user.UserDao;
import com.chen.dao.user.UserDaoImpl;
import com.chen.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class UserServiceImpl implements UserService {
    // 业务层调用Dao层
    private UserDao userDao;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    public int updateUserPwd(Long id, String password) {
        Connection connection = null;
        int updateRows = 0;

        connection = BaseDao.getConnection();
        try {
            updateRows = userDao.updatePwd(connection, id, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            BaseDao.closeResource(connection, null, null);
        }
        return updateRows;
    }

//    @Test
//    public void test() {
//        UserServiceImpl userService = new UserServiceImpl();
//        User user = userService.login("wen", "123123");
//        System.out.println(user);
//    }
}
