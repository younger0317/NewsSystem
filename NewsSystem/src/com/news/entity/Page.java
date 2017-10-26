package com.news.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 实体类（分页）
 * @param <T> 相应的分页内容实体
 */
public class Page<T> implements Serializable {
	// 当前页
	private int currentNo;
	// 总页数
	private int totalPageCount;
	// 总条数
	private int totalCount;
	// 页面大小
	private int pageSize;
	// 页面所要的实体集合
	private List<T> list;
	
	
	public int getCurrentNo() {
		return currentNo;
	}
	public void setCurrentNo(int currentNo) {
		this.currentNo = currentNo;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int currentNo, int totalPageCount, int totalCount,
			int pageSize, List<T> list) {
		super();
		this.currentNo = currentNo;
		this.totalPageCount = totalPageCount;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [currentNo=" + currentNo + ", totalPageCount="
				+ totalPageCount + ", totalCount=" + totalCount + ", pageSize="
				+ pageSize + ", list=" + list + "]";
	}
	
	
	
} 
