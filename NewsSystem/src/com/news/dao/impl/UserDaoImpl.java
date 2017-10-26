package com.news.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.news.dao.BaseDao;
import com.news.dao.UserDao;
import com.news.entity.NewsUser;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 用户Dao实现类
 *
 */
public class UserDaoImpl extends BaseDao<NewsUser> implements UserDao {
	/**
	 * 继承父类构造方法
	 * @param conn
	 */
	public UserDaoImpl(Connection conn) {
		super(conn);
	}
	
	/**
	 * 查找指定用户
	 */
	@Override
	public NewsUser findUserByUserNameAndPwd(String uName, String Pwd) {
		String sql = "select * from news_users where uname=? and upwd=?";
		NewsUser newsUser = null;
		List<NewsUser> list = super.executeQuery(sql, new Object[]{uName,Pwd});
		if(list != null && list.size()>0){
			newsUser = list.get(0);
		}
		return newsUser;
	}

	/**
	 * 获取用户对象
	 */
	@Override
	public NewsUser getEntity(ResultSet rs) {
		if(rs != null){
			try {
				int uId = rs.getInt("uid");
				String uName = rs.getString("uname");
				String uPwd = rs.getString("upwd");
				
				return new NewsUser(uId, uName, uPwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
