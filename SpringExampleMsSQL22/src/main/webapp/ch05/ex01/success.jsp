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
<body class='center'>
<h1 >會員資料新增成功</h1>
<h2 >資料儲存在記憶體</h2>
<Font color='blue' >親愛的${ memberIdIdKey }您好，您的輸入資料已經處理完畢</font>
<p/>感謝您加入成為會員，請開始使用本系統<p/>
<div>
<br>
<small><a href="<c:url value='/ch05/index.jsp'/> ">回第五章首頁</a></small>
</div>
</body>
</html>