package com.hclz.controller;

import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hclz.pojo.BorrowInfo;
import com.hclz.pojo.UserMsg;
import com.hclz.service.BookMsgService;
import com.hclz.service.BorrowInfoService;

@Controller
public class UserController {
	
	@Autowired
	private BookMsgService bookMsgService;
	
	@Autowired
	private BorrowInfoService borrowInfoService;
		
	@RequestMapping("/userPage")
	public String userPage(){
		return "userPage"; 
	}
	
	//-------------------------------------------------用户借书模块
	@RequestMapping("/borrowBooks")
	public String borrowBooks(){
		return "borrowBooks"; 
	}
	
	/**
	 响应借书请求
	 */
	@RequestMapping("/toBorrow")
	public String toBorrow(HttpServletRequest request,HttpSession session) {
		String borrowId = request.getParameter("borrowId");
		int bookId = Integer.parseInt(borrowId);
		//向bookmsg表中的borrowNum字段+1
		int updateNum = bookMsgService.updateBookNumByPrimaryKey(bookId);
		//向borrowinfo表中添加一条记录
		UserMsg userMsg = (UserMsg) session.getAttribute("userMsg");
		BorrowInfo borrowInfo = new BorrowInfo(bookId,userMsg.getUserId());
		int insertNum = borrowInfoService.insert(borrowInfo);
		return "redirect:borrowBooks";
	} 
	
	//-------------------------------------------------用户还书模块
	@RequestMapping("/returnBook")
	public String returnBook(){
		return "returnBook"; 
	}
	
	@RequestMapping("/toReturn")
	public String toReturn(HttpSession session) {
		int userId = ((UserMsg) session.getAttribute("userMsg")).getUserId();
		List<BorrowInfo> list = borrowInfoService.selectBookBorrowByuserId(userId,null,null);
		List<BorrowInfo> borrowInfos = borrowInfoService.selectBookBorrowByuserId(userId,0,7);
		session.setAttribute("currentPage", "1");
		session.setAttribute("pages", list.size()%7==0 ? list.size()/7 : list.size()/7+1);
		session.setAttribute("borrowInfos", borrowInfos);
		return "redirect:returnBook";
	}
	
	@RequestMapping("/changePage")
	public String changePage(HttpServletRequest request,HttpSession session) {
		String currentPage = request.getParameter("currentPage");
		Integer start = (Integer.parseInt(currentPage)-1)*7;
		int userId = ((UserMsg) session.getAttribute("userMsg")).getUserId();
		List<BorrowInfo> list = borrowInfoService.selectBookBorrowByuserId(userId,null,null);
		List<BorrowInfo> borrowInfos = borrowInfoService.selectBookBorrowByuserId(userId,start,7);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("pages", list.size()%7==0 ? list.size()/7 : list.size()/7+1);
		session.setAttribute("borrowInfos", borrowInfos);
		for(BorrowInfo borrowInfo : borrowInfos) {
			System.out.println(borrowInfo);
		}
		return "redirect:returnBook";
	}
	
	/**
	 响应还书请求
	 */
	@RequestMapping("/executeBorrow")
	public String executeBorrow(HttpServletRequest request,HttpSession session) {
		String info = request.getParameter("infoId");
		int infoId = Integer.parseInt(info);
		//向borrowinfo表中根据infoId字段更新returnTime字段
		Date returnTime = new Date(System.currentTimeMillis());
		borrowInfoService.updateReturnTimeByPrimaryKey(infoId, returnTime);
		return "redirect:returnBook";
	} 
	
	//-------------------------------------------------用户查询模块
	@RequestMapping("/queryRecords")
	public String queryRecords(){
		return "queryRecords"; 
	}
	
	@RequestMapping("/toQuery")
	public String toQuery(HttpSession session) {
		int userId = ((UserMsg) session.getAttribute("userMsg")).getUserId();
		List<BorrowInfo> list = borrowInfoService.selectBookBorrowByuserId(userId,null,null);
		List<BorrowInfo> borrowInfos = borrowInfoService.selectBookBorrowByuserId(userId,0,7);
		session.setAttribute("currentPage", "1");
		session.setAttribute("pages", list.size()%7==0 ? list.size()/7 : list.size()/7+1);
		session.setAttribute("borrowInfos", borrowInfos);
		return "redirect:queryRecords";
	}
	
	@RequestMapping("/changeRecordPage")
	public String changeRecordPage(HttpServletRequest request,HttpSession session) {
		String currentPage = request.getParameter("currentPage");
		Integer start = (Integer.parseInt(currentPage)-1)*7;
		int userId = ((UserMsg) session.getAttribute("userMsg")).getUserId();
		List<BorrowInfo> list = borrowInfoService.selectBookBorrowByuserId(userId,null,null);
		List<BorrowInfo> borrowInfos = borrowInfoService.selectRecordsByuserId(userId,start,7);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("pages", list.size()%7==0 ? list.size()/7 : list.size()/7+1);
		session.setAttribute("borrowInfos", borrowInfos);
		for(BorrowInfo borrowInfo : borrowInfos) {
			System.out.println(borrowInfo);
		}
		return "redirect:queryRecords";
	}
	
	/**
	 响应删除借阅记录请求
	 */
	@RequestMapping("/deleteRecord")
	public String deleteRecord(HttpServletRequest request,HttpSession session) {
		String info = request.getParameter("infoId");
		int infoId = Integer.parseInt(info);
		//向borrowinfo表中根据infoId字段删除相应记录
		borrowInfoService.deleteByPrimaryKey(infoId);
		return "redirect:toQuery";
	}
}
