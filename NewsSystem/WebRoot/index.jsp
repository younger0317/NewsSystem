<%@page import="com.news.entity.Topic"%>
<%@page import="com.news.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String noMsg = (String) request.getAttribute("noMsg");
	//获取中心新闻集合
	List<News> mainNewsList = (List<News>)request.getAttribute("mainNewsList");
	//如果noMsg不等于null，说明当前页的内容为空
	if(noMsg==null){
		//根据是否获得新闻集合，判断是否第一次访问本页面
		if(mainNewsList == null){
			request.setAttribute("type", "fristVisit");
			request.getRequestDispatcher("NewsServlet").forward(request, response);
			return;
		}	
	}

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function login(){
		var uName = document.getElementById("uname");
		var uPwd = document.getElementById("upwd");
		
		if(uName.value==""||uPwd.value==""){
			alert("用户名密码不能为空");
		}
		
		location.href="LoginServlet?uName="+uName.value+"&uPwd="+uPwd.value;
	}
</script>
</head>
<body>
<div id="header">
  <div id="top_login">&nbsp; 
    
    <input type="text" id="uname" value="" class="login_input" />
    <label> 密&#160;&#160;码 </label>
    <input type="password" id="upwd" value="" class="login_input" />
    <input type="button" class="login_sub" value="登录" onclick="login()"/>
    <label id="error"> </label>
    <img src="images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
       
        <c:forEach items="${requestScope.nationNewsList }" var="nationNews" varStatus="status" >
        	<li> <a href='#'><b> ${nationNews.nTitle } </b></a> </li>
        </c:forEach>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
       	<c:forEach items="${requestScope.internationNewsList }" var="internationNews" varStatus="status" >
        	<li> <a href='#'><b> ${internationNews.nTitle } </b></a> </li>
        </c:forEach>
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <c:forEach items="${requestScope.entertainmentNewsList }" var="entertainmentNews" varStatus="status" >
        	<li> <a href='#'><b> ${entertainmentNews.nTitle } </b></a> </li>
        </c:forEach>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      	<%
      		List<Topic> topicList =(List<Topic>) request.getAttribute("topicList");
      		int row = topicList.size()%11 == 0 ? topicList.size()/11 : (topicList.size()/11)+1;
      		int index = 0;
      		for(int i = 0; i<row;i++){
      	 %>
      	 	 <li id='class_month'>
      	 	 	<%
      	 	 		for(int j=0; j<11;j++){
      	 	 	 %>
      	 	 		<a href='NewsServlet?currentNo=1&type=changeTopic&tid=<%=topicList.get(index).gettId()%>'><b><%=topicList.get(index).gettName() %> </b></a>
      	 	 	<%
      	 	 		index++;
      	 	 		if(index==topicList.size()){
      	 	 			break;
      	 	 		}
      	 	 	}
      	 	 	 %>
      	 	 </li>
      	 <%
      	 }
      	  %>
      </ul>
      <ul class="classlist">
       	<c:choose>
			<c:when test="${requestScope.noMsg != 'noMsg' }">
				<c:forEach items="${requestScope.mainNewsList}" var="news" varStatus="status">
					<li><a href='news_read.jsp'>${news.nTitle }</a><span> ${news.nCreateDate } </span></li>
				
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h2>没有找到相关得信息</h2>
			</c:otherwise>     	
       	</c:choose>
        <p align="right"> 当前页数:[${requestScope.currentNo }/${requestScope.totalPageCount }]&nbsp; 
        	<c:if test="${requestScope.currentNo != 1 }">
        		<a href="NewsServlet?type=${requestScope.type }&currentNo=1&tid=${requestScope.tid}">首页</a>
        	</c:if>
        	<c:if test="${requestScope.currentNo > 1 }">
        		<a href="NewsServlet?type=${requestScope.type }&currentNo=${requestScope.currentNo-1 }&tid=${requestScope.tid}">上一页</a>
        	</c:if>
        	<c:if test="${requestScope.currentNo < requestScope.totalPageCount  }">
        		<a href="NewsServlet?type=${requestScope.type }&currentNo=${requestScope.currentNo+1 }&tid=${requestScope.tid}">下一页</a> 
        	</c:if>
        	<c:if test="${requestScope.currentNo != requestScope.totalPageCount  }">
        		<a href="NewsServlet?type=${requestScope.type }&currentNo=${requestScope.totalPageCount}&tid=${requestScope.tid}">末页</a>         	
        	</c:if>
        </p>
      </ul>
    </div>
    <div class="picnews">
      <ul>
        <li> <a href="#"><img src="images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
        <li> <a href="#"><img src="images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
        <li> <a href="#"><img src="images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
        <li> <a href="#"><img src="images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
      </ul>
    </div>
  </div>
</div> 
<div id="footer">  
 <iframe src="index-elements/index_bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
</div> 
</body>
</html>
	