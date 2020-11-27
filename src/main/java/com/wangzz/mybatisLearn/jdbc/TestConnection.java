package com.wangzz.mybatisLearn.jdbc;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://152.136.28.224:3306/metabase?useSSL=false&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8",
                "sdic","B1J0TdJh");
        PreparedStatement preparedStatement = connection.prepareStatement("update bi_loan set scene_id = 0 where  id =2");
        int i = preparedStatement.executeUpdate();
        connection.close();
    }

}
