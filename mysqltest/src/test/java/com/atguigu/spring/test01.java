package com.atguigu.spring;

import com.atguigu.spring.dao.DaoItems;
import com.atguigu.spring.dao.impl.DaoItemsImpl;
import com.atguigu.springcloud.entities.Payment;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class test01 {

    @Test
    public void test01() throws SQLException {
        DaoItems itemsDao = new DaoItemsImpl();
        List<Payment> list = itemsDao.findAll();
        for (Payment payment : list) {
            System.out.println(payment);
        }
    }
}
