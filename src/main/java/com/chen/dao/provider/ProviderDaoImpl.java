package com.chen.dao.provider;

import com.chen.dao.BaseDao;
import com.chen.pojo.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author chenxingyu
 * @date 2022/8/17
 */
public class ProviderDaoImpl implements ProviderDao {
    public Provider getProvider(Connection connection, String proCode) throws SQLException {
        PreparedStatement pstm = null;
        Provider provider = null;
        ResultSet resultSet = null;

        if (connection != null) {
            String sql = "select * from smbms_provider where id=?";
            Object[] params = {proCode};

            resultSet = BaseDao.execute(connection, sql, params, pstm, resultSet);

            if (resultSet.next()) {
                provider.setId(resultSet.getLong("id"));
                provider.setProCode(resultSet.getString("proCode"));
                provider.setProName(resultSet.getString("proName"));
                provider.setProDesc(resultSet.getString("proDesc"));
                provider.setProContact(resultSet.getString("proContact"));
                provider.setProPhone(resultSet.getString("proPhone"));
                provider.setProAddress(resultSet.getString("proAddress"));
                provider.setProFax(resultSet.getString("proFax"));
                provider.setCreatedBy(resultSet.getLong("createdBy"));
                provider.setCreationDate(resultSet.getDate("creationDate"));
                provider.setModifyBy(resultSet.getLong("modifyBy"));
                provider.setModifyDate(resultSet.getDate("modifyDate"));
            }

        }
        return  provider;
    }
}
