<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scriptObjectTest.jsp</title>
<script>
	//클래스를 생성자 형식으로 정의
	function Employee(name, sal) {
		this.name = name;
		this.sal = sal;
	}
	
	//객체(인스턴스) 생성
	var emp1 = new Employee('Choi', 3000);
	
	//필드 접근
	document.write(emp1.name);
	document.write(emp1);
	
	//클래스 원형 수정
	Employee.prototype.deptno = 10;
	
	document.write(emp1.deptno);
	
	emp1.hiredate = '2018';
</script>
</head>
<body>

</body>
</html>