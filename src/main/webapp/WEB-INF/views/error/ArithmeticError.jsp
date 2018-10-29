<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>산술 연산 에러</title>
</head>
<body>
	에러 : <%= exception.getMessage() %><br>
	관리자에게 문의하세요.<br>
	E mail: wona23@gmail.com
</body>
</html>