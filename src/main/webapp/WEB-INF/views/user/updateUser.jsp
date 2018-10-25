<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateUser.jsp</title>
</head>
<body>
	<h3>회원정보 수정</h3>
	<form action="updateUser.do">
		id <input type="text" name="id" value="${user.id}"><br>
		pw <input type="text" name="password" value="${user.password}"><br>
		name <input type="text" name="name" value="${user.name}"><br>
		role<select name="role">
			<c:forEach items="${roleMap}" var="temp">
				<option value="${temp.key}">${temp.value}</option>
			</c:forEach>
		</select><br>
	<input type="submit" value="수정"/>
	</form>
</body>
</html>