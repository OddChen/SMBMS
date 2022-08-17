package com.chen.dao.provider;

import com.chen.pojo.Provider;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author chenxingyu
 * @date 2022/8/17
 */
public interface ProviderDao {
    public Provider getProvider(Connection connection, String proCode) throws SQLException;
}
