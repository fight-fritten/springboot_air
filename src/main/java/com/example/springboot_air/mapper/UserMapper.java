package com.example.springboot_air.mapper;

import com.example.springboot_air.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


    //查询数据库中该用户名是否已注册
    @Select( "select * from info where username = #{username} ")
    User findUsername(@Param("username") String username);

    //注册通过，插入数据库
    @Insert("insert into info(username,passwd) values (#{username},#{passwd})")
    void insert(@Param("username") String username,@Param("passwd") String passwd);


    //判断是否可以登录，即存在该用户，且用户名密码是正确的
    @Select("select * from info where username =#{username} and passwd = #{passwd}")
    User check_login(@Param("username") String username,@Param("passwd") String passwd);

    //同理,判断admin账户是否可以登录
    @Select("select * from admin where username =#{username} and passwd = #{passwd}")
    User check_adminlogin(@Param("username") String username,@Param("passwd") String passwd);

    //取出所有

    @Select( "select * from info ")
    List<User> findall();



}
