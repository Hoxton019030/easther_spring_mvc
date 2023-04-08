<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE HTML>
<html>
<head>
<style>  

</style>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
<script type="text/javascript">
  function confirmDelete(memberId){
	  var result = confirm("確定刪除此筆記錄(帳號:" + memberId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "DELETE";
	      return true;
	  }
	  return false;
  }
  function confirmUpdate(memberId){
	  var result = confirm("確定送出此筆記錄(帳號:" + memberId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "UPDATE";
	      return true;
	  }
	  return false;
  }
</script>
</head>
<body>
<div class='center'>
<H1 >更新會員資料</H1>
<H3 class='center'>OpenSessionInViewFilter版</H3>
</div>
<hr>
<p> 

<form class='center' action="<c:url value='/ch06/ex02/updateMember.do'  />" method="POST" >
    
    <input type="hidden" name="id" value="${param.id}" >
    <input type="hidden" name="memberId" value="${member.memberId}${param.memberId}" >
    <input type="hidden" name="registerDate" value="${member.registerDate}${param.registerDate}" >
    <!-- 
    <input type="hidden" name="pswd"   value="${member.password}${param.password}" >
     -->
    <input type="hidden" name="finalDecision" value="" > 
    <table>
         <tr>
             <td align="RIGHT">帳號：</td>
             <td align="LEFT">${member.memberId}${param.memberId}</td>
         </tr>
         <tr>
             <td align="RIGHT">密碼：</td>
             <td align="LEFT" > 
               <input type="text" name="password" value="${member.password}${param.password}">
               <font color='red' size='-3'>${error.password}</font>
             </td>
         </tr>  
         <tr>
             <td align="RIGHT">姓名：</td>
             <td align="LEFT" >
                <input type="text" name="userName" value="${member.name}${param.userName}"  size="30">
                <font color='red' size='-3'>${error.userName}</font>
             </td>
         </tr>             
         <tr>
             <td align="RIGHT">EMail：</td>
             <td align="LEFT" >
                <input type="text" name="eMail" value="${member.email}${param.eMail}" size="40">
                <font color='red' size='-3'>${error.eMail}</font>
             </td>
         </tr>             
         <tr>
             <td align="RIGHT">生日：</td>
             <td align="LEFT" >
                <input type="text" name="birthday" value="${member.birthday}${param.birthday}" size="40">
                <font color='red' size='-3'>${error.birthday}</font>
             </td>
         </tr>              
         <tr>
             <td align="RIGHT">使用Java經驗：</td>
             <td align="LEFT" > 
               <input type="text" style="text-align:right" name="experience" value="${member.experience}${param.experience}" size="3"> 年
               <font color='red' size='-3'>${error.experience}</font>
             </td>
         </tr>    
        <tr>
            <td colspan="2" align="center">     
            <input type="submit" value="更新" name='updateBtn' onclick="return confirmUpdate('${member.memberId}');"> 
            <input type="submit" value="刪除" name='deleteBtn' onclick="return confirmDelete('${member.memberId}');" >
            </td>
            </tr>
         </table>
         <c:if test="${not empty requestScope.modify}">   
           <c:remove var="member" scope="request" />       
         </c:if>
</form>
</body>
<div class='center'>
<br>
<small><a href="<c:url value='/ch06/ex02/queryAllMembers.do' />">回上一頁</a></small>
</div>
</html>
