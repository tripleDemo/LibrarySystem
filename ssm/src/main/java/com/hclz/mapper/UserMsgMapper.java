package com.hclz.mapper;

import com.hclz.pojo.UserMsg;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMsgMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserMsg record);

    UserMsg selectByPrimaryKey(Integer userId);

    List<UserMsg> selectAll();

    int updateByPrimaryKey(UserMsg record);
    
    //登录时从数据库查询账号与密码是否匹配
    UserMsg queryForLogin(@Param("userName") String userName,@Param("password") String password,@Param("type") boolean type);
    
    //检查用户名是否存在
    UserMsg userNameisExist(String userName);
}