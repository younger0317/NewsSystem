<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<ul class="classlist">
	<c:choose>
		<c:when test="${topicList != null}">
			<c:forEach items="${topicList}" var="topic" varStatus="status">
				<li>${topic.tName } &nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="javascript:var tid=${topic.tId};tName='${topic.tName}';toTopicModify()">修改</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:var tid=${topic.tId};toDel()">删除</a>
				</li>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h3>没找到任何信息</h3>
		</c:otherwise>
	</c:choose>
</ul>

