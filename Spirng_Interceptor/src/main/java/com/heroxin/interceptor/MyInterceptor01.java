package com.heroxin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Heroxin
 * @create 2022-03-22-18:01
 * @Description:
 */
public class MyInterceptor01 implements HandlerInterceptor {
    @Override
//    在目标方法执行前 执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        String param = request.getParameter("param");
//            /target?param=heroxin
        if ("heroxin".equals(param)){
            return true;
        }else {
            request.getRequestDispatcher("/jsp/error.jsp").forward(request,response);
            return false;// false代表拦截
        }

    }

    @Override
//    在目标方法执行后 视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        拦截后重新设置参数
        modelAndView.addObject("username","文静");
        System.out.println("postHandle...");
    }

    @Override
//    在流程都执行完毕后 执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
