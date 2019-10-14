package com.hclz.service;

import java.util.List;

import com.hclz.pojo.AuthorMsg;

public interface AuthorMsgService {
	int deleteByPrimaryKey(Integer authorId);

    int insert(AuthorMsg record);

    AuthorMsg selectByPrimaryKey(Integer authorId);

    List<AuthorMsg> selectAll();

    int updateByPrimaryKey(AuthorMsg record);
}
