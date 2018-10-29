<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user/getUsers.jsp</title>
<script>
	function go_page(p) {
		document.frm.page.value = p;
		document.frm.submit();
	}
	function sort(s) {
		document.frm.sort.value = s;
		document.frm.submit();
	}
</script>
</head>
<body>
<h2>
	<spring:message code="list.sample"></spring:message>
</h2>
<img src="./images/googlelogo_color_272x92dp.png" style="width: 200px">
<a href="insertUserForm.do">회원 등록</a><br>
<div>
	<form action="getUsers.do" name="frm">
		<input type="hidden" name="page" value="1">
		<input type="hidden" name="sort" value="id">
		role
		<select name="role">
			<option value="">선택</option>
			<c:forEach items="${roleMap}" var="temp">
				<option value="${temp.key}">${temp.value}</option>
			</c:forEach>
		</select>
		<select name="searchCondition">
			<option value="id">아이디</option>
			<option value="name">이름</option>
		</select>
		<script>
			document.frm.searchCondition.value = '${userSearchDTO.searchCondition}';
		</script>
		<input type="text" name="searchKeyword" value="${userSearchDTO.searchKeyword}">
		<input type="submit" value="<spring:message code="button.search" />">
	</form>
</div>
<table border="1" style="width: 500px;">
	<tr><td><a href="#" onclick="sort('id')">아이디</a></td>
		<td><a href="#" onclick="sort('name')">이름</a></td>
		<td>패스워드</td>
		<td>롤</td></tr>
	<c:forEach items="${list}" var="user">	
		<tr>
			<td><a href="updateUserForm.do/${user.id}">${user.id}</a></td>
			<td>${user.name}</td>
			<td>${user.password}</td>
			<td>${user.role}</td>
		</tr>
	</c:forEach>
</table>
<my:paging paging="${paging}" />
</body>
</html>