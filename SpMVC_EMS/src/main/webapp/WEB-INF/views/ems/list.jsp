<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("#ems-write").addEventListener("click",
				function() {
					document.location.href = "${rootPath}/ems/write";
				})

				
		document.querySelector("table").addEventListener("click", function(event) {
					let tag_name = event.target.tagName;
					
					if(tag_name === "TD") {

						let id = event.target.closest("TR").dataset.seq
						if(id) {
							alert(id)
							document.location.href = "${rootPath}/ems/detail/" + id
					}			
				}
			});
	})

</script>
<style>
	td.ems-tr {
		cursor: pointer;
	}
	
	td.ems-tr:hover {
		background-color: #ccc;
	}
</style>
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>NO</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>발신자</th>
			<th>수신자</th>
			<th>제목</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty EMS_LIST }">
			<tr>
				<td colspan="6">데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${EMS_LIST}" var="vo" varStatus="i">
			<tr class="ems-tr" data-seq="${vo.id}" class="ems-subject">
				<td>${i.count }</td>
				<td>${vo.s_date }</td>
				<td>${vo.s_time }</td>
				<td>${vo.from_email }</td>
				<td>${vo.to_email }</td>
				<td data-id="${vo.id}">
					${vo.s_subject }
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<button id="ems-write">메일보내기</button>