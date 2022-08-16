package com.chen.dao.user;

import com.chen.dao.BaseDao;
import com.chen.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements  UserDao{

    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm = null;
        User user = null;
        ResultSet resultSet = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};

                resultSet = BaseDao.execute(connection,sql, params, pstm, resultSet);

                if (resultSet.next()) {
                    user = new User();

                    user.setId((long) resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                }
            BaseDao.closeResource(null, pstm, resultSet);
        }

        return  user;
    }
}
