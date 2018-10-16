<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
//JSON = JavaScript Object Notation
	var obj = {deptno : 10, first_name: 'scott', salary : 2000};
	document.write(obj.first_name);  //이름 출력
	
	var arr = [
		{deptno : 10, first_name: 'scott', salary : 2000},
		{deptno : 20, first_name: 'hong', salary : 2000},
		{deptno : 30, first_name: 'gwon', salary : 2000}
	];
	document.write(arr[1].first_name);  //두 번째 사원의 이름 출력
	var arr2 = [
		{deptno : [1, 2, 3], first_name: 'scott', salary : 2000},
		{deptno : 20, first_name: 'hong', salary : 2000},
		{deptno : 30, first_name: 'gwon', salary : 2000}
	];
	document.write(arr2[0].deptno[0]);  //두 번째 사원의 이름 출력
</script>
</body>
</html>