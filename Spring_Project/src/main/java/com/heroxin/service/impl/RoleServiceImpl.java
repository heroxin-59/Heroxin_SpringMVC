package com.heroxin.service.impl;

import com.heroxin.dao.RoleDao;
import com.heroxin.domain.Role;
import com.heroxin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:26
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void del(long roleId) {
        roleDao.delUserRole(roleId);
        roleDao.del(roleId);
    }
}
