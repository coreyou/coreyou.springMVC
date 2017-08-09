<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>測試接收JSON資料</title>
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="js/JSON-js-master/json2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		testRequestBody();
	});
	
	function testRequestBody() {
		$.ajax({
			url: "${pageContext.request.contextPath}/json/testRequestBody",
			datatype: "json",
			type: "post",
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			data: JSON.stringify({"id": 1, name: "spring MVC 測試", author: "coreyou"}),
			async: true,
			success: function(data) {
				debugger;
				console.log(data);
				$("#id").html(data.id);
				$("#name").html(data.name);
				$("#author").html(data.author);
			},
			error: function() {
				alert("資料發送失敗");
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