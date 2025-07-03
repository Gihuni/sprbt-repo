<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Home 페이지입니다.</h3>
	<P>서버의 시간은 ${serverTime} 입니다.</P>
	${userInfo.userId}
	<br> ${userInfo.userName}
	<br>
</body>
</html>