package com.news.service;

import com.news.entity.NewsUser;

/**
 * 
 * @author linbingyang
 * @version 1.0
 * 用户服务接口
 *
 */
public interface UserService {
	/**
	 * 查找指定用户
	 * @param uName 用户名
	 * @param Pwd 密码
	 * @return
	 */
	public NewsUser findUserByUserAndPwd(String uName,String Pwd);
}
