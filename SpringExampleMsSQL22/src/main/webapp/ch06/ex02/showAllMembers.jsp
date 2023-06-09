﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<p/>
<c:if test="${not empty sessionScope.modify}">   
   ${sessionScope.modify}<br>
   <c:remove var="modify" scope="session" />       
</c:if>
<h1 class='center'>會員資料</h1>
<h3 class='center'>OpenSessionInViewFilter版</h3>
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
            <td><a href="<c:url value='/ch06/ex02/FindMemberServlet' />?id=${mem.id}">${mem.memberId}</a></td>
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
</div>
<p>
<div class='center'>
<c:if test="${not empty sessionScope.error}">   
   <c:remove var="error" scope="session" />       
</c:if>
<hr>
<small><a href="<c:url value='/ch06/index.jsp' />">回第六章首頁</a></small>
</div>
</body>
</html>