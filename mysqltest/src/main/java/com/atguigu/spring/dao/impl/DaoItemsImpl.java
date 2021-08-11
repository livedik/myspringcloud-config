package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.DaoItems;
import com.atguigu.springcloud.entities.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoItemsImpl implements DaoItems {

    @Override
    public List<Payment> findAll() throws SQLException {
        //把数据库结果集转成java的List集合
        List<Payment> list = new ArrayList<Payment>();
        //先获取contection对象
        Connection connection = null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //先获取contection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2020", "root", "root");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from payment");
            //执行数据库查询操作
            rs = pst.executeQuery();

            while (rs.next()){
                Payment payment = new Payment();
                payment.setId(rs.getLong("id"));
                payment.setSerial(rs.getString("serial"));
                list.add(payment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rs.close();
            pst.close();
            connection.close();
        }

        return null;
    }

}
