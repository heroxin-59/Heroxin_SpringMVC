package com.heroxin.controller;

import com.heroxin.domain.Role;
import com.heroxin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:24
 * @Description:
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private ModelAndView modelAndView;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<Role> roleList = roleService.list();

        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");

        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }

    @RequestMapping("/del/{roleId}")
    public String del(@PathVariable("roleId") long roleId){
        roleService.del(roleId);
        return "redirect:/role/list";
    }
}
