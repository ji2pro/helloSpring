<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing Websockets</title>
</head>
<body>
	<fieldset>
		<textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea><br />
		<input id="inputMessage" type="text" />
		<button type="submit" onclick="send()">조회</button>
		<button type="submit" onclick="sendAll()">전체조회</button>
	</fieldset>
</body>
<script>
	var textarea = document.getElementById("messageWindow");
	//var webSocket = new WebSocket('ws://localhost:80/hellospring/broadcasting');
	//var webSocket = new WebSocket('ws://192.168.0.70:8081/spring/broadcasting');  //준우
	var webSocket = new WebSocket('ws://localhost/hellospring/springserver.do');
	var inputMessage = document.getElementById('inputMessage');
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	function onMessage(event) {
// 		textarea.value += "상대 : " + event.data + "\n";
		var msgdto = JSON.parse(event.data);
		console.log(event.data);
		if(msgdto.cmd == "get") {
			textarea.value += msgdto.msg.name + ", " + msgdto.msg.role;
		} else if(msgdto.cmd == "all") {
			//for( i in msgdto.msg )
			for(i=0; i<msgdto.msg.length; i++) {
				textarea.value += msgdto.msg[i].name + ", " + msgdto.msg[i].role + "\n";
			}
		}
		chatAreaScroll();
	}
	function onOpen(event) {
		textarea.value += "연결 성공\n";
	}
	function onError(event) {
		console.log(event);
		alert(event.data);
	}
	function send() {
		textarea.value += "나 : " + inputMessage.value + "\n";
		
		// 서버로 전송할 데이터를 담을 msg 객체 생성.
		var msg = {
					cmd: "get",
					msg: document.getElementById("inputMessage").value,
					id: "로그인 계정"  // 세션 로그인 ID
				  };
		
		webSocket.send(JSON.stringify(msg));
		inputMessage.value = "";
	}
	function sendAll() {
		textarea.value += "나 : " + inputMessage.value + "\n";
		
		var msg = {
					cmd: "all",
					msg: document.getElementById("inputMessage").value,
					id: "로그인 계정"  // 세션 로그인 ID
				  };
		
		webSocket.send(JSON.stringify(msg));
		inputMessage.value = "";
	}
	function chatAreaScroll() {
		//using jquery
		/* var textArea = $('#messageWindow');
		textArea.scrollTop(textArea[0].scrollHeight - textArea.height());
		textArea.scrollTop(textArea[0].scrollHeight); */
		//using javascript
		/* var textarea = document.getElementById('messageWindow'); */
		textarea.scrollTop = textarea.scrollHeight;
	}
</script>
</html>