<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
	System.out.println(url);
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>팬클럽 상세 정보 화면</title>
</head>
<style>
body{
                background-image:url('https://images.unsplash.com/photo-1581985283743-abc20b6d8993?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80');
                background-repeat:repeat-x;
            }
            h1{
                color:white;
            }
            
	body {
text-shadow: -0.5px 0 #F2F1F6, 0 0.5px #F2F1F6, 0.5px 0 #F2F1F6, 0 -0.5px #F2F1F6;
-moz-text-shadow: -0.5px 0 #F2F1F6, 0 0.5px #F2F1F6, 0.5px 0 #F2F1F6, 0 -0.5px #F2F1F6;
-webkit-text-shadow: -0.5px 0 #F2F1F6, 0 0.5px #F2F1F6, 0.5px 0 #F2F1F6, 0 -0.5px #F2F1F6;
}
            
	* {font-family: 'Gowun Dodum', sans-serif;}</style>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>팬클럽</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>팬클럽 id</th><th>팬클럽 이름</th><th>팬클럽 나이대</th><th>사용 어플</th><th>팬클럽 규모</th>
	</tr>
 	<tr>
 		<td>${fanclub.fanclub_id}</td>
 		<td>${fanclub.name}</td>
 		<td>${fanclub.fanclub_old}</td>
 		<td>${fanclub.application}</td>
 		<td>${fanclub.fanclub_size}</td>
 	</tr>
</table>

<br><br><br>
<a href="song?command=fanclubUpdateReq&fanclub_id=${fanclub.fanclub_id}">수정하기</a>

<a href="song?command=fanclubDelete&fanclub_id=${fanclub.fanclub_id}">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>

</center>
</body>
</html>







