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
		<h1>Header 영역입니다. home03.jsp 입니다.</h1>
	</header>
	<hr>
	<main>
		<h1>MemberMap(HashMap) 저장된 값 출력</h1>
		<p> id = ${mMap["id"]}</p>
		<p> pwd = ${mMap["pwd"]}</p>
		<p> email = ${mMap["email"]}</p>
		<p> name = ${mMap["name"]}</p>
		<p> date = ${mMap["date"]}</p>
	</main>
	<hr>
	<footer>
		<h1>footer 영역입니다.</h1>
	</footer>
</body>
</html>