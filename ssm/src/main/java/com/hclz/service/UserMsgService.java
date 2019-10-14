package com.hclz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hclz.pojo.UserMsg;

public interface UserMsgService {
	int deleteByPrimaryKey(Integer userId);

    int insert(UserMsg record);

    UserMsg selectByPrimaryKey(Integer userId);

    List<UserMsg> selectAll();

    int updateByPrimaryKey(UserMsg record);
    
    UserMsg queryForLogin(@Param("userName") String userName,@Param("password") String password,@Param("type") boolean type);
    
    UserMsg userNameisExist(String userName);
}
