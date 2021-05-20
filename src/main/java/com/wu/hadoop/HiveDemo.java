package com.wu.hadoop;

import com.wu.hadoop.dto.Student;
import com.wu.hadoop.util.HiveConnectUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/04/22
 **/
public class HiveDemo {
    private static HiveConnectUtil hiveConnectUtil = new HiveConnectUtil();

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            connection = hiveConnectUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from student");
            while (resultSet.next()) {
                int id = resultSet.getInt(1); // 注意：索引从1开始
                String name = resultSet.getString(2);
                int age = resultSet.getInt(4);
                Student student = new Student(id, name, age);
                System.out.println(student);
            }
        } finally {
            hiveConnectUtil.close(connection);
        }
    }
}
