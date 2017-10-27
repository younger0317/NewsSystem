package com.news.service.impl;

import java.sql.Connection;
import java.util.List;

import com.news.dao.TopicDao;
import com.news.dao.impl.TopicDaoImpl;
import com.news.entity.Topic;
import com.news.service.TopicService;
import com.news.util.DatabaseUtil;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 主题服务实现类
 *
 */
public class TopicServiceImpl implements TopicService {
	
	/**
	 * 查找所有的主题
	 */
	@Override
	public List<Topic> findAllTopic() {
		List<Topic> topicsList = null;
		//获得链接
		Connection conn = DatabaseUtil.getConnection();
		//创建topicDao对象
		TopicDao topicDao = new TopicDaoImpl(conn);
		
		topicsList = topicDao.getAllTopic();
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return topicsList;
	}

	/**
	 * 更改主题名字
	 */
	@Override
	public int changeTopicName(int tid, String tName) {
		int update = 0;
		//获得链接
		Connection conn = DatabaseUtil.getConnection();
		//创建topicDao对象
		TopicDao topicDao = new TopicDaoImpl(conn);
		
		update=topicDao.changeTopicName(tid, tName);
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return update;
	}
	
	/**
	 * 同过主题名称找主题
	 */
	@Override
	public boolean findTopicByTname(String tName) {
		//获得链接
		Connection conn = DatabaseUtil.getConnection();
		//创建topicDao对象
		TopicDao topicDao = new TopicDaoImpl(conn);
		boolean flag = false;
		Topic topic = topicDao.getTopicByTname(tName);
		if(topic == null){
			flag = true;
		}
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return flag;
	}
	
	/**
	 * 添加主题
	 */
	@Override
	public boolean addTopic(String tName) {
		//获得链接
		Connection conn = DatabaseUtil.getConnection();
		//创建topicDao对象
		TopicDao topicDao = new TopicDaoImpl(conn);	
		boolean flag = false;
		int addTopic = topicDao.addTopic(tName);
		if(addTopic>0){
			flag = true;
		}
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return flag;
	}
	
	/**
	 * 删除主题
	 */
	@Override
	public boolean delTopic(int tid) {
		//获得链接
		Connection conn = DatabaseUtil.getConnection();
		//创建topicDao对象
		TopicDao topicDao = new TopicDaoImpl(conn);	
		
		boolean flag = false;
		int addTopic = topicDao.delTopic(tid);
		if(addTopic>0){
			flag = true;
		}
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return flag;
	}

}
