<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1 id="opt_type">修改主题：</h1>
<%-- <form
	action="<%=request.getContextPath() %>/TopicServlet?type=modify>"
	method="post" submit="toChangeTopic()"> --%>
<form method="post">
	<p>
		<label> 主题名称</label> <input id="tName" name="tname" type="text"
			class="opt_input" value="${requestScope.tName }" />
	</p>
	<input name="tid" id="tid" type="hidden" value="${requestScope.tid }">
	<input type="button" value="提交" class="opt_sub" onclick="toChangeTopic()" /> <input type="reset"
		value="重置" class="opt_sub"  />
</form>

