<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<% String url = application.getContextPath() + "/"; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
            
	* {font-family: 'Gowun Dodum', sans-serif;}
	</style>
</head>

<body>
<br><br><br>

	<center>
		<h3>${requestScope.errorMsg}</h3>
			
		<br><br><br>
		<a href="${pageContext.request.contextPath}/index.html">메인 화면으로 이동하기</a>
	</center>
	
</body>
</html>