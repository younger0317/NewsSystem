package com.news.dao;

import java.util.List;

import com.news.entity.Topic;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 主题Dao接口
 *
 */
public interface TopicDao {
	/**
	 * 获得所有主题
	 * @return 主题集合
	 */
	public List<Topic> getAllTopic();
	
	/**
	 * 更改主题名字
	 * @param tid 主题id
	 * @param tName 新主题名字
	 * @return 更新行数
	 */
	public int changeTopicName(int tid,String tName);
	
	/**
	 * 通过指定名称获取主题
	 * @param tName 主题名称
	 * @return
	 */
	public Topic getTopicByTname(String tName);
	
	/**
	 * 添加主题
	 * @param tName
	 * @return
	 */
	public int addTopic(String tName);
	
	/**
	 * 删除主题
	 * @param tid 主题id
	 * @return
	 */
	public int delTopic(int tid);
}
