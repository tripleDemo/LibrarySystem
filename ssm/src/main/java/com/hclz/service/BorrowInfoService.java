package com.hclz.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hclz.pojo.BorrowInfo;

public interface BorrowInfoService {
	int deleteByPrimaryKey(Integer infoId);

    int insert(BorrowInfo record);

    BorrowInfo selectByPrimaryKey(Integer infoId);

    List<BorrowInfo> selectAll();

    int updateByPrimaryKey(BorrowInfo record);
    
    List<BorrowInfo> selectBookBorrowByuserId(Integer userId,Integer start,Integer size);
    
    List<BorrowInfo> selectRecordsByuserId(Integer userId,Integer start,Integer size);
    
    int updateReturnTimeByPrimaryKey(@Param("infoId")Integer infoId,@Param("returnTime")Date returnTime);
}
