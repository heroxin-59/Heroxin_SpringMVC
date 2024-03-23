package com.heroxin.dao;

import com.heroxin.domain.User;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:28
 * @Description:
 */
public interface UserDao {

    public List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void del(long userId);

    void delUserRole(long userId);

    User findByUser(String username, String password);
}
