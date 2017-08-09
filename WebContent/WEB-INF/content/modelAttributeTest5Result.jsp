<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	user: ${requestScope.user}<br />
	userName: ${requestScope.user.userName}<br />
	password: ${requestScope.user.password}<br />
	ip: ${requestScope.user.ip}
</body>
</html>