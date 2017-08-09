<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	HelloController.hello(): ${requestScope.message}
	<br />
	HelloController.helloModel(): ${requestScope.user.userName}, ${requestScope.user.password}, ${requestScope.user.ip}
	<br />
	HelloController.helloModel(): ${requestScope.user2.userName}, ${requestScope.user2.password}, ${requestScope.user2.ip}
	<br />
	HelloController.helloModel(): ${requestScope.user3.userName}, ${requestScope.user3.password}, ${requestScope.user3.ip}
</body>
</html>