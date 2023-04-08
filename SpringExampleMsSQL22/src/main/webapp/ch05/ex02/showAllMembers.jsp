<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Members</title>
</head>
<body>
<c:if test="${not empty sessionScope.modify}">   
   ${sessionScope.modify}<br>
   <c:remove var="modify" scope="session" />       
</c:if>
<h1 class='center'>會員資料</h1>
<h2 class='center'>使用In-Memory List類別</h2>
<hr>
<p> 
<div align="center">
   <c:forEach var="mem"  varStatus="statusX" items="${AllMembers}">
      <c:if test="${statusX.first}" >
         <c:out value="<table border='1' cellspacing='5' cellpadding='5' >" escapeXml="false"/>
    	 <tr bgcolor="CCCC00">
            <td  colspan='6' ALIGN='CENTER'>會員基本資料</td>
         </tr>
         <tr  bgcolor="CCCC00">
            <th>帳 號</th><th>密碼</th><th>姓 名</th><th>eMail</th><th>生日</th><th>Java經驗</th>
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
                    
        <tr bgcolor="${colorVar}">
            <td><a href="<c:url value='/ch05/ex02/FindMemberServlet' />?id=${mem.id}">${mem.memberId}</a></td>
            <td>${mem.password} </td>
            <td>${mem.name} </td>
            <td>${mem.email}</td>
            <td>${mem.birthday} </td>
            <td style="text-align:right">${mem.experience}&nbsp;</td>
        </tr>
        <c:if test="${statusX.last}" >
             <c:out value="</table>" escapeXml="false" />
        </c:if>		                      
	</c:forEach>
<p>
<%-- <c:if test="${not empty sessionScope.error}">    --%>
<%--    <c:remove var="error" scope="session" />        --%>
<%-- </c:if> --%>
</div>
<div class='center'>
<hr>
<small><a href="<c:url value='/ch05/index.jsp' />">回第五章首頁</a></small>
</div>
</body>
</html>