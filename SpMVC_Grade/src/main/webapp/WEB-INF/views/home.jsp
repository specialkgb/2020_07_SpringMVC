<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
<style>
	table#grade-list {
		width:100%;
		margin:10px auto;
		text-align: center;
		border-radius:1px solid #ccc;
	}
	
	td,td {
		border:1px solid #ccc;
	}
</style>
</head>
<body>
<h3>GradeList</h3>
<table id="grade-list">
	<tr>
				<th>학번</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>비고</th>
	</tr>
	<c:if test="${empty GRADE_LIST}">
		<tr><td colspan="7">데이터가 없습니다</td></tr>
	</c:if>
	<c:forEach items="${GRADE_LIST}" var="grade">
		<tr>
			<td>${grade.g_no}</td>
			<td>${grade.g_name}</td>
			<td>${grade.g_kor}</td>
			<td>${grade.g_eng}</td>
			<td>${grade.g_math}</td>
			<td>${grade.g_total}</td>
			<td>${grade.g_avg}</td>
			<td>
			<a href="${rootPath}/update?seq=${grade.seq}">수정</a>
			<a href="${rootPath}/delete?seq=${grade.seq}">삭제</a>
			</td>
		</tr>
	</c:forEach>
</table>
<div>
	<a href="${rootPath}/write">성적추가</a>
</div>

</body>
</html>