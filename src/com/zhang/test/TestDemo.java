package com.zhang.test;

import org.junit.Test;

import java.sql.*;

public class TestDemo {
    @Test
    public  void  testDemo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "123456");
        String sql = "select * from product";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
//        preparedStatement.setString(1,"1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + resultSet.getString("price"));
        }

        resultSet.close();
        preparedStatement.close();
        con.close();
    }
}
