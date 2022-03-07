package com.example.springboot_air.mapper;

import com.example.springboot_air.model.Admin;
import com.example.springboot_air.model.Myticket;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

    @Insert("insert into saleticket(project,detail,code,num) values (#{project},#{detail},#{code},#{num})")
    void insert_admin(@Param("project") String project,@Param("detail") String detail,
                      @Param("code") String code,@Param("num") String num);


    @Select("select * from saleticket")
    List<Admin> select_all_sale();

    @Select("select * from saleticket where project = #{demo} or code = #{demo} or detail = #{demo} or num = #{demo};")
    List<Admin> select_by_demo(@Param("demo") String demo);

    @Select("select * from saleticket where ${pro} = #{demo}")
    List<Admin> select_radio(@Param("demo") String demo,@Param("pro") String pro);

    @Delete("delete from saleticket where code = #{code}")
    void delete_admin (@Param("code") String code);   /*删除售卖表中的信息*/

    @Update("update saleticket set ${pro} = #{demo} where code =#{code}")
    void update_admin(@Param("pro") String pro,@Param("demo") String demo,@Param("code") String code);
    /*更改某个固定值*/





}
