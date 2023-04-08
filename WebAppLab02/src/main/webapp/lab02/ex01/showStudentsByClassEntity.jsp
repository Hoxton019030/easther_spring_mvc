<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"
	type="text/css" />
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<div align='CENTER'>
		<h2>依照班級查詢學生</h2>
		<h3>Category類別的 fetch = FetchType.EAGER</h3>
		<HR>
		<table border='1'>
			<tr>
				<th align='center' colspan='5'>${classEntity.classCode}：${classEntity.className}</th>
			</tr>
			<c:forEach var="student" items="${classEntity.students}"  varStatus="statusX" >
				<c:if test="${statusX.first}">
					<c:out value="<table border='1' cellspacing='5' cellpadding='5' >"
						escapeXml="false" />
					<tr bgcolor="CCCC00">
						<td colspan='5' ALIGN='CENTER'>學生基本資料</td>
					</tr>
					<tr bgcolor="CCCC00">
						<th>編號</th>
						<th>學生姓名</th>
						<th>分數</th>
					</tr>
				</c:if>
				<c:choose>
					<c:when test="${ statusX.count % 2 == 0 }">
						<c:set var="colorVar" value="99ddff" />
					</c:when>
					<c:otherwise>
						<c:set var="colorVar" value="88dd00" />
					</c:otherwise>
				</c:choose>

				<tr bgcolor='${colorVar}'>
					<td align='center'>${student.id}</td>
					<td>${student.name}</td>
					<td align='right'>${student.score}&nbsp;</td>
				</tr>

			</c:forEach>

		</Table>

		<p>
			<a href="<c:url value='/lab02/ex01/queryAllClassEntities.do' />">重查一次</a>
			<a href="<c:url value='/lab02' />">回本章首頁</a>
	</div>
</body>

</html>
