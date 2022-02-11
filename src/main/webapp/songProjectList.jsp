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
<style>
  body { color:black; }
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
            
	* {font-family: 'Gowun Dodum', sans-serif;}
  
  body { height:100%;
}



            
        </style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 Song Project list 화면</title>

</head>
<body>
<br><br><br>
<center>
<h3>노래 프로젝트 list</h3>
<hr><p>

<table border="1">
	<tr>   
		<th>프로젝트 id</th><th>프로젝트명</th><th>노래 id</th><th>가수 id</th>
		<th>팬클럽 id</th><th>수상 내용</th>
	</tr>
	

	<c:forEach items="${requestScope.songProjectAll}" var="dataAll"> 
 		<tr>
 			<td>${dataAll.song_project_id}</td>
 			<td>${dataAll.song_project_name}</td>
 			<td>${dataAll.song_id}</td>
 			<td><a href='${pageContext.request.contextPath}/song?command=singer&singer_id=${dataAll.singer_id}'>${dataAll.singer_id}</a></td>
 			<td><a href='${pageContext.request.contextPath}/song?command=fanclub&fanclub_id=${dataAll.fanclub_id}'>${dataAll.fanclub_id}</a></td>
 			<td>${dataAll.song_project_content}</td>
 		</tr>
 	</c:forEach> 
</table>

<br><br><br>
<font color="blue">가수 id 및 팬클럽 id를 클릭하면 상세 정보 확인이 가능합니다.</font>

</center>
</body>
</html>