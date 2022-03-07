package com.example.springboot_air.model;


import org.springframework.stereotype.Repository;

@Repository
public class User {

    private String username;
    private String Passwd;


    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Passwd;
    }

    public void setPassword(String passwd) {
        this.Passwd = passwd;
    }


}

