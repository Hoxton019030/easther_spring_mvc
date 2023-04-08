<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<title>MVC架構</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />
<h2 align="center">OpenSessionInViewFilter</h2>
<div align="center">
<c:url value='/ch06/ex01/ch06_ex01_form.jsp' />
<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
       <a href="<c:url value='/ch06/ex01/ch06_ex01_form.jsp' />">
          新增會員資料(Hibernate+Spring)
       </a><br>
      <font face="verdana" size="-2">
      webapp/ch06/ex01/*.jsp<br>
      ch06.ex01.*.java
      </font>
    </td>
    <td  width="350"><p align="left">
      <a href="ex02/queryAllMembers.do">查詢會員資料(Hibernate+Spring)</a><br>
      <font face="verdana" size="-2" color='red'>
               採用OpenSessionInViewFilter來解決Lazy Loading的問題
      </font><br>
      <font face="verdana" size="-2">
      webapp/ch06/ex02/*.jsp, ch06.ex02.*.java
      </font>
    </td>
  </tr>
  <!-- ================================ -->
  
</table>
</div>
<hr>
<div class='center'>
<br>
<small>&lt;&lt;<a href="<c:url value='/index.jsp' />">回首頁</a>&gt;&gt;</small>
</div>
</body>
</html>
