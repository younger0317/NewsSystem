package com.news.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author linbingyang
 * @author 1.0
 *	数据库链接类
 *	用于c层获取数据库链接和关闭操作
 */
public class DatabaseUtil {
	
	/**
	 * 获取数据库链接类
	 * @return
	 */
	public static Connection getConnection(){ 
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/news");
			conn = dataSource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭相关资源
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
