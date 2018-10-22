<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/getBoards.jsp</title>
</head>
<body>
<table border="1" style="width: 900px;">
	<thead>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>저자</td>
			<td>내용</td>
			<td>등록일</td>
			<td>조회</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.seq}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.content}</td>
				<td>${board.regdate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>