<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${message}</title>
</head>
<body>
<div class='center'>
<h1>${message}</h1>
<h2>${now}</h2>
<br>
<small><a href="<c:url value='/ch05/index.jsp'/> ">回第五章首頁</a></small>
</div>
</body>
</html>