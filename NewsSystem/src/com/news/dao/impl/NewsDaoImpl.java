package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.news.dao.BaseDao;
import com.news.dao.NewsDao;
import com.news.entity.News;
import com.news.util.DatabaseUtil;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 新闻Dao实现类
 *
 */
public class NewsDaoImpl extends BaseDao<News> implements NewsDao {
	/**
	 * 继承父类构造方法，获取数据库链接
	 * @param conn 数据库链接
	 */
	public NewsDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 查找当前页的新闻集合
	 */
	@Override
	public List<News> findPageNews(Integer currentNo, Integer pageSize) {
		List<News> newsList = null;
		String sql = "select * from news limit ?,?";
		newsList = super.executeQuery(sql, new Object[]{(currentNo-1)*pageSize,pageSize});
		return newsList;
	}
	
	
	/**
	 * 查找指定主题的当前页新闻集合
	 */
	@Override
	public List<News> findPageNewsByTid(Integer currentNo, Integer pageSize,
			Integer tid) {
		List<News> newsList = null;
		String sql = "select * from news where ntid = ? limit ?,?";
		newsList = super.executeQuery(sql, new Object[]{tid,(currentNo-1)*pageSize,pageSize});
		return newsList;
	}

	/**
	 * 查找指定主题的前新闻集合
	 */
	@Override
	public List<News> findNewsListByTid(Integer tid) {
		List<News> newsList = null;
		String sql = "select * from news where ntid = ? order by ncreateDate desc limit 5";
		newsList = super.executeQuery(sql, new Object[]{tid});
		return newsList;
	}
	
	/**
	 * 获取新闻总条数
	 */
	@Override
	public int getTotalCount() {
		String sql = "select count(1) from news";
		PreparedStatement ps =null;
		ResultSet rs =null;
		int totalCount = 0;
		
		try {
			ps = super.getConn().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, ps, rs);
		}
		return totalCount;
	}
	
	/**
	 * 获取新闻总条数
	 */
	@Override
	public int getTotalCountByTid(int tid) {
		String sql = "select count(1) from news where ntid=?";
		PreparedStatement ps =null;
		ResultSet rs =null;
		int totalCount = 0;
		
		try {
			ps = super.getConn().prepareStatement(sql);
			ps.setObject(1, tid);
			rs = ps.executeQuery();
			if(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, ps, rs);
		}
		return totalCount;
	}
	
	/**
	 * 查找所有新闻
	 */
	@Override
	public List<News> findAllNews() {
		List<News> list=null;
		String sql = "select * from news ";
		list = super.executeQuery(sql, new Object[]{});
		return list;
	}

	/**
	 * 获取新闻实体对象
	 */
	@Override
	public News getEntity(ResultSet rs) {
		News news = null;
		if(rs != null){
			try {
				int nId = rs.getInt("nid");
				int ntId = rs.getInt("ntid");
				String nTitle = rs.getString("ntitle");
				String nauthor = rs.getString("nauthor");
				Timestamp timestamp = rs.getTimestamp("ncreateDate");
				Date nCreateDate = new Date(timestamp.getTime());
				String nPicPaht = rs.getString("npicPath");
				String nContent = rs.getString("nContent");
				Timestamp timestamp2 = rs.getTimestamp("nmodifyDate");
				Date nModifyDate = new Date(timestamp2.getTime());
				String nSumary = rs.getString("nsummary");
				
				news = new News(nId, ntId, nTitle, nauthor, nCreateDate, nPicPaht, nContent, nModifyDate, nSumary);
				return news;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return news;
	}

}
