<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring/xhr.jsp</title>
<script>
	function dupCheck() {
		//1. xhr 객체 생성
		var xhr = new XMLHttpRequest();
		
		//2. 콜백 함수
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {  //응답 완료
				if(xhr.status == 200)  {  //전송 OK
					//결과 처리 = JSON
					//var jsondata = eval();
// 					var jsondata = JSON.parse(xhr.responseText);  //string -> object
// 					document.getElementById("result").innerHTML = jsondata.userid + ":" + jsondata.result;

					//결과 처리 = xml
					var datas = xhr.responseXML;
					var userid = datas.getElementsByTagName("userid")[0].firstChild.nodeValue;
					var result = datas.getElementsByTagName("result")[0].firstChild.nodeValue;
					document.getElementById("result").innerHTML = "xml -> " + userid + ":" + result;
				} else {
					//에러 메시지
					alert(xhr.status + ":" + xhr.statusText );
				}
			} else {
				//로딩 중 이미지
				document.getElementById("result").innerHTML = "처리 중";
			}
		}
		//3. open (서버 연결)
		//쿼리문 작성
		var param = "?id=" + document.getElementById("userid").value;
		xhr.open("GET", "LoginCheck.do"+param  );
		
		//4. send
		xhr.send();
	}
</script>
</head>
<body>

<form>
	<input type="text" name="userid" id="userid" onChange="dupCheck()" /><span id="result"></span>
	<input type="text" name="userpw" id="userpw" />
	<input type="submit" value="로그인" />
</form>

</body>
</html>