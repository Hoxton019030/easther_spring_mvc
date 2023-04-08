<%@ page contentType="text/html; charset=UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>  	 
<head>   
<link rel='stylesheet' href='css/styles.css'  type="text/css" />
<title>JSP 範例</title>   
</head> 
<body BGCOLOR="white">
 	
<div align="center">
<h2> Lab 02</h2>
<p>
  <a href="<c:url value='/lab02/' />" >Lazy Initialization 練習</a>
<P/>
  <a href="<c:url value='/lab02/initData.do' />" >建立表格資料</a>
  <hr>
  <font color='red' >${FAIL}</font>
  <font color='green' >${SUCCESS}</font>
</div>

</body>
</html>