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

                    user.setId(resultSet.getLong("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setAddress(resultSet.getString("address"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setCreatedBy(resultSet.getLong("createdBy"));
                    user.setCreateDate(resultSet.getDate("creationDate"));
                    user.setModifyBy(resultSet.getLong("modifyBy"));
                    user.setModifyDate(resultSet.getDate("modifyDate"));
                }
            BaseDao.closeResource(null, pstm, resultSet);
        }
        return  user;
    }

    public int updatePwd(Connection connection, Long id, String newPassword) throws SQLException {
        PreparedStatement pstm = null;
        int updatedRows = 0;

        if (connection != null){
            String sql = "insert into smbms_user (userPassword) values (?) where userCode=?";

            Object[] params = {newPassword, id};

            updatedRows = BaseDao.execute(connection, sql, params, pstm);

            BaseDao.closeResource(null, pstm, null);
        }

        return updatedRows;
    }
}
