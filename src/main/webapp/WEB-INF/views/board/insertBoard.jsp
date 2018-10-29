<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertBoard.jsp</title>
</head>
<body>
	<h3>파일 업로드</h3>
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
		title <input type="text" name="title" value="${board.title}"><br>
		writer <input type="text" name="writer" value="${board.writer}"><br>
		content <textarea rows="5" cols="40" name="content"></textarea><br>
		<input type="file" name="uploadFile" /><br>
		<input type="file" name="uploadFile" /><br>
		<input type="file" name="uploadFile" /><br>
		<input type="submit" value="업로드" />
	</form>
</body>
</html>