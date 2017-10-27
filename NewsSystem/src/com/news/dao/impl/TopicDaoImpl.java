package com.news.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.news.dao.BaseDao;
import com.news.dao.TopicDao;
import com.news.entity.Topic;

public class TopicDaoImpl extends BaseDao<Topic> implements TopicDao {
	/**
	 * 继承父类构造方法，获取数据库链接
	 * @param conn 数据库链接
	 */
	public TopicDaoImpl(Connection conn) {
		super(conn);
	}
	
	/**
	 * 获得所有主题
	 */
	@Override
	public List<Topic> getAllTopic() {
		List<Topic> topicList = null;
		String sql = "select * from topic";
		topicList = super.executeQuery(sql, null);
		return topicList;
	}

	/**
	 * 修改指定主题名
	 */
	@Override
	public int changeTopicName(int tid, String tName) {
		String sql = "update topic set tname = ? where tid = ?";
		return super.executeUpdate(sql, new Object[]{tName,tid});
	}
	
	/**
	 * 获取指定名称的主题
	 */
	@Override
	public Topic getTopicByTname(String tName) {
		Topic topic = null;
		String sql = "select * from topic where tname = ?";
		List<Topic> list = super.executeQuery(sql, new Object[]{tName});
		if(list != null && list.size()>0){
			topic = list.get(0);
		}
		return topic;
	}
	
	/**
	 * 添加主题
	 */
	@Override
	public int addTopic(String tName) {
		String sql = "insert into topic(tname) values (?)";
		return super.executeUpdate(sql, new Object[]{tName});
	}
	
	/**
	 * 删除主题
	 */
	@Override
	public int delTopic(int tid) {
		int update =0;
		String sql = "delete from topic where tid=?";
		update = super.executeUpdate(sql, new Object[]{tid});
		return update;
	}
	
	/**
	 * 获得主题对象
	 */
	@Override
	public Topic getEntity(ResultSet rs) {
		if(rs != null){
			try {
				int tId = rs.getInt("tid");
				String tName = rs.getString("tname");
				
				return new Topic(tId, tName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
