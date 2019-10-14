package com.hclz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclz.mapper.BookMsgMapper;
import com.hclz.pojo.BookMsg;
import com.hclz.service.BookMsgService;

@Service
public class BookMsgServiceImpl implements BookMsgService {
	
	@Autowired
	private BookMsgMapper bookMsgMapper;

	@Override
	public int deleteByPrimaryKey(Integer bookId) {
		return bookMsgMapper.deleteByPrimaryKey(bookId);
	}

	@Override
	public int insert(BookMsg record) {
		return bookMsgMapper.insert(record);
	}

	@Override
	public BookMsg selectByPrimaryKey(Integer bookId) {
		return bookMsgMapper.selectByPrimaryKey(bookId);
	}

	@Override
	public List<BookMsg> selectAll(Integer start,Integer size) {
		return bookMsgMapper.selectAll(start, size);
	}

	@Override
	public int updateByPrimaryKey(BookMsg record) {
		return bookMsgMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<BookMsg> selectByBookName(String bookName) {
		return bookMsgMapper.selectByBookName(bookName);
	}

	@Override
	public List<BookMsg> selectByAuthorName(String authorName) {
		return bookMsgMapper.selectByAuthorName(authorName);
	}

	@Override
	public List<BookMsg> selectByBorrowNum() {
		return bookMsgMapper.selectByBorrowNum();
	}

	@Override
	public int updateBookNumByPrimaryKey(Integer bookId) {
		return bookMsgMapper.updateBookNumByPrimaryKey(bookId);
	}

}
