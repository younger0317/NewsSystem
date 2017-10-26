package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.util.DatabaseUtil;


/**
 * 
 * @author linbingyang
 * @version 1.0
 * 基础Dao，进行相应的数据库操作
 * @param <T> 对应的操作实体
 */

public abstract class BaseDao<T> {
	/**
	 * 保存BaseDao的链接对象
	 */
	private Connection conn;
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * BaseDao的有参构造方法，用于接受connection
	 * @param conn
	 */
	public BaseDao(Connection conn) {
	super();
	this.conn = conn;
	}

	/**
	 * 数据增、删、改操作
	 * @param sql
	 * @param parms
	 * @return
	 */
	public int executeUpdate(String sql,Object[] parms){
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parms.length; i++) {
				ps.setObject(i+1, parms[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, ps, null);
		}
		return -1;
	}
	
	/**
	 * 数据库查询操作
	 * @param sql
	 * @param parms
	 * @return 结果集
	 */
	public List<T> executeQuery(String sql,Object[] parms){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		
		try {
			ps= conn.prepareStatement(sql);
			if(parms != null){
				for (int i = 0; i < parms.length; i++) {
					ps.setObject(i+1, parms[i]);
				}				
			}
			rs = ps.executeQuery();
			while(rs.next()){
				T t = getEntity(rs);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, ps, rs);
		}
		return null;
	}
	
	/**
	 * 获取相应的实体对象
	 * @param rs
	 * @return
	 */
	public abstract T getEntity(ResultSet rs);
	
}
