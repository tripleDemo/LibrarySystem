package com.hclz.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hclz.pojo.AuthorMsg;
import com.hclz.pojo.BookMsg;
import com.hclz.service.AuthorMsgService;
import com.hclz.service.BookMsgService;

@Controller
public class ManagerController {
	
	@Autowired
	private BookMsgService bookMsgService;
	
	@Autowired
	private AuthorMsgService authorMsgService;

	@RequestMapping("/managerPage")
	public String managerPage() {
		return "managerPage";
	}
	
	@RequestMapping("/toManagerPage")
	public String toManagerPage(HttpSession session){
		List<BookMsg> list = bookMsgService.selectAll(null,null);
		List<BookMsg> bookMsgs = bookMsgService.selectAll(0,7);
		session.setAttribute("currentPage", "1");
		session.setAttribute("pages", list.size()%7==0 ? list.size()/7 : list.size()/7+1);
		session.setAttribute("bookMsgs", bookMsgs);
		return "redirect:managerPage"; 
	}
	
	@RequestMapping("/switchPage")
	public String switchPage(HttpServletRequest request,HttpSession session) {
		String currentPage = request.getParameter("currentPage");
		Integer start = (Integer.parseInt(currentPage)-1)*7;
		List<BookMsg> list = bookMsgService.selectAll(null,null);
		List<BookMsg> bookMsgs = bookMsgService.selectAll(start,7);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("pages", list.size()%7==0 ? list.size()/7 : list.size()/7+1);
		session.setAttribute("bookMsgs", bookMsgs);
		return "redirect:managerPage";
	}
	
	@RequestMapping("/addBook")
	public String addBook() {
		return "addBook";
	}
	
	/**
	 新增图书
	 * @throws IOException 
	 * mybatis联表插入 (先向主表插入数据，再向从表插入数据)
	 */
	@RequestMapping("/toAddBook")
	public String toAddBook(HttpServletRequest request,@RequestParam("bookFile")MultipartFile bookFile,@RequestParam("authorFile")MultipartFile authorFile) throws IOException {
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		String authorBirth = request.getParameter("authorBirth");
		String publisher = request.getParameter("publisher");
		String publishTime = request.getParameter("publishTime");
		
		//----------------------------bookFile下载
		// 得到图片的原始文件名
        String bookFileOriginalName = bookFile.getOriginalFilename();
        //获取物理路径
        String path = request.getSession().getServletContext().getRealPath("/"); 
        int index = path.indexOf(".metadata");
        String bookFilePath = path.substring(0,index)+"ssm\\WebContent\\static\\images\\books\\";
        // 为了处理出现重名现象, 将原始文件名去掉,通过UUID算法生成新的文件名
        String uuidName1 = UUID.randomUUID().toString();
        // uuid名称加上文件的后缀名
        String newFile1 = uuidName1 + bookFileOriginalName.substring(bookFileOriginalName.lastIndexOf("."));
        // 创建File文件
        File file1 = new File(bookFilePath + newFile1);
        // 将图片写入到具体的位置
        bookFile.transferTo(file1);
        
        //----------------------------authorFile下载
        String authorFileOriginalName = authorFile.getOriginalFilename();
        String authorFilePath = path.substring(0,index)+"ssm\\WebContent\\static\\images\\authors\\";
        String uuidName2 = UUID.randomUUID().toString();
        String newFile2 = uuidName2 + authorFileOriginalName.substring(bookFileOriginalName.lastIndexOf("."));
        File file2 = new File(authorFilePath + newFile2);
        authorFile.transferTo(file2);
        
        //先向主表插入数据，获取主表id
        String authorImg = "/ssm/static/images/authors/"+newFile2;
        Date birth=Date.valueOf(authorBirth);
        AuthorMsg author = new AuthorMsg(authorName, authorImg, birth);
        authorMsgService.insert(author);
        int authorId = author.getAuthorId();
        
        //再向从表插入数据
        String bookImg = "/ssm/static/images/books/"+newFile1;
        Date time = Date.valueOf(publishTime);
        BookMsg book = new BookMsg(bookName, bookImg, authorId, publisher, time);
        bookMsgService.insert(book);
        
		return "redirect:toManagerPage";
	}
	
	/**
	 删除图书
	 */
	@RequestMapping("/deleteBook")
	public String deleteBook(HttpServletRequest request) {
		String bookIdStr = request.getParameter("bookId");
		int bookId = Integer.parseInt(bookIdStr);
		bookMsgService.deleteByPrimaryKey(bookId);
		return "redirect:toManagerPage";
	}
	
	/**
	 修改图书
	 */
	@ResponseBody
	@RequestMapping("/modifyBook")
	public String modifyBook(HttpServletRequest request) {
		String bookIdStr = request.getParameter("bookId");
		int bookId = Integer.parseInt(bookIdStr);
		String bookName = request.getParameter("bookName");
		String borrowNumStr = request.getParameter("borrowNum");
		int borrowNum = Integer.parseInt(borrowNumStr);
		String publisher = request.getParameter("publisher");
		String publishTimeStr = request.getParameter("publishTime");
		Date publishTime = Date.valueOf(publishTimeStr);
		BookMsg book = new BookMsg(bookId,bookName,borrowNum,publisher,publishTime);
		int updateNum = bookMsgService.updateByPrimaryKey(book);
		return "redirect:toManagerPage";
	}
}
