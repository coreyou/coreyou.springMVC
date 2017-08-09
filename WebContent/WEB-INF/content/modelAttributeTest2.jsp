<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modelAttributeTest2</title>
</head>
<body>
	<!-- submit到 ModelAttribute2Controller 的 login2() -->
	<form action="modelAttributeTest2/login2" method="post">
		<table>
			<tr>
				<td><label>使用者名稱:</label></td>
				<td><input type="text" id="userName" name="userName"></td>
			</tr>
			<tr>
				<td><label>密碼:</label></td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr>
				<td><input id="submit" type="submit" value="登入"></td>
			</tr>
		</table>
	</form>
</body>
</html>