package com.heroxin.service;

import com.heroxin.domain.Role;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:25
 * @Description:
 */
public interface RoleService {
    public List<Role> list();

    public void save(Role role);

    void del(long roleId);
}
