package com.atguigu.spring.dao;

import com.atguigu.springcloud.entities.Payment;

import java.sql.SQLException;
import java.util.List;

public interface DaoItems {
    public List<Payment> findAll() throws SQLException;
}
