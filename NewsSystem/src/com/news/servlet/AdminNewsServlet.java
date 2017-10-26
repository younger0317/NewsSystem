package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.News;
import com.news.entity.Page;
import com.news.service.NewsService;
import com.news.service.impl.NewsServiceImpl;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 管理员新闻列表控制器
 *
 */
public class AdminNewsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		NewsService newsService = new NewsServiceImpl();
		
		String type =(String) req.getAttribute("type");
		if(type != null){
			if(type.equals("frist")){
				//获取页面中心新闻集合,因为第一次访问，所以currentNo为1，pagesize=10
				Page<News> page = newsService.getPageNewsList(1, 10);
				if(page.getList() != null && page.getList().size()>0 ){
					//存储新闻集合
					req.setAttribute("mainNewsList", page.getList());
					//存储当前页
					req.setAttribute("currentNo", page.getCurrentNo());
					//存储分页数
					req.setAttribute("totalPageCount", page.getTotalPageCount());
					//存储下次的跳转类型
					req.setAttribute("type", "noFrist");
				}else{
					//如果当前页没有新闻集合
					req.setAttribute("noMsg", "noMsg");
				}	
			}
		}
		
		type = req.getParameter("type");
		if(type!=null){
			if(type.equals("noFrist")){
				Page<News> page = newsService.getPageNewsList(Integer.parseInt(req.getParameter("currentNo")), 10);
				if(page.getList() != null && page.getList().size()>0 ){
					//存储新闻集合
					req.setAttribute("mainNewsList", page.getList());
					//存储当前页
					req.setAttribute("currentNo", page.getCurrentNo());
					//存储分页数
					req.setAttribute("totalPageCount", page.getTotalPageCount());
				}else{
					//如果当前页没有新闻集合
					req.setAttribute("noMsg", "noMsg");
				}	
			}
		}
		
		
		req.getRequestDispatcher("/newspages/admin.jsp").forward(req, resp);
	}
}
