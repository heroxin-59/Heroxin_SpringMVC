package com.heroxin.service;

import com.heroxin.domain.User;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:26
 * @Description:
 */

public interface UserService {
    public List<User> list();

    void save(User user, Long[] roleIds);

    void del(long userId);

    User login(String username, String password);
}
