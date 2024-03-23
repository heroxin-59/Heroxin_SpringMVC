package com.heroxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Heroxin
 * @create 2022-03-22-17:34
 * @Description:
 */
@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show01(){
        System.out.println("目标资源执行...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","Heroxin");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
