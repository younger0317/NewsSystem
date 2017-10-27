<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1 id="opt_type">添加新闻：</h1>
<form method="post">
	<p>
		<label> 主题 </label> <select name="ntid" id="select">
			<c:forEach items="${requestScope.topicList }" var="topic" varStatus="status">
				<option value="${topic.tId }">${topic.tName}</option>
			</c:forEach>
		</select>
	</p>
	<p>
		<label> 标题 </label> <input id="ntitle" name="ntitle" type="text" class="opt_input" />
	</p>
	<p>
		<label> 作者 </label> <input id="nauthor" name="nauthor" type="text"
			class="opt_input" />
	</p>
	<p>
		<label> 摘要 </label>
		<textarea id="nsummary" name="nsummary" cols="40" rows="3"></textarea>
	</p>
	<p>
		<label> 内容 </label>
		<textarea id="ncontent" name="ncontent" cols="70" rows="10"></textarea>
	</p>
	<p>
		<label> 上传图片[未完成] </label> <input name="file" type="file" class="opt_input" />
	</p>
	<input name="action" type="hidden" value="addnews" /> <input
		type="button" value="提交" class="opt_sub" onclick="doAddNews()" /> <input type="reset"
		value="重置" class="opt_sub" />
</form>
