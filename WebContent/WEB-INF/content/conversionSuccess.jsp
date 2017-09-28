<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>資料轉換_成功</title>
</head>
<body>
<%-- 	
	要使用JSTL(JSP Standard Tag Library)，必須先將以下兩個jar放到/WEB_INF/lib之下:
	1. javax.servlet.jsp.jstl-1.2.1.jar
	2. javax.servlet.jsp.jstl-api-1.2.1.jar
	
 --%>
	<p>使用者名稱: ${requestScope.user.userName}</p>
	生日: <fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日"/>
</body>
</html>