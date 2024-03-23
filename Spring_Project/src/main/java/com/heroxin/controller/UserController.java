package com.heroxin.controller;

import com.heroxin.domain.Role;
import com.heroxin.domain.User;
import com.heroxin.service.RoleService;
import com.heroxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-24-17:29
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelAndView modelAndView;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<User> userList = userService.list();

        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        List<Role> roleList = roleService.list();

        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");

        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(String username,String password,HttpSession session){
        User user = userService.login(username,password);
        if(user!=null){
            //登录成功  将user存储到session
            session.setAttribute("user",user);
            return "redirect:/pages/main.jsp";
        }
        return "redirect:/login.jsp";
    }
}
