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
		<h1>Header 영역입니다. home0202.jsp 입니다.</h1>
	</header>
	<hr>
	<main>
		<c:set var="myTitle">${board.title}</c:set>
		<table border="1">
			<tr>
				<td>\${board title}</td>
				<td>${myTitle}</td>
			</tr>
		<c:set target="${board}" property="title" value="react"/>
		<table border="1">
			<tr>
				<td>\${board title}</td>
				<td>${board.title}</td>
			</tr>
		</table>
	</main>
	<hr>
	<footer>
		<h1>footer 영역입니다.</h1>
	</footer>
</body>
</html>