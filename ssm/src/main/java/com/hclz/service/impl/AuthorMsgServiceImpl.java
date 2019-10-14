package com.hclz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hclz.mapper.AuthorMsgMapper;
import com.hclz.pojo.AuthorMsg;
import com.hclz.service.AuthorMsgService;

@Service
public class AuthorMsgServiceImpl implements AuthorMsgService {
	@Autowired
	private AuthorMsgMapper authorMsgMapper;

	@Override
	public int deleteByPrimaryKey(Integer authorId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(AuthorMsg record) {
		return authorMsgMapper.insert(record);
	}

	@Override
	public AuthorMsg selectByPrimaryKey(Integer authorId) {
		return authorMsgMapper.selectByPrimaryKey(authorId);
	}

	@Override
	public List<AuthorMsg> selectAll() {
		List<AuthorMsg> authorMsgs = authorMsgMapper.selectAll();
		return authorMsgs;
	}

	@Override
	public int updateByPrimaryKey(AuthorMsg record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
