package com.heroxin.service.impl;

import com.heroxin.dao.RoleDao;
import com.heroxin.dao.UserDao;
import com.heroxin.domain.Role;
import com.heroxin.domain.User;
import com.heroxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:28
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
//            获得 user 的 id
            Long id = user.getId();
//            将 id 作为参数，查询当前 userId 对应的 Role 集合数据
            List<Role> roles = roleDao.fongRoleByUserId(id);

            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        //第一步 向sys_user表中存储数据
        Long userId = userDao.save(user);
        //第二步 向sys_user_role 关系表中存储多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(long userId) {
        userDao.delUserRole(userId);

        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.findByUser(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
