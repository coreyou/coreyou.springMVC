<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入頁</title>
</head>
<body>
	<h3>歡迎 ${requestScope.user.userName} 登入(UserController.java)</h3>
	<h3>歡迎 ${sessionScope.user.userName} 登入(SessionAttributeController.java)</h3>
</body>
</html>