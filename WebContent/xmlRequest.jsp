<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>測試接收XML資料</title>
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="js/JSON-js-master/json2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		sendXML();
		readXML();
	});
	
	function sendXML() {
		var xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book><id>1</id><name>spring MVC 測試</name><author>coreyou</author></book>";
		$.ajax({
			url: "${pageContext.request.contextPath}/xml/sendXML",
			type: "post",
			headers: { 
		        //'Accept': 'application/xml',
		        'Content-Type': 'application/xml' 	// 前端發送類型
		    },
			data: xmlData,
			async: true
		});
	}
	
	function readXML() {
		$.ajax({
			url: "${pageContext.request.contextPath}/xml/readXML",
			type: "post",
			dataType: "text",
			async: true,
			success: function(data) {
				console.log(data);
				$("#id").html($("id", data).text());
				$("#name").html($("name", data).text());
				$("#author").html($("id", data).text());
			},
			error: function() {
				alert("資料接收失敗");
			}
		});
	}
</script>
</head>
<body>
	編號: <span id="id"></span><br />
	書名: <span id="name"></span><br />
	作者: <span id="author"></span><br />
</body>
</html>