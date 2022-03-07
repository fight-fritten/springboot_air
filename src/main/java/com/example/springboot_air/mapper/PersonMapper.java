package com.example.springboot_air.mapper;


import com.example.springboot_air.model.Myticket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonMapper {  //操作userticket表！！！！！！
    //插入四个数据，userticket表，当个人表
    @Insert("insert into userticket(username,code,project,detail) values(#{username},#{code},#{project},#{detail})")
    void insert(@Param("username") String username, @Param("code") String code, @Param("project") String project, @Param("detail") String detail);

    //删除表中的数据，退票
    @Delete("delete  from userticket where  code = #{code}")
    void delete_ticket(@Param("code") String code);





}
