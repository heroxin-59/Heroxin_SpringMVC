package com.heroxin.dao.impl;

import com.heroxin.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Heroxin
 * @create 2022-03-20-10:31
 * @Description:
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void show() {
        System.out.println("UserDaoImpl running...");
    }
}
