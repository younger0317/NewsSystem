<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<ul class="classlist">
	<c:choose>
		<c:when test="${requestScope.noMsg != 'noMsg' }">
			<c:forEach items="${requestScope.newsList }" var="news"
				varStatus="status">
				<li>${news.nTitle } <span> 作者：${news.nauthor
						}&#160;&#160;&#160;&#160;<a
						href='news_modify.jsp?nid=${news.nId }'>修改</a>
						&#160;&#160;&#160;&#160; <a href='#'>删除</a> </span></li>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h2>没找到相关的新闻</h2>
		</c:otherwise>
	</c:choose>
</ul>
