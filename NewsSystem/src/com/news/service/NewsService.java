package com.news.service;

import java.util.List;

import com.news.entity.News;
import com.news.entity.Page;

/**
 * 
 * @author linbingyang
 * @version 1.0
 * 新闻服务接口
 */
public interface NewsService {
	
	/**
	 * 获取分页新闻集合
	 * @param currentNo 当前页
	 * @param pageSize 页面大小
	 * @return 当前页面对象
	 */
	public Page<News> getPageNewsList(Integer currentNo,Integer pageSize);
	
	/**
	 * 获取指定主题的分页新闻集合
	 * @param currentNo 当前页
	 * @param pageSize 页面大小
	 * @param tid 主题id
	 * @return 当前页面对象
	 */
	public Page<News> getPageNewsListByTid(Integer currentNo,Integer pageSize,Integer tid);
	
	/**
	 * 统计新闻总条数
	 */
	public int getTotalCount();
	/**
	 * 统计指定主题新闻总条数
	 */
	public int getTotalCountByTid(int tid);
	/**
	 * 获取指定主题新闻集合
	 * @param tid 主题id
	 * @return 新闻列表
	 */
	public List<News> getNewsListByTid(Integer tid);
	
}
