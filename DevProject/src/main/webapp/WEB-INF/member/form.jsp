<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 화면영역 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>Header 영역입니다. Form.jsp 입니다.</h1>
	</header>
	<hr>
	<main>
		<form action="/member/submit" method = "post">
			이름: <input type="text" name="name">
			<button type="submit">전송</button>
		</form>
		
	</main>
	<hr>
	<footer>
		<h1>footer 영역입니다.</h1>
	</footer>
</body>
</html>