<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<center>

<h3>팬클럽 정보 수정하기 - 규모 수정</h3>
<hr><p>

<form action="song?command=fanclubUpdate" method="post">
<table border="1">
	<thead>
		<tr>
			<th>팬클럽 id</th><th>팬클럽 이름</th><th>팬클럽 나이대</th><th>사용 어플</th><th>팬클럽 규모</th>
		</tr>
 	<tr>
 		<td><input type="text" name="fanclub_id"  value="${fanclub.fanclub_id}" readonly></td>
 		<td>${fanclub.name}</td>
 		<td>${fanclub.fanclub_old}</td>
 		<td>${fanclub.application}</td>
 		<td><input type="text" name="fanclub_size" value="${fanclub.fanclub_size}"></td>
 	</tr>
 	
 	<tr>
 		<td colspan="4">
 			<input type="submit" value="수정">
 			&nbsp;&nbsp;&nbsp;
 			<input type="reset" value="취소">
 		</td>
 	</tr>
</table>
</form>

</center>
</body>
</html>