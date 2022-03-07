package com.example.springboot_air.mapper;

import com.example.springboot_air.model.System;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SystemMapper {


    @Select("select * from saleticket")
    List<System> select_ticket();

    @Update("update saleticket set num=num-1 where code = #{code}")
    void update_num(@Param("code") String code); //把机票的数量减一

    @Update("update saleticket set num=num+1 where code = #{code}")
    void update_num_plus(@Param("code") String code); //把机票的数量加一

}
