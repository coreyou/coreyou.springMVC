<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>資料轉換</title>
</head>
<body>
	<form action="register" method="post">
		<table>
			<tr>
				<td>帳號</td>
				<td><input type="text" id="userName" name="userName"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" id="birthday" name="birthday" value="1986-12-01"></td>
			</tr>
			<tr>
				<td><input id="submit" type="submit" value="登入"></td>
			</tr>
		</table>
	</form>
</body>
</html>