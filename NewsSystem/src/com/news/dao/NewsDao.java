package com.news.dao;

import java.util.List;

import com.news.entity.News;

/**
 * 
 * @author linbingyang
 * @version 1.0
 * 新闻DAO接口
 *
 */
public interface NewsDao {
	/**
	 * 查找当前页新闻集合
	 * @param currentNo 当前页
	 * @param pageSize 页面大小
	 * @return 新闻集合
	 */
	public List<News> findPageNews(Integer currentNo,Integer pageSize);

	/**
	 * 查找指定主题的当前页新闻集合
	 * @param currentNo 当前页
	 * @param pageSize 页面大小
	 * @param tid 主题id
	 * @return 新闻集合
	 */
	public List<News> findPageNewsByTid(Integer currentNo, Integer pageSize,Integer tid);
	
	/**
	 * 查找指定主题的新闻集合
	 * @param tid 主题id
	 * @return 新闻集合
	 */
	public List<News> findNewsListByTid(Integer tid);
	
	/**
	 * 获取新闻总条数
	 * @return 新闻总条数
	 */
	public int getTotalCount();
	
	/**
	 * 获取指定主题新闻总条数
	 * @return 新闻总条数
	 */
	public int getTotalCountByTid(int tid);
	
	/**
	 * 获取所有新闻
	 * @return
	 */
	public List<News> findAllNews();
	
	
}
