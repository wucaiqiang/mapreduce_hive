package com.wu.hadoop.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2020/07/06
 **/
@Slf4j
public class HiveConnectUtil {
    private String url = "jdbc:hive2://localhost:10000/default";
    private String username = "root";
    private String password = "123456";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(url, username, password);
            log.info("数仓链接创建成功，conn={}", conn);
        } catch (Exception e) {
            log.error("创建数据连接出现异常，e:{}", e);
        }
        if (conn == null) {
            throw new RuntimeException("获取连接失败");
        }
        return conn;
    }

    public void close(Connection connection) throws SQLException {
        if (connection != null) {
            try {
                connection.close();
                log.info("成功关闭连接，conn={}", connection);
            } catch (SQLException e) {
                throw e;
            }
        }
    }
}
