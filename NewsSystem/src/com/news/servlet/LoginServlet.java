package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.entity.NewsUser;
import com.news.service.UserService;
import com.news.service.impl.UserServiceImpl;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 登陆控制器
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uName = req.getParameter("uName");
		String uPwd = req.getParameter("uPwd");
		
		UserService userService = new UserServiceImpl();
		NewsUser newsUser = userService.findUserByUserAndPwd(uName, uPwd);
		
		if(newsUser != null){
			//登陆成功
			HttpSession session = req.getSession();
			session.setAttribute("newsUser", newsUser);
			resp.sendRedirect(req.getContextPath()+"/newspages/admin.jsp");
		}else{
			//登陆失败
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
		
	}
}
