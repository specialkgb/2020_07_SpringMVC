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
	
</style>
<section id="bbs-detail-header">
	<article><img src="${rootPath}/upload/${BBSVO.b_file}" width="200px"></article>
	<article>
		<div class="title">제목</div><div class="content">${BBSVO.b_subject}</div>
		<div class="title">작성일시</div><div class="content">${BBSVO.b_date},${BBSVO.b_time}</div>
		<div class="title">작성자</div><div class="content">${BBSVO.b_writer}</div>
	</article>
</section>
<section id="bbs-detail-body">
{BBSVO.b_content}
</section>