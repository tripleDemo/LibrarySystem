package com.hclz.mapper;

import com.hclz.pojo.BookMsg;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BookMsgMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookMsg record);

    BookMsg selectByPrimaryKey(Integer bookId);

    List<BookMsg> selectAll(@Param("start")Integer start,@Param("size")Integer size);

    int updateByPrimaryKey(BookMsg record);
    
    //按图书名进行模糊查询
    List<BookMsg> selectByBookName(String bookName);
    
    //按作者名进行模糊查询
    List<BookMsg> selectByAuthorName(String authorName);
    
    //查询借阅排名前10的书
    List<BookMsg> selectByBorrowNum();
    
    //根据主键将bookNum字段加1
    int updateBookNumByPrimaryKey(Integer bookId);
   
}