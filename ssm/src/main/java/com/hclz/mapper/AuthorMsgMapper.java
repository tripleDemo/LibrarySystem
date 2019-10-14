package com.hclz.mapper;

import com.hclz.pojo.AuthorMsg;
import java.util.List;

public interface AuthorMsgMapper {
    int deleteByPrimaryKey(Integer authorId);

    int insert(AuthorMsg record);

    AuthorMsg selectByPrimaryKey(Integer authorId);

    List<AuthorMsg> selectAll();

    int updateByPrimaryKey(AuthorMsg record);
}