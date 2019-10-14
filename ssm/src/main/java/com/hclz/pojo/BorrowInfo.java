package com.hclz.pojo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BorrowInfo implements Serializable {
    private Integer infoId;

    private Integer bookId;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date lendTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date returnTime;

    private Integer userId;
    
    BookMsg bookMsg;
    
    public BorrowInfo() {
		super();
	}

	public BorrowInfo(Integer bookId,Integer userId) {
		this.bookId = bookId;
		this.lendTime = new Date(System.currentTimeMillis());
		this.userId = userId;
	}

	public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
	public BookMsg getBookMsg() {
		return bookMsg;
	}

	public void setBookMsg(BookMsg bookMsg) {
		this.bookMsg = bookMsg;
	}

	@Override
	public String toString() {
		return "BorrowInfo [infoId=" + infoId + ", bookId=" + bookId + ", lendTime=" + lendTime + ", returnTime="
				+ returnTime + ", userId=" + userId + "]";
	}
    
}