package com.hclz.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclz.mapper.BookMsgMapper;
import com.hclz.mapper.BorrowInfoMapper;
import com.hclz.pojo.BorrowInfo;
import com.hclz.service.BorrowInfoService;

@Service
public class BorrowInfoServiceImpl implements BorrowInfoService {

	@Autowired
	private BorrowInfoMapper borrowInfoMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer infoId) {
		return borrowInfoMapper.deleteByPrimaryKey(infoId);
	}

	@Override
	public int insert(BorrowInfo record) {
		return borrowInfoMapper.insert(record);
	}

	@Override
	public BorrowInfo selectByPrimaryKey(Integer infoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(BorrowInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BorrowInfo> selectBookBorrowByuserId(Integer userId, Integer start, Integer size) {
		return borrowInfoMapper.selectBookBorrowByuserId(userId, start, size);
	}

	@Override
	public List<BorrowInfo> selectRecordsByuserId(Integer userId, Integer start, Integer size) {
		return borrowInfoMapper.selectRecordsByuserId(userId, start, size);
	}
	
	@Override
	public int updateReturnTimeByPrimaryKey(Integer infoId, Date returnTime) {
		return borrowInfoMapper.updateReturnTimeByPrimaryKey(infoId, returnTime);
	}

}
