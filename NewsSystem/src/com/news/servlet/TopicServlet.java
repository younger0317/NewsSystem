package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.Topic;
import com.news.service.TopicService;
import com.news.service.impl.TopicServiceImpl;
/**
 * 
 * @author linbingyang
 * @version 2.0
 * 主题功能控制器
 *
 */
public class TopicServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		TopicService topicService = new TopicServiceImpl();
		
		String type = req.getParameter("type");
		System.out.println(">>>>>>>>>>>>come in,type:"+type);
		if(type != null){
			if(type.equals("modify")){
				String tName = req.getParameter("tName");
				boolean flag = topicService.findTopicByTname(tName);
				if(flag){
					String tidStr = req.getParameter("tid");
					int tid= Integer.parseInt(tidStr);
					int update = topicService.changeTopicName(tid, tName);
					out.print("true");	
				
				}else{
					out.print("false");
				}
			}else if(type.equals("add")){
				String tName = req.getParameter("tName");
				System.out.println("tName");
				boolean flag = topicService.findTopicByTname(tName);
				if(flag){
					boolean addTopic = topicService.addTopic(tName);
					out.print("true");	
				}else{
					out.print("false");
				}
			}else if(type.equals("del")){
				String tidStr = req.getParameter("tid");
				int tid= Integer.parseInt(tidStr);
				boolean delTopic = topicService.delTopic(tid);
				if(delTopic){
					out.print("true");	
				}else{
					out.print("false");
				}
				
			}
		}
		System.out.println(">>>>>>>>out");
		out.flush();
		out.close();
	}
}
