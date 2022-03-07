package com.example.springboot_air.controller;

import com.example.springboot_air.mapper.AdminMapper;
import com.example.springboot_air.mapper.SystemMapper;
import com.example.springboot_air.model.Admin;
import com.example.springboot_air.model.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
@Controller
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private SystemMapper systemMapper;
    /**
     * 登录到admin后台
     * @param project
     * @param detail
     * @param code
     * @param num
     * @param model
     * @return
     */
    @RequestMapping("/admin1")
    public String admin(@RequestParam("project") String project,
                        @RequestParam("detail") String detail,
                        @RequestParam("code") String code,
                        @RequestParam("num") String num, Model model){

        adminMapper.insert_admin(project, detail, code, num);
        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info2",use);
        //后台首页
        return "admin";
    }

    /**
     * 后台-全局查询--
     * @param demo
     * @param model
     * @return
     */
    @RequestMapping("/select_admin_all")  /*全局查询*/
    public String select_admin(@RequestParam("demo") String demo, Model model){
        List<Admin> admin = adminMapper.select_by_demo(demo);
        model.addAttribute("info",admin);


        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info2",use);

        return "admin";
    }

    /**
     * 这个是选出可选选项
     * @param pro 细节
     * @param demo
     * @param model 模型？
     * @return
     */
    @RequestMapping("/select_radio")
    public String select_radio(@RequestParam("pro") String pro,
                               @RequestParam("demo") String demo,
                               Model model){
        List<Admin> admin = adminMapper.select_radio(demo,pro);
        model.addAttribute("info",admin);

        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info2",use); /*随时可以显示实时票务*/

        return "admin";
    }

    /**
     * 利用该路由，来删除表中的信息
     * @param code
     * @param model
     * @return
     */
    @RequestMapping("/delete_admin")  /*删除表中的信息*/
    public String delete_admin(@RequestParam("code") String code,
                               Model model){
        //调用mapper来删除
        adminMapper.delete_admin(code);

        //取出所有机票信息，刷新
        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info2",use);

        //返回admin首页
        return "admin";
    }

    /**
     * 更改表中的信息
     * @param code  二维码
     * @param project
     * @param num 数量
     * @param detail 细节
     * @param model
     * @return
     */
    @RequestMapping("/change")  /*更改表中的信息*/
    public String change(@RequestParam("code") String code,
                         @RequestParam("project") String project,
                         @RequestParam("num") String num,
                        @RequestParam("detail") String detail, Model model){

        //返回所有信息
        model.addAttribute("code",code);
        model.addAttribute("project",project);
        model.addAttribute("num",num);
        model.addAttribute("detail",detail);

        return "etc/change";/*跳转到change页面*/
    }

    /**
     * 更新票务
     * @param pro
     * @param demo
     * @param code
     * @param model
     * @return
     */
    @RequestMapping("/update")
    public String update(@RequestParam("pro") String pro,
                         @RequestParam("demo") String demo,
                         @RequestParam("code") String code,
                         Model model){
        //更新admin表中的所有机票信息
        adminMapper.update_admin(pro, demo, code);

        //取出现存的所有机票
        List<System> use = systemMapper.select_ticket();
        model.addAttribute("info2",use);

        //admin首页
        return "admin";
    }
}
