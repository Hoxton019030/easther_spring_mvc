<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<title>MVC架構</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center"></h2>
<div align="center">

<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href=" <c:url value='/lab02/ex01/queryAllClassEntities.do' />">由班級查詢學生資料 FetchType.EAGER</a><BR><font face="verdana" size="-2">webapp/ch04/ex01/ch04_05.jsp<BR>
      webapp/lab02/ex01/*.jsp<BR>lab02.controller.*.java<BR>lab02.*.java</font>
    </td>
  </tr>   
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
