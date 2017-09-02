<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入頁_國際版</title>
</head>
<body>
	<h3><spring:message code="title"/></h3>
	<form:form modelAttribute="user" action="i18nLogin" method="post">
		<table>
			<tr>
				<td><spring:message code="userName"/></td>
				<td><form:input path="userName" value="coreyou"/></td>
			</tr>
			<tr>
				<td><spring:message code="password"/></td>
				<td><form:input path="password" value="123456"/></td>
			</tr>
			<tr>
				<td><input id="submit" type="submit" value="<spring:message code='submit'/>"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>