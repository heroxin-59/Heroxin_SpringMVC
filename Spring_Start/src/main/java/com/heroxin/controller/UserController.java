package com.heroxin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroxin.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-20-14:27
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

//    请求地址 .../user/quick
    @RequestMapping("/quick01")
    public String show01(){
        System.out.println("UserController running...");
        return "success";
    }

    @RequestMapping("/quick02")
    public ModelAndView  show02(){
        /*
            model:模型 用来封装数据
            view: 视图 用来展示数据
        */
        ModelAndView modelAndView = new ModelAndView();
//         设置视图数据
        modelAndView.addObject("username","Heroxin");
//        设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick03")
    public ModelAndView  show03(ModelAndView modelAndView){
//         设置视图数据
        modelAndView.addObject("username","Heroxin");
//        设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

//   也可以把model和view拆开写
    @RequestMapping("/quick04")
    public String show04(Model model){
        model.addAttribute("username","Heroxin");
        return "success";
    }

//    使用Java Web 时的方法
    @RequestMapping("/quick05")
    public String show05(HttpServletRequest request){
        request.setAttribute("username","Heroxin");
        return "success";
    }

//    回写数据 javaweb
    @RequestMapping("/quick06")
    public void show06(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Heroxin");
        response.getWriter().println("李鑫");
    }


    @RequestMapping("/quick07")
    @ResponseBody  //告知springmvc不进行视图跳转，直接进行回写数据
    public String show07(){
        return "success running";
    }

//  手写 JSON 格式字符串，spring-mvc没配置时测试
//    JSON(JavaScript Object Notation)
//      是一种轻量级的数据交换格式。易于人阅读和编写。同时也易于机器解析和生成。
    @RequestMapping("/quick08")
    @ResponseBody  //告知springmvc不进行视图跳转，直接进行回写数据
    public String show08(){
        return "{\"username\":\"Heroxin\",\"age\":21}";
    }

    @RequestMapping("/quick09")
    @ResponseBody  //告知springmvc不进行视图跳转，直接进行回写数据
    public String show09() throws JsonProcessingException {
        User user = new User();
        user.setUsername("Heroxin");
        user.setAge(21);
//        使用 json 的转换工具将对象转换成 json 格式字符串后返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }


//    spring-mvc中配置好json转换了，直接返回字符串即可
    @RequestMapping("/quick10")
    @ResponseBody  //告知springmvc不进行视图跳转，直接进行回写数据
    public User show10() {
        User user = new User();
        user.setUsername("Heroxin");
        user.setAge(21);

        return user;
    }

//    请求数据

//    获得基本类型参数
    @RequestMapping("/quick11")
    @ResponseBody
    public void show11(String username,int age){
//        url后缀： user/quick11?username=heroxin&age=21
        System.out.println(username);
        System.out.println(age);
    }

//    获得 POJO 类型参数
    @RequestMapping("/quick12")
    @ResponseBody
    public void show12(User user){
//        url后缀： user/quick12?username=heroxin&age=21
        System.out.println(user.toString());
    }

//    获得 数组 类型参数
    @RequestMapping("/quick13")
    @ResponseBody
    public void show13(String strs){
//        url后缀： user/quick13?strs=hero&strs=xin
        System.out.println(Arrays.asList(strs));
    }

//    获得 集合 类型参数 (不太熟悉，开摆，以后需要再详细了解)
    @RequestMapping("/quick14")
    @ResponseBody
    public void show14(List<User> userList){
//        url后缀： user/quick14?strs=hero&strs=xin
        System.out.println(userList);
    }

//    @RequestParam注解，用于用户提交参数与设置参数的绑定
//            这里设置参数名为 username 用户提交时参数名可以为 name
//        属性：value:与请求参数名称 (就是这里的name，与已设参数不同)
//             require： 指定请求参数是否必须包含，默认是 true (就用户提交时必须提交 name 名的参数，否则报错)
//             defaultVal：就 参数名 name 的默认值
    @RequestMapping("/quick15")
    @ResponseBody
    public void show15(@RequestParam("name") String username){
        System.out.println(username);
    }

//    Restful风格 ，代替原来的 ？
    @RequestMapping("/quick16/{username}")
    @ResponseBody
//    @RequestMapping 中的 username 和 @PathVariable username 匹配，得相同
    public void show16(@PathVariable("username") String username){
        System.out.println(username);
    }

//    获取请求头(此处只是获取User-Agent这条信息请求头信息而已)
    @RequestMapping("/quick17")
    @ResponseBody
    public void show17(@RequestHeader("User-Agent") String user_agent){
         System.out.println(user_agent);
    }
    @RequestMapping("/upload")
    public String up(){
        return "Upload";
    }
//    文件上传
//    单文件上传
    @RequestMapping("/quick18")
    @ResponseBody
    public void show18(MultipartFile uploadFile) throws  IOException{
//        获取文件名称
        String originalFilename = uploadFile.getOriginalFilename();
//        保存文件
        uploadFile.transferTo(new File("C:\\upload\\" + originalFilename));
    }
//    多文件上传
//    在表单那里多些几个 file 的 input
    @RequestMapping("/quick19")
    @ResponseBody
    public void show19(String username, MultipartFile[] uploadFiles) throws  IOException{
        for (MultipartFile uploadFile : uploadFiles){
            String originalFilename = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("C:\\upload\\" + originalFilename));
        }
    }
}
