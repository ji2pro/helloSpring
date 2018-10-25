<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<hr>
UserDTO : ${userDTO}<br>
user : ${user}<br>
<hr>
	<h3>로그인</h3>
	<form action="login.do" method="post">
		id <input type="text" name="id" value="${user.id}"><br>
		pw <input type="text" name="password" value="${user.password}"><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>