package com.news.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 实体类（新闻）
 *
 */
public class News implements Serializable {
	//新闻id
	private Integer nId;
	//新闻主题id
	private Integer ntId;
	//新闻标题
	private String nTitle;
	//新闻作者
	private String nauthor;
	//新闻创建时间
	private Date nCreateDate;
	//新闻图片地址
	private String nPicPaht;
	//新闻文本
	private String nContent;
	//新闻最后修改时间
	private Date nModifyDate;
	//新闻摘要
	private String nSumary;
	public Integer getnId() {
		return nId;
	}
	public void setnId(Integer nId) {
		this.nId = nId;
	}
	public Integer getNtId() {
		return ntId;
	}
	public void setNtId(Integer ntId) {
		this.ntId = ntId;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public Date getnCreateDate() {
		return nCreateDate;
	}
	public void setnCreateDate(Date nCreateDate) {
		this.nCreateDate = nCreateDate;
	}
	public String getnPicPaht() {
		return nPicPaht;
	}
	public void setnPicPaht(String nPicPaht) {
		this.nPicPaht = nPicPaht;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public Date getnModifyDate() {
		return nModifyDate;
	}
	public void setnModifyDate(Date nModifyDate) {
		this.nModifyDate = nModifyDate;
	}
	public String getnSumary() {
		return nSumary;
	}
	public void setnSumary(String nSumary) {
		this.nSumary = nSumary;
	}
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(Integer nId, Integer ntId, String nTitle, String nauthor,
			Date nCreateDate, String nPicPaht, String nContent,
			Date nModifyDate, String nSumary) {
		super();
		this.nId = nId;
		this.ntId = ntId;
		this.nTitle = nTitle;
		this.nauthor = nauthor;
		this.nCreateDate = nCreateDate;
		this.nPicPaht = nPicPaht;
		this.nContent = nContent;
		this.nModifyDate = nModifyDate;
		this.nSumary = nSumary;
	}
	public News(Integer ntId, String nTitle, String nauthor, String nContent,
			String nSumary) {
		super();
		this.ntId = ntId;
		this.nTitle = nTitle;
		this.nauthor = nauthor;
		this.nContent = nContent;
		this.nSumary = nSumary;
		//不上传图片路径
		this.nPicPaht=null;
	}
	
	
	
	
	
	
}
