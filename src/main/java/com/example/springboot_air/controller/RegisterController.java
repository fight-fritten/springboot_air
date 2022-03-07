package com.example.springboot_air.controller;

import com.example.springboot_air.mapper.UserMapper;
import com.example.springboot_air.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@Controller
public class RegisterController {


    @Autowired  //自动装配
    private UserMapper userMapper;

    /**
     * 搁这注册呢
     * @param username
     * @param passwd
     * @param passwd_2
     * @param model
     * @return
     */
    @RequestMapping  ("/register")
    public  String show(
            @RequestParam("username") String username,
            @RequestParam("passwd") String passwd,
            @RequestParam("passwd_2") String passwd_2,
            Model model
    )
    {
        //判断表格基本填写
        if(username.isEmpty()||passwd.isEmpty()||passwd_2.isEmpty()) {

            model.addAttribute("msg","请把表格填写完整");
            return "reg";
        }
        if(!passwd.equals(passwd_2)){
            model.addAttribute("msg","两次填写的密码不一致");
            return "reg";
        }

        //实例化录入数据并进行数据库操作
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwd);

        User if_in_db = userMapper.findUsername(username);
        if(if_in_db==null){ //即数据库中没有这样的用户名

            userMapper.insert(username,passwd); //把账号信息插入数据库
            model.addAttribute("msg","注册成功！快去登录吧");
            return "reg";
        }
        else {

            model.addAttribute("msg","用户名已存在！");
            return "reg";
        }

    }





}
