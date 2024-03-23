package com.heroxin.service.impl;

import com.heroxin.dao.UserDao;
import com.heroxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Heroxin
 * @create 2022-03-20-10:36
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void show() {
        userDao.show();
        System.out.println("UserServiceImpl running...");
    }
}
