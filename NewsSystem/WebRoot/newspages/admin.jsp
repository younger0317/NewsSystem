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
	//获取管理员页面的新闻集合
	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>添加主题--管理后台</title>
<link href="<%=request.getContextPath() %>/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main">
	   <div>
	    <iframe src="<%=request.getContextPath() %>/newspages/console_element/top.html" scrolling="no" frameborder="0" width="947px" height="180px"></iframe>
	  </div> 
	  <div id="opt_list">
	 	<iframe src="<%=request.getContextPath() %>/newspages/console_element/left.html" scrolling="no" frameborder="0" width="130px"></iframe>
	  </div>
	  <div id="opt_area"> 
	    <ul class="classlist">
		 <!-- <c:choose>
		  	<c:when test="${requestScope.noMsg != 'noMsg' }">
		  		<c:forEach items="${requestScope.mainNewsList }" var="news" varStatus="status">
		  			<li>${news.nTitle }
		  				<span>
		  					作者：${news.nauthor }&#160;&#160;&#160;&#160;<a href='news_modify.jsp'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> 
		  				</span>
		  			</li>
		  		</c:forEach>
		  	</c:when>
		  	<c:otherwise>
		  		<h2>没找到相关的新闻</h2>
		  	</c:otherwise>
		  
		  </c:choose>-->
	      <li class='space' id="controlPage"></li>
	      <p align="right" > 
	      	当前页数:[${requestScope.currentNo }/${requestScope.totalPageCount}]&nbsp; 
	      	<c:if test="${requestScope.currentNo != 1 }">
	      		<a href="<%=request.getContextPath() %>/AdminNewsServlet?type=noFrist&currentNo=1">首页</a> 
	      	</c:if>
	      	<c:if test="${requestScope.currentNo > 1 }">
	      		<a href="<%=request.getContextPath() %>/AdminNewsServlet?type=noFrist&currentNo=${requestScope.currentNo-1}">上一页</a> 
	      	</c:if>
	      	<c:if test="${requestScope.currentNo < requestScope.totalPageCount  }">
	      		<a href="<%=request.getContextPath() %>/AdminNewsServlet?type=noFrist&currentNo=${requestScope.currentNo+1}">下一页</a> 
	      	</c:if>
	     	<c:if test="${requestScope.currentNo != requestScope.totalPageCount }">
	     		<a href="<%=request.getContextPath() %>/AdminNewsServlet?type=noFrist&currentNo=${requestScope.totalPageCount}">末页</a> 
	     	</c:if>
	     	
	      </p>
	    </ul>
	  </div>	  
	  <iframe src="<%=request.getContextPath() %>/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
    </div>
</body>
</html>

	