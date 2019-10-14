package com.hclz.mapper;

import com.hclz.pojo.BorrowInfo;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BorrowInfoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(BorrowInfo record);

    BorrowInfo selectByPrimaryKey(Integer infoId);

    List<BorrowInfo> selectAll();

    int updateByPrimaryKey(BorrowInfo record);
    
    //通过userId联合查询表bookmsg和表borrowinfo (returnTime IS null)
    List<BorrowInfo> selectBookBorrowByuserId(@Param("userId")Integer userId,@Param("start")Integer start,@Param("size")Integer size);
    //通过userId联合查询表bookmsg和表borrowinfo (returnTime IS not null)
    List<BorrowInfo> selectRecordsByuserId(@Param("userId")Integer userId,@Param("start")Integer start,@Param("size")Integer size);
    
    //向borrowinfo表中根据infoId字段更新returnTime字段 
    int updateReturnTimeByPrimaryKey(@Param("infoId")Integer infoId,@Param("returnTime")Date returnTime);
}