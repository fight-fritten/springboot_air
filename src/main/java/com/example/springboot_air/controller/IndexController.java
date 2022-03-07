package com.example.springboot_air.controller;

import com.example.springboot_air.mapper.SystemMapper;
import com.example.springboot_air.model.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
@Controller

public class IndexController {

    @Autowired
    private SystemMapper systemMapper;

    /**
     * index 页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    };

    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }

    /**
     * admin页面
     * @param model
     * @return
     */
    @RequestMapping("/admin")
    public String admin1(Model model){

        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info2",use);
        return "admin";
    }

    /**
     * admin登录页面
     * @return
     */
    @RequestMapping("/adminlogin")
    public String adminlogin(){
        return "adminlogin";
    }


}