package com.heroxin.dao.impl;

import com.heroxin.dao.RoleDao;
import com.heroxin.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:29
 * @Description:
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query
                ("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)",
                null,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> fongRoleByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query(
                "select r.roleName from sys_user_role ur,sys_role r where ur.roleId = r.id and ur.userId = ?",
                new BeanPropertyRowMapper<Role>(Role.class),
                id);
        return roles;
    }

    @Override
    public void delUserRole(long roleId) {
        jdbcTemplate.update("delete from sys_user_role where roleId = ?",roleId);
    }

    @Override
    public void del(long roleId) {
        jdbcTemplate.update("delete from sys_role where id = ?",roleId);
    }
}
