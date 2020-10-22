<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<style>
	section#bbs-detail-body {
		border: 1px solid blue;
		margin: 20px auto;
		display: flex;
		flex-direction: column;
	}
	
	section#bbd-detail-body article:first-child {
		flex:1;
	}
	
	section#bbd-detail-body article:last-child {
		flex:2;
	}
	
	section#bbd-detail-body .title {
		display: inline-block;
		width: 30%;
		margin: 10px;
		background-color: #ccc;
		font-weight: bold;
	}
	
	section#bbd-detail-body .content {
		display: inline-block;
		width: 65%;
		margin: 10px;
	}
	
	section#bbs-button-box {
		width: 50%;
		margin: 1px auto;
		text-align: right;
	}
	
	section#bbs-button-box button {
		margin: 10px;
		padding: 10px 16px;
		border: 0;
		outline: 0;
		border-radius: 5px;
		font-weight: bold;
	}
	
	section#bbs-button-box button:hover {
		box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.6);
		
	}
	
	/* button.bbs-list */
	section#bbs-button-box button:nth-child(1) {
		background-color: green;
	}
	
	section#bbs-button-box button:nth-child(2) {
		background-color: blue;
		color: white;
	}
	
	section#bbs-button-box button:nth-child(3) {
		background-color: orange;
	}
	
	
</style>
<script>
document.addEventListener("DOMContentLoaded", function() {
	document.querySelector("section#bbs-button-box").addEventListener("click", function(e){
		let url = "${rootPath}/bbs/${BBSVO.b_seq}/"
		if(e.target.tagName === ("BUTTON")) {
			if(e.target.className == "delete") {
				if(confirm("정말 삭제할까요?")) {
					
					let data = {
							seq:"${BBSVO.b_seq}",
							subject: "${BBSVO.b_subject}"
							}
							fetch("${rootPath}/api/bbs",
							
							{
						
								method: "PUT",
								headers: {
									"Content-Type" : "application/json"
								
								},
								body : JSON.stringify(data) // JSON 객체데이터를 문자열화 하여 HTTP Body에 담기
							}
					
					)
					.then(function(result){
						alert(result)
					})
					.catch(function(error){
						alert("실패")
					})
					
					return false;
				}
			}
			document.location.href= url+ e.target.className
		}
	})
})
</script>

<section id="bbs-detail-header">
	<article>
		<a href="${rootPath}/upload/${BBSVO.b_file}" target=_new>
			<img src="${rootPath}/upload/${BBSVO.b_file}" width="200px">
		</a>
	</article>
	
	<article>
		<div class="title">제목</div><div class="content">${BBSVO.b_subject}</div>
		<div class="title">작성일시</div><div class="content">${BBSVO.b_date},${BBSVO.b_time}</div>
		<div class="title">작성자</div><div class="content">${BBSVO.b_writer}</div>
	</article>
</section>
<section id="bbs-detail-body">
${BBSVO.b_content}
</section>
<section id="bbs-button-box">
	<button class="list">리스트</button>
	<button class="update">수정</button>
	<button class="delete">삭제</button>
</section>