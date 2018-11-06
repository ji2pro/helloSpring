<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/getBoard.jsp</title>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script>
$(function() {
	var context = '${pageContext.request.contextPath}';
	
	//목록조회 요청
	function loadCommentList() {
		var params = { boardSeq : '${board.seq}' };
		$.getJSON(context + "/getCommentsList",params, function(datas){
			for(i=0; i<datas.length;i++) {
				$("#commentList").append( makeCommentView(datas[i]) );
			}
		});
	}
	
	function makeCommentView(comment){
		var div = $("<div>");  //태그 생성, document.createElement()
		div.attr("id", "c"+comment.seq);  //<div id="c1"></div>
		div.addClass('comment');  //<div id="c1" class="comment"></div>
		div[0].comment=comment;   //{seq:1, title:'', content:'',.... }
		
		var str ="<strong class='commentName'>" + comment.name + "</strong>" 
		        +"<span class='commentContent'>" + comment.content +"</span>"
				+"<button type=\"button\" class=\"btnUpdFrm\">수정</button>"
				+"<button type=\"button\" class=\"btnDel\">삭제</button>"
		div.html(str);
		return div;
	}
	//목록 조회
	loadCommentList();
	
	//댓글 등록 이벤트
	$("#btnAdd").click(function(){
		$("#btnCancel").click();
		var params = $("[name=addForm]").serialize();
		var url = context + "/insertComments";
		$.getJSON(url, params, function(datas){
			$("#commentList").append( makeCommentView(datas) );
			$("[name=addForm]")[0].reset();
		});
	});
	
	//수정폼 이벤트(수정할 댓글밑에 수정폼 보이게 함)
	$("#commentList").on("click", ".btnUpdFrm", function(){
		var seq = $(this).parent().attr("id").substring(1);
		var comment = $(this).parent().get(0).comment;
		//수정할 데이터 입력필드에 셋팅
		$("#updateForm [name=seq]").val(seq);
		$("#updateForm [name=name]").val(comment.name);  //$("#c"+seq+">.commentName").text());
		$("#updateForm [name=content]").val(comment.content);  //$("#c"+seq+">.commentContent").text());
		//수정할 댓글 밑으로 이동하고 보이게
		$("#c"+seq).append($('#commentUpdate'));  
		$('#commentUpdate').show();
	});
	
	//수정 취소 이벤트
	$("#btnCancel").click(function(){
		$("[name=updateForm]")[0].reset();    //폼 필드 클리어
		$("#comments").append( $("#commentUpdate") );    //수정 폼(div)를 이동
		$("#commentUpdate").hide();    // 수정폼 숨기기
	});
	
	//댓글 수정 이벤트
	$("#btnUpd").click(function(){
		var params = $("[name=updateForm]").serialize();
		var url = context + "/updateComments";
		$.getJSON(url, params, function(datas){
			var newDiv = makeCommentView(datas);
			var oldDiv = $("#c"+datas.seq);
			$("#btnCancel").click();
			$(newDiv).replaceAll(oldDiv);  // 수정된 DIV를 교체
		});
	});
	
	//댓글 삭제 이벤트
	$("#commentList").on("click", ".btnDel", function(){
		var seq = $(this).parent().attr("id").substr(1);  //클릭한 삭제 버튼의 부모(div) 태그의 ID를 읽는다.
		if(confirm("삭제할까요?")) {
			var params = "seq="+ seq;  // { seq : seq };
			var url = context + "/deleteComments";
			$.getJSON(url, params, function(datas){
				$('#c'+datas.seq).remove();
			});
		}
	});
})
</script>
</head>
<body>
	<h2>게시글 단건 조회</h2>
	
	<table border="1" width="700px">
		<tr>
			<th>번호</th><td>${board.seq}</td>
			<th>등록일</th><td>${board.regdate}</td>
		</tr>
		<tr>
			<th>제목</th><td>${board.title}</td>
			<th>작성자</th><td>${board.writer}</td>
		</tr>
		<tr>
			<th>내용</th><td colspan="3">${board.content}</td>
		</tr>
	</table>
	<br>
	<a href="./getBoards">목록으로</a>
	<br>
	<hr>
	<h3>댓글 목록</h3>
	<div id="comments">
		<div id="commentList"></div>
	
		<!-- 댓글 등록 시작 -->
		<div id="commentAdd">
			<form name="addForm" id="addForm">
				<input type="hidden" name="boardSeq" value="${board.seq}">
				이름: <input type="text" name="name" size="10"><br/>
				내용: <textarea name="content" cols="20" rows="2"></textarea><br/>
				<input type="button" value="등록" id="btnAdd"/>
			</form>
		</div>
		<!-- 댓글 등록 끝 -->
		
		<!-- 댓글 수정폼 시작 -->
		<div id="commentUpdate" style="display:none">
			<form action="" name="updateForm" id="updateForm">
				<input type="hidden" name="boardSeq" value="${board.seq}">
				<input type="hidden" name="seq" value=""/>
				이름: <input type="text" name="name" size="10"><br/>
				내용: <textarea name="content" cols="20" rows="2"></textarea><br/>
				<input type="button" value="등록" id="btnUpd"/>
				<input type="button" value="취소" id="btnCancel"/>
			</form>
		</div>
		<!-- 댓글 수정폼 끝 -->
	</div>

</body>
</html>