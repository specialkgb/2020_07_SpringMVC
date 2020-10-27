<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
section#ems-detail-header {
	width: 50%;
	border: 1px solid blue;
	margin: 20px auto;
	display: flex;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5)
}

section#ems-detail-header article:first-child {
	flex: 1;
}

section#ems-detail-header article:last-child {
	flex: 2;
}

section#ems-detail-header div {
	margin: 5px;
	padding: 10px;
	border-bottom: 1px solid #ddd
}

section#ems-detail-header .title {
	display: inline-block;
	width: 25%;
	background-color: #ddd;
	font-weight: bold;
	text-align: right;
}

section#ems-detail-header .content {
	display: inline-block;
	width: 60%;
}

section#ems-detail-header img {
	margin: 5px;
	border-radius: 5px;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5)
}

section#ems-detail-body {
	width: 50%;
	margin: 0 auto;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);
	background-color: #ccc;
	padding: 20px;
}

section#ems-button-box {
	width: 50%;
	margin: 10px auto;
	text-align: right;
}

section#ems-button-box button {
	margin: 10px;
	padding: 10px 16px;
	border: 0;
	outline: 0;
	border-radius: 5px;
	font-weight: bold;
}

section#ems-button-box button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.6);
}
/* button.ems-list */
section#ems-button-box button:nth-child(1) {
	background-color: green;
}

section#ems-button-box button:nth-child(2) {
	background-color: blue;
	color: white;
}

section#ems-button-box button:nth-child(3) {
	background-color: orange;
}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("section#ems-button-box").addEventListener(
				"click",
				function(e) {

					let url = "${rootPath}/ems/${EmsVO.id}/"
					if (e.target.tagName === ("BUTTON")) {

						/*
						게시글 삭제를 요청하면(삭제버튼 클릭)
						ajax 사용하여 서버에 DELETE method type으로 삭제를 요청하자
						 */
						if (e.target.className == "delete") {
							if (confirm("정말 삭제할까요?")) {
								document.location.href = url
										+ e.target.className
							}
							return false;
						}
						document.location.href= url+ e.target.className
					}
				})
	})
</script>

<section id="ems-detail-header">
	<article>
		<div class="title">제목</div>
		<div class="content">${EmsVO.s_subject}</div>
		<div class="title">작성일시</div>
		<div class="content">${EmsVO.s_date},${EmsVO.s_time}</div>
		<div class="title">발신자</div>
		<div class="content">${EmsVO.from_email}</div>
		<div class="title">수신자</div>
		<div class="content">${EmsVO.to_email}</div>
	</article>
</section>
<section id="ems-detail-body">${EmsVO.s_content}</section>
<section id="ems-button-box">
	<button class="list">리스트</button>
	<button class="update">수정</button>
	<button class="delete">삭제</button>
</section>
<style>
section#images-box {
	width: 50%;
	margin: 10px auto;
	padding: 5px;
}

section#images-box img {
	margin: 3px;
	border-radius: 20px;
}
</style>
<section id="images-box">
	<c:if test="${not empty emsVO.images}">
		<c:forEach items="${emsVO.images}" var="image">
			<img src="${rootPath}/upload/ems/${image.i_file_name}" height="100px">
		</c:forEach>
	</c:if>
</section>






