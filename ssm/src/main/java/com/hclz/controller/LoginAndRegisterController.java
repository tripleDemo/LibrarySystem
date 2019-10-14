package com.hclz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.hclz.pojo.UserMsg;
import com.hclz.service.UserMsgService;

@Controller
public class LoginAndRegisterController {
	
	@Autowired
	private UserMsgService userMsgService;

	
	@RequestMapping("/login")
	public String login(){
		return "loginAndRegister"; 
	}
	
	@PostMapping("/toLogin")
	public ModelAndView toLogin(HttpServletRequest request,HttpSession session){
		ModelAndView model = new ModelAndView();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String typeStr = request.getParameter("type");
		boolean type = false;
		if("manager".equals(typeStr)) {
			type = true;
		}
		UserMsg userMsg = userMsgService.queryForLogin(userName, password, type);
		if(userMsg != null) {
			//登录成功，将userMsg对象设置到HttpSession作用范围域中
            session.setAttribute("userMsg", userMsg);
			if(type) {
				model.setView(new RedirectView("toManagerPage"));
			}else{
				model.setView(new RedirectView("userPage"));
			}
		}else {
			model.addObject("errorMsg","账号与密码匹配错误!  请重新输入!");
			model.setViewName("loginAndRegister");
		}	
		return model;
	}
	
	@RequestMapping("/register")
	public String register(){
		return "loginAndRegister"; 
	}
	
	@PostMapping("/toRegister")
	public ModelAndView toRegister(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String typeStr = request.getParameter("type");
		boolean type = false;
		if("manager".equals(typeStr)) {
			type = true;
		}
		UserMsg user = userMsgService.userNameisExist(userName);
		if(user != null) {
			model.addObject("errorMsg","账号已存在!  注册失败!");
			model.setViewName("loginAndRegister");
		}else {
			UserMsg userMsg = new UserMsg(userName,password,type);
			int insertNum = userMsgService.insert(userMsg);
			model.addObject("errorMsg","恭喜注册成功!");
			model.setViewName("loginAndRegister");
		}
		return model;
	}
	
	@RequestMapping("/destroySession")
	public String destroySession(HttpSession session){
		if(session != null) {
			session.removeAttribute("userMsg");
		}
		return "redirect:login";
	}
}
