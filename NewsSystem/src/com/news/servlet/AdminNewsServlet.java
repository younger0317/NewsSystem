package com.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.News;
import com.news.entity.Page;
import com.news.entity.Topic;
import com.news.service.NewsService;
import com.news.service.TopicService;
import com.news.service.impl.NewsServiceImpl;
import com.news.service.impl.TopicServiceImpl;
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
		TopicService topicService = new TopicServiceImpl();
		//System.out.println("进来了");
		
		String type = req.getParameter("type");
		if(type!=null){
			if(type.equals("list")){
				List<News> newsList = newsService.getAllNews();
				req.setAttribute("newsList", newsList);
				//System.out.println("aaaaa");
				req.getRequestDispatcher("newspages/adminNewsList.jsp").forward(req, resp);
			}else if(type.equals("topicList")){
				List<Topic> topicList = topicService.findAllTopic();
				req.setAttribute("topicList", topicList);
				req.getRequestDispatcher("newspages/adminTopicList.jsp").forward(req, resp);
			}else if(type.equals("toAddTopic")){
				req.getRequestDispatcher("newspages/adminAddTopicList.jsp").forward(req, resp);
			}else if(type.equals("modify")){
				req.getRequestDispatcher("newspages/adminModifyTopicList.jsp").forward(req, resp);
			}
		}
	}
}
