<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1 id="opt_type">修改主题：</h1>
<form
	action="<%=request.getContextPath() %>/TopicServlet?type=modify&tid=${param.tid } %>"
	method="post" onsubmit="return check()">
	<p>
		<label> 主题名称</label> <input name="tname" type="text" class="opt_input"
			value="${param.tName }" />
	</p>
	<input name="action" type="hidden" value="addtopic"> <input
		type="submit" value="提交" class="opt_sub" /> <input type="reset"
		value="重置" class="opt_sub" />
</form>

