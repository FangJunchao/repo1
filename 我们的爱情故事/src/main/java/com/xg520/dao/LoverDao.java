package com.xg520.dao;

import com.xg520.domain.Lover;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoverDao {

    @Select("select * from lover where username= #{username}")
    Lover findLoverByUsername(String username);

    @Select("select * from lover where username = #{username} and password = #{password}")
    Lover findLoverByUsernameAndPassword(Lover lover);
}
