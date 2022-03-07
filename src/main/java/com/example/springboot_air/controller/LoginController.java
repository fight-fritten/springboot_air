package com.example.springboot_air.controller;

import com.example.springboot_air.mapper.SystemMapper;
import com.example.springboot_air.mapper.UserMapper;
import com.example.springboot_air.model.System;
import com.example.springboot_air.model.User;
import org.apache.catalina.Session;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Repository
@Controller

public class LoginController {
    @Autowired  //自动装配
    private UserMapper userMapper;
    @Autowired  //自动装配
    private SystemMapper systemMapper;

    /**
     * 根目录重定向
     * @return
     */
    @RequestMapping("/")
    public String inti(){
        return "index";
    }

    /**
     * 登录测试
     * @param username 用户名
     * @param passwd  密码
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/login")

    public String login(@RequestParam("username") String username,
                        @RequestParam("passwd") String passwd,
                        Model model, HttpServletRequest request) {

        //实例化定义好的java类，注意没有@Repository则无法实现 这是model层的东西
        //用于操作数据库
        User user = new User();

        //设置好username 和 passwd
        user.setUsername(username);
        user.setPassword(passwd);

        //判断是否为空
        if(username.isEmpty()||passwd.isEmpty()){
            //模板引擎传入信息
            model.addAttribute("msg","用户名或密码为空！");
            return  "index";

        }

        //调用类对数据库进行查询，判断该账号是否存在
        User check_if_login = userMapper.check_login(username,passwd);
        //正确则返回“成功”，错误则返回“错误”
        if(check_if_login!=null){   //登录成功

            HttpSession session = request.getSession();

            session.setAttribute("username",username);//创建session
            session.setAttribute("passwd",passwd);//创建session


//           model.addAttribute("info",use);

           List<System> use = systemMapper.select_ticket(); //提取出表中的机票信息
            model.addAttribute("info",use); //输出到前端
            return "surface";

        }
        else {
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }


    }

    /**
     *  后台登录系统，验证
     * @param username
     * @param passwd
     * @param model
     * @return
     */
    @RequestMapping("/admin_check")
    public String admin_login(@Param("username") String username,
                              @Param("passwd") String passwd,
                              Model model){
          //常规方法验证！！！！
        User user = new User(); //实例化定义好的java类，注意没有@Repository则无法实现

        user.setUsername(username);
        user.setPassword(passwd);

        //判断是否为空
        if(username.isEmpty()||passwd.isEmpty()){

            model.addAttribute("msg","用户名或密码为空！");
            return  "adminlogin";

        }
        //调用类对数据库进行查询，判断该账号是否存在
        User check_if_login = userMapper.check_adminlogin(username,passwd);
        //正确则返回“成功”，错误则返回“错误”
        if(check_if_login!=null){   //登录成功

            List<System> use = systemMapper.select_ticket(); //提取出表中的机票信息
            model.addAttribute("info",use); //输出到前端
            return "admin";

        }
        else {
            model.addAttribute("msg","用户名或密码错误");
            return "adminlogin";
        }

    }

}
