package com.hclz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclz.mapper.UserMsgMapper;
import com.hclz.pojo.UserMsg;
import com.hclz.service.UserMsgService;

@Service
public class UserMsgServiceImpl implements UserMsgService {
	
	@Autowired
	private UserMsgMapper userMsgMapper;

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(UserMsg record) {
		return userMsgMapper.insert(record);
	}

	@Override
	public UserMsg selectByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMsg> selectAll() {
		return userMsgMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(UserMsg record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserMsg queryForLogin(String userName, String password, boolean type) {
		return userMsgMapper.queryForLogin(userName, password, type);
	}

	@Override
	public UserMsg userNameisExist(String userName) {
		return userMsgMapper.userNameisExist(userName);
	}


}
