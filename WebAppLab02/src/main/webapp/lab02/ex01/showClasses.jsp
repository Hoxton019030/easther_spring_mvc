<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
<div align='CENTER'>
<h2>依照班級查詢學生</h2>
<h3>FetchType.EAGER</h3>
<HR>
    <table border='1'>
        <tr>
			<th>班級代號</th><th>班級名稱</th>
		</tr>        
		<c:forEach var="classEntity" items="${classEntities}">
           <tr>
			  <td align='center'>${classEntity.classId}</td>
			  <td><a href="<c:url value='/lab02/ex01/queryClassEntityById.do?catId=${classEntity.classId}'  />">${classEntity.classCode}</a></td>
		   </tr>
		
		</c:forEach>
        
         </Table>

<p>
<a href="<c:url value='/lab02' />">回前頁</a>
</div>
</body>

</html>
