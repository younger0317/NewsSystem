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
 * 主页新闻列表控制器
 *
 */
public class NewsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		NewsService newsService = new NewsServiceImpl();
		TopicService topicService = new TopicServiceImpl();
		//获取国内新闻集合
		List<News> nationNewsList = newsService.getNewsListByTid(1);
		//获取国际新闻集合
		List<News> internationNewsList = newsService.getNewsListByTid(2);
		//获取娱乐新闻集合
		List<News> entertainmentNewsList = newsService.getNewsListByTid(5);
		
		//将获取的新闻集合存入request
		req.setAttribute("nationNewsList", nationNewsList);
		req.setAttribute("internationNewsList", internationNewsList);
		req.setAttribute("entertainmentNewsList", entertainmentNewsList);
		
		//获取新闻主题集合
		List<Topic> topicList = topicService.findAllTopic();
		
		//将获取的新闻主题集合存入request
		req.setAttribute("topicList", topicList);
		
		String type =(String) req.getAttribute("type");
		if(type != null){
			if(type.equals("fristVisit")){
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
		if(type != null){
			//noFrist 不是第一次访问
			if(type.equals("noFrist")){
				Page<News> page = newsService.getPageNewsList(Integer.parseInt(req.getParameter("currentNo")), 10);
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
			}else{
				//type是其他值，就是changeTopic
				Integer currentNo = Integer.parseInt(req.getParameter("currentNo"));
				Integer tId = Integer.parseInt(req.getParameter("tid"));
				Page<News> page = newsService.getPageNewsListByTid(currentNo, 10, tId);
			
				if(page.getList() != null && page.getList().size()>0 ){
					//存储新闻集合
					req.setAttribute("mainNewsList", page.getList());
					//存储当前页
					req.setAttribute("currentNo", page.getCurrentNo());
					//存储分页数
					req.setAttribute("totalPageCount", page.getTotalPageCount());
					//存储下次的跳转类型
					req.setAttribute("type", "changeTopic");
					req.setAttribute("tid", tId);
									
				}else{
					//如果当前页没有新闻集合
					req.setAttribute("noMsg", "noMsg");
				}
			}
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);	
	}
}
