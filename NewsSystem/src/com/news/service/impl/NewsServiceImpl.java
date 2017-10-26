package com.news.service.impl;

import java.sql.Connection;
import java.util.List;

import com.news.dao.NewsDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.entity.News;
import com.news.entity.Page;
import com.news.service.NewsService;
import com.news.util.DatabaseUtil;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 新闻服务实现类
 *
 */
public class NewsServiceImpl implements NewsService {
	/**
	 * 获取分页新闻列表
	 */
	@Override
	public Page<News> getPageNewsList(Integer currentNo, Integer pageSize) {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建新闻Dao对象
		NewsDao newsDao = new NewsDaoImpl(conn);
		//获取当前页新闻集合
		List<News> newsList = newsDao.findPageNews(currentNo, pageSize);
		//创建当前页对象
		Page<News> page = new Page<News>();
		//如果当前页新闻集合存在，更新当前页对象
		if(newsList != null && newsList.size()>0){
			page.setCurrentNo(currentNo);
			page.setPageSize(pageSize);
			page.setList(newsList);
			int totalCount = this.getTotalCount();
			page.setTotalCount(totalCount);
			page.setTotalPageCount(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1 );			
		}
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return page;
	}

	/**
	 * 获取指定主题分页新闻列表
	 */
	@Override
	public Page<News> getPageNewsListByTid(Integer currentNo, Integer pageSize,
			Integer tid) {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建新闻Dao对象
		NewsDao newsDao = new NewsDaoImpl(conn);
		//获取指定主题分页新闻列表
		List<News> newsList = newsDao.findPageNewsByTid(currentNo, pageSize, tid);
		//创建当前页对象
		Page<News> page = new Page<News>();
		//如果当前页新闻集合存在，更新当前页对象
		if(newsList != null && newsList.size()>0){
			page.setCurrentNo(currentNo);
			page.setPageSize(pageSize);
			page.setList(newsList);
			int totalCount = this.getTotalCountByTid(tid);
			page.setTotalCount(totalCount);
			page.setTotalPageCount(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1 );			
		}
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return page;
	}
	
	/**
	 * 获取指定主题集合
	 */
	@Override
	public List<News> getNewsListByTid(Integer tid) {
		List<News> newsList = null; 
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建新闻Dao对象
		NewsDao newsDao = new NewsDaoImpl(conn);
		newsList = newsDao.findNewsListByTid(tid);
		//关闭资源
				DatabaseUtil.closeAll(conn, null, null);
		return newsList;
	}
	
	/**
	 * 统计新闻总条数
	 */
	@Override
	public int getTotalCount() {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建新闻Dao对象
		NewsDao newsDao = new NewsDaoImpl(conn);
		int totalCount = newsDao.getTotalCount();
		DatabaseUtil.closeAll(conn, null, null);
		return totalCount;
	}
	
	/**
	 * 统计指定主题新闻总条数
	 */
	@Override
	public int getTotalCountByTid(int tid) {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建新闻Dao对象
		NewsDao newsDao = new NewsDaoImpl(conn);
		int totalCount = newsDao.getTotalCountByTid(tid);
		DatabaseUtil.closeAll(conn, null, null);
		return totalCount;
	}
	
	/**
	 * 获取所有新闻
	 */
	@Override
	public List<News> getAllNews() {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建新闻Dao对象
		NewsDao newsDao = new NewsDaoImpl(conn);
		List<News> newsList =null;
		newsList = newsDao.findAllNews();
		DatabaseUtil.closeAll(conn, null, null);
		return newsList;
	}

}
