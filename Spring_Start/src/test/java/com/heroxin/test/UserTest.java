package com.heroxin.test;

import com.heroxin.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Heroxin
 * @create 2022-03-20-15:17
 * @Description:
 */
public class UserTest {
    @Test
    public void test01(){
        ApplicationContext app = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        userService.show();
    }
}
