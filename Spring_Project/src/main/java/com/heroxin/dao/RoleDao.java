package com.heroxin.dao;

import com.heroxin.domain.Role;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:29
 * @Description:
 */
public interface RoleDao {
    public List<Role> findAll();

    public void save(Role role);

    public List<Role> fongRoleByUserId(Long id);

    void delUserRole(long roleId);

    void del(long roleId);
}
