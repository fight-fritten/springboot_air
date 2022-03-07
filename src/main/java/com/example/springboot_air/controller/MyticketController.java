package com.example.springboot_air.controller;

import com.example.springboot_air.mapper.*;
import com.example.springboot_air.model.Admin;
import com.example.springboot_air.model.Myticket;
import com.example.springboot_air.model.System;
import com.example.springboot_air.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Repository
@Controller

public class MyticketController {


    @Autowired
    private MyticketMapper myticketMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SystemMapper systemMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 后端全局查询
     * @param demo 根据输入信息来进行全局查询
     * @param model
     * @return
     */
    @RequestMapping("/select_myticket_all")  /*全局查询*/
    public String select_admin(@RequestParam("demo") String demo,
                               Model model){


        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info",use);

        List<Admin> admin = adminMapper.select_by_demo(demo);
        model.addAttribute("info2",admin);

        return "surface";
    }

    /**
     * 显示自己的机票
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/myticket")
    public String myticket(HttpServletRequest request, Model model){

        //输出我的机票
        String username = (String) request.getSession().getAttribute("username");


            List<Myticket> use = myticketMapper.select_my_ticket(username);
            model.addAttribute("info",use);

        return "myticket";
    }

    /**
     * 显示主页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/surface")
    public String surface(HttpServletRequest request,Model model){

        String username = (String) request.getSession().getAttribute("username");
        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info",use);
        return "surface";
    }
}
