<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertUserVaild.jsp</title>
<script type="text/javascript" src="<c:url value="validator.do"/>"></script>
<validator:javascript formName="userDTO" staticJavascript="false" xhtml="true" cdata="false" />
</head>
<body>
	<h3>회원 등록</h3>
	<form:form action="insertUser.do" commandName="userDTO" onsubmit="return validateUserDTO(this)">
		id <form:input path="id" /><br>
		pw <form:input path="password" /><br>
		name <form:input path="name" /><br>
		role<form:select path="role">
			<form:options items="${roleMap}" />
		</form:select><br>
		<input type="submit" value="등록"/>
	</form:form>
</body>
</html>