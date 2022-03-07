package com.example.springboot_air.controller;

import com.example.springboot_air.mapper.MyticketMapper;
import com.example.springboot_air.mapper.PersonMapper;
import com.example.springboot_air.mapper.SystemMapper;
import com.example.springboot_air.model.Myticket;
import com.example.springboot_air.model.System;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Repository
@Controller
public class OrderController {


    @Autowired  //自动装配
    private SystemMapper systemMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private MyticketMapper myticketMapper;


    /**
     *  显示订单
     * @param code
     * @param detail
     * @param project
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/order")

    public String order(@RequestParam("code") String code,
                        @RequestParam("detail") String detail,
                        @RequestParam("project") String project,
                        Model model,
                        HttpServletRequest request){


        //购买机票
        systemMapper.update_num(code);
        model.addAttribute("msg","购买成功！！！！");

        //把机票信息插入用户表中
        String username = (String) request.getSession().getAttribute("username"); //获取保存在session的用户民

        personMapper.insert(username,code,project,detail);

        List<System> use = systemMapper.select_ticket();

        model.addAttribute("info",use);

        return "surface";
    };




}
