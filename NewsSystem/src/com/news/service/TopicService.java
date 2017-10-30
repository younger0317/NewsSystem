package com.news.service;

import java.util.List;

import com.news.entity.Topic;

/**
 * 
 * @author linbingyang
 * @version 1.0
 * 主题服务接口
 */
public interface TopicService {
	/**
	 * 查找所有的主题
	 * @return
	 */
	public List<Topic> findAllTopic();
	
	/**
	 * 更改主题名字
	 * @param tid 主题id
	 * @param tName 新主题名
	 * @return 更新行数
	 */
	public int changeTopicName(int tid,String tName);
	
	/**
	 * 通过主题名称找主题
	 * @param tName 主题名称
	 * @return 找到返回ture，找不到返回false
	 */
	public boolean findTopicByTname(String tName);
	
	/**
	 * 添加主题
	 * @param tName
	 * @return
	 */
	public boolean addTopic(String tName);
	
	/**
	 * 删除主题
	 * @param tid 主题id
	 * @return
	 */
	public boolean delTopic(int tid);
}
