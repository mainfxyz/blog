package com.DAO;

import com.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAllUser();
    int addUser(User user);

    @Delete("delete from `user` where `email`=#{email}")
    int delUser(String user);
    @Select("select passwd from `user` where `email`=#{email}")
    String selectPasswd(String user);
}
