
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
	alert('aaa');
	$("#opt_area").load("../AdminNewsServlet", "type=modify&tid="+tid);
}
