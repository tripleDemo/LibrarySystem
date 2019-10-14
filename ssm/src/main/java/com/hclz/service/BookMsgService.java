package com.hclz.service;

import java.util.List;
import com.hclz.pojo.BookMsg;

public interface BookMsgService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookMsg record);

    BookMsg selectByPrimaryKey(Integer bookId);

    List<BookMsg> selectAll(Integer start,Integer size);

    int updateByPrimaryKey(BookMsg record);
    
    List<BookMsg> selectByBookName(String bookName);
    
    List<BookMsg> selectByAuthorName(String authorName);
    
    List<BookMsg> selectByBorrowNum();
    
    int updateBookNumByPrimaryKey(Integer bookId);
}
