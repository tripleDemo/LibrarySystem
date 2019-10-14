package com.hclz.pojo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookMsg implements Serializable {
    private Integer bookId;

    private String bookName;

    private String bookCover;

    private Integer borrowNum;

    private Integer authorId;

    private String publisher;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publishTime;

    public BookMsg() {
	}

	public BookMsg(String bookName, String bookCover, Integer authorId, String publisher,
			Date publishTime) {
		this.bookName = bookName;
		this.bookCover = bookCover;
		this.authorId = authorId;
		this.publisher = publisher;
		this.publishTime = publishTime;
	}
	
	public BookMsg(Integer bookId, String bookName, Integer borrowNum, String publisher, Date publishTime) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.borrowNum = borrowNum;
		this.publisher = publisher;
		this.publishTime = publishTime;
	}

	public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

	@Override
	public String toString() {
		return "BookMsg [bookId=" + bookId + ", bookName=" + bookName + ", bookCover=" + bookCover + ", borrowNum="
				+ borrowNum + ", authorId=" + authorId + ", publisher=" + publisher + ", publishTime=" + publishTime
				+ "]";
	}
    
}