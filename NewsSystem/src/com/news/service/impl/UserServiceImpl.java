package com.news.service.impl;

import java.sql.Connection;

import com.news.dao.UserDao;
import com.news.dao.impl.UserDaoImpl;
import com.news.entity.NewsUser;
import com.news.service.UserService;
import com.news.util.DatabaseUtil;
/**
 * 
 * @author linbingyang
 * @version 1.0
 * 用户服务实现类
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public NewsUser findUserByUserAndPwd(String uName, String Pwd) {
		//获取链接
		Connection conn = DatabaseUtil.getConnection();
		//创建userDao对象
		UserDao userDao = new UserDaoImpl(conn);
		NewsUser newsUser = userDao.findUserByUserNameAndPwd(uName, Pwd);
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return newsUser;
	}

}
