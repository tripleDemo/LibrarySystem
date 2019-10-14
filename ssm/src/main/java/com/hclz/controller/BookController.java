package com.hclz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hclz.pojo.AuthorMsg;
import com.hclz.pojo.BookMsg;
import com.hclz.service.AuthorMsgService;
import com.hclz.service.BookMsgService;

@Controller
public class BookController {
	
	@Autowired
	private BookMsgService bookMsgService;
	
	@Autowired
	private AuthorMsgService authorMsgService;

	@RequestMapping("/getBooks")
	public String getBooks(HttpServletRequest request,HttpSession session) {
		String searchContext = request.getParameter("searchContext");
		String byType = request.getParameter("byType");
		List<BookMsg> bookMsgs = null;
		if("byBook".equals(byType)) {
			bookMsgs = bookMsgService.selectByBookName(searchContext);
		}else {
			bookMsgs = bookMsgService.selectByAuthorName(searchContext);
		}
		session.removeAttribute("TopBookMsgs");
		session.setAttribute("bookMsgs", bookMsgs);
		return "redirect:borrowBooks";
	}
	
	@RequestMapping("/getTopBooks")
	public String getTopBooks(HttpSession session) {
		List<BookMsg> bookMsgs = bookMsgService.selectByBorrowNum(); 
		session.removeAttribute("bookMsgs");
		session.setAttribute("TopBookMsgs", bookMsgs);
		return "redirect:borrowBooks";
	}
	
	@ResponseBody
	@RequestMapping("/getBrief")
	public Map<String, Object> getBrief(HttpServletRequest request) {
		String bookId = request.getParameter("bookId");
		int id = Integer.parseInt(bookId);
		BookMsg bookMsg = bookMsgService.selectByPrimaryKey(id);
		AuthorMsg authorMsg = authorMsgService.selectByPrimaryKey(bookMsg.getAuthorId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookMsg", bookMsg);
		map.put("authorMsg", authorMsg);
		return map;
	}
}
