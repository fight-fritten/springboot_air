package com.example.springboot_air.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class System {
    private String project;
    private String detail;
    private String code;
    private String num;



    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
