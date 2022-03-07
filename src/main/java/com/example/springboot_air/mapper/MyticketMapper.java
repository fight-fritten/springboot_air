package com.example.springboot_air.mapper;

import com.example.springboot_air.model.Myticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyticketMapper {//我的机票



    //获取我的机票信息
    @Select("select * from userticket where username = #{username}")
    List<Myticket> select_my_ticket(@Param("username") String username);
}
