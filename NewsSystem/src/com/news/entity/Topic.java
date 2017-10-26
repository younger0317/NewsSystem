package com.news.entity;

import java.io.Serializable;

/**
 * 
 * @author linbingyang
 * @version 1.0
 * 实体类（新闻主题）
 *
 */
public class Topic implements Serializable {

	//主题id
	private Integer tId;
	//主题名称
	private String tName;
	
	
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Topic(String tName) {
		super();
		this.tName = tName;
	}
	public Topic(Integer tId, String tName) {
		super();
		this.tId = tId;
		this.tName = tName;
	}
	
	
	
}
