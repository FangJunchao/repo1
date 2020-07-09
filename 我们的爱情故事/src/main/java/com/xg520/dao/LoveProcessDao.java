package com.xg520.dao;

import com.xg520.domain.LoveProcess;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoveProcessDao {

    @Insert("insert into love_process(image,course,time,lover_id) values(#{image},#{course},#{time},#{loverId})")
    void insert(LoveProcess loveProcess);

    @Select("select * from love_process")
    @Results(value = {
            @Result(id=false,property = "loverId",column = "lover_id"),
            @Result(id=false,property = "course",column = "course"),
            @Result(id=false,property = "time",column = "time"),
            @Result(id=false,property = "image",column = "image"),
            @Result(id=true,property = "id",column = "id")},
            id = "LoverProcess")
    List<LoveProcess> selectAll();
}
