package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.News;
import com.news.service.NewsService;
import com.news.service.impl.NewsServiceImpl;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 新闻增删改控制器
 *
 */
public class DoNews extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		
		NewsService newsService = new NewsServiceImpl();
		
		String type = req.getParameter("type");
		if(type != null){
			if(type.equals("add")){
				//添加新闻
				String ntidStr = req.getParameter("ntid");
				int ntid=Integer.parseInt(ntidStr);
				System.out.println(ntid);
				String ntitle = req.getParameter("ntitle");
				String nauthor = req.getParameter("nauthor");
				String nsummary = req.getParameter("nsummary");
				String ncontent = req.getParameter("ncontent");
				News news = new News(ntid, ntitle, nauthor, ncontent, nsummary);
				
				boolean flag = newsService.addNews(news);
				if(flag){
					out.print("true");
				}else {
					out.print("false");
				}
				
			}
		}
	}
}
