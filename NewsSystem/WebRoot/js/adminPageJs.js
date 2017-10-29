
function init(){
	$("#opt_area").load("../AdminNewsServlet","type=list");
};
		
function toTopic() {
	$("#opt_area").load("../AdminNewsServlet", "type=topicList");
}

function toAddTopic(){
	$("#opt_area").load("../AdminNewsServlet", "type=toAddTopic");
}

function toTopicModify(){
	$("#opt_area").load("../AdminNewsServlet", "type=modify&tid="+tid+"&tName="+tName);
}

function toDel(){
	$.get("../TopicServlet","type=del&tid="+tid,delBack);
	function delBack(data){
		alert(data);
		if(data == "true"){
			alert("删除成功");
			toTopic();
		}else{
			alert("删除失败");
		}
	}
}

function toChangeTopic(){
	var tid = $("#tid").val();
	var tName = $("#tName").val();
	$.get("../TopicServlet","type=modify&tid="+tid+"&tName="+tName,callBack);
	
	function callBack(data){
		if(data=="true"){
			alert("修改成功");
			toTopic();
		}else{
			alert("失败");
		}
	}	
}

function doAddTopic(){
	var tName=$("#tname").val();
	$.get("../TopicServlet","type=add&tName="+tName,callBack1);
	
	function callBack1(data){
		if(data=="true"){
			alert("添加成功");
			toTopic();
		}else{
			alert("添加失败");
		}
	}
}

function toAddNews(){
	$("#opt_area").load("../AdminNewsServlet", "type=newsAdd");
}


function doAddNews(){
	//alert($("#select").val());
	var ntid = $("#select").val();
	var ntitle = $("#ntitle").val();
	var nauthor = $("#nauthor").val();
	var nsummary = $("#nsummary").val();
	var ncontent = $("#ncontent").val();
	
	$.get("../DoNews","type=add&ntid="+ntid+"&ntitle="+ntitle+"&nauthor="+nauthor+"&nsummary="+nsummary+"&ncontent="+ncontent,addNewsBack);
	
	function addNewsBack(data){
		if(data == "true"){
			alert("添加成功");
			init();
		}else{
			alert("添加失败");
			init();
		}
	}
}

function delNews(){
	
	$.get("../DoNews","type=del&nid="+nid,delNewsBack);
	
	function delNewsBack(data){
		if(data == "true"){
			alert("删除成功");
			init();
		}else{
			alert("删除失败");
			init();
		}
	}
	
}
