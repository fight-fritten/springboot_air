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

import java.util.List;

@Repository
@Controller
public class ReturnController {

    @Autowired  //自动装配
    private SystemMapper systemMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private MyticketMapper myticketMapper;

    //--------------执行退票操作-------------

    /**
     * 返回信息
     * @param code 二维码
     * @param model
     * @return
     */
    @RequestMapping("/return")
    public String return1(@Param("code") String code, Model model){

        personMapper.delete_ticket(code);
        model.addAttribute("tips","退票成功");

        systemMapper.update_num_plus(code);//完成退票，机票数量加一

        List<Myticket> use = myticketMapper.select_my_ticket("123");
        model.addAttribute("info",use); //刷新机票信息

        return "myticket";
    }
}
