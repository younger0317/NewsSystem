<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1 id="opt_type">添加主题：</h1>
<form action="<%=request.getContextPath() %>/TopicServlet?type=add"
	method="post" onsubmit="return check()">
	<p>
		<label> 主题名称 </label> <input name="tname" id="tname" type="text"
			class="opt_input" />
	</p>
	<input name="action" type="hidden" value="addtopic"> <input
		type="submit" value="提交" class="opt_sub" /> <input type="reset"
		value="重置" class="opt_sub" />
</form>


