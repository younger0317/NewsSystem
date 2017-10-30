<%@page import="com.news.entity.News"%>
<%@page import="com.news.entity.NewsUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//查看是否已经登陆
	NewsUser newsUser = (NewsUser)session.getAttribute("newsUser");
	if(newsUser == null){
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
	}
	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="../js/adminPageJs.js" ></script>
<script type="text/javascript">
	/*$(function(){
		init();
		alert("x");
	})*/
</script>
</head>
<body>
	<div id="main">
	   <div>
	    <iframe src="<%=request.getContextPath() %>/newspages/console_element/top.html" scrolling="no" frameborder="0" width="947px" height="180px"></iframe>
	  </div> 
	  <div id="opt_list">
	 	<%@include file="console_element/left.html" %>

	  </div>
	  <div id="opt_area"> 
	  
	  </div>	  
	  <iframe src="<%=request.getContextPath() %>/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
    </div>
</body>
</html>

	