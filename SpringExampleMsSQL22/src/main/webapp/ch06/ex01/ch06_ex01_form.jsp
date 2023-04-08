<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<div align='center' >
<H1>加入會員</H1>
<H3>(利用 Hibernate+Spring來進行資料庫存取)</H3>

<hr>
<form action="<c:url value='/ch06/ex01/register0601.do' />" method="POST">
    <Table>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT">
                <input	type="text" name="memberId" value="${param.memberId}" size="20">
                <font color='red' size='-3'>${error.memberId}</font>
             </TD>
         </TR>
         <TR>
             <TD align="RIGHT">密碼：</TD>
             <TD align="LEFT" >
                <input	type="password" name="pswd" value="${param.pswd}" size="20">
                <font color='red' size='-3'>${error.pswd}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">姓名：</TD>
             <TD align="LEFT" >
                <input	type="text" name="userName" value="${param.userName}"  size="30">
                <font color='red' size='-3'>${error.userName}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">eMail：</TD>
             <TD align="LEFT" >
                 <input type="text" name="eMail" value="${param.eMail}" size="40">
                 <font color='red' size='-3'>${error.eMail}</font>
             </TD>
         </TR>             
         <TR>
            <TD align="RIGHT">生日：</TD>
             <TD align="LEFT" > 
               <input type="text" name="birthday" value="${param.birthday}">
               <font color='red' size='-3'>${error.birthday}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">使用Java經驗：</TD>
             <TD align="LEFT" > 
                <input type="text" name="experience" value="${param.experience}" size="3"> 年
                <font color='red' size='-3'>${error.experience}</font>
              </TD>
         </TR>    
        <TR>
            <TD colspan="2" align="center">
                <input type="submit" value="提交"> 
            </TD>
         </TR>
         </Table>
</Form>
<hr>
<small><a href="<c:url value='/ch06/index.jsp' />">回第六章首頁</a></small>
</div>
</body>
</html>
