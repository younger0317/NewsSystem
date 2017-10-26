package com.news.dao;

import com.news.entity.NewsUser;

/**
 * 
 * @author linbingyang
 * @version 
 * 用户Dao接口
 *
 */
public interface UserDao {
	/**
	 * 用过用户名和用户密码查找用户对象
	 * @param uName 用户名
	 * @param Pwd 用户密码
	 * @return 
	 */
	public NewsUser findUserByUserNameAndPwd(String uName,String Pwd);
}
