package com.news.entity;

import java.io.Serializable;

/**
 * 
 * @author linbingyang
 * @version 1.0
 * 实体类（用户）
 *
 */
public class NewsUser implements Serializable{
	//用户id
	private Integer uId;
	//用户名字
	private	String uName;
	//用户密码
	private	String uPwd;
	
	
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	
	
	public NewsUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsUser(String uName, String uPwd) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
	}
	public NewsUser(Integer uId, String uName, String uPwd) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPwd = uPwd;
	}
	
	
}
