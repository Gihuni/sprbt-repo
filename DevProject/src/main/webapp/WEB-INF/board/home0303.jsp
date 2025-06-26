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
		<h1>Header 영역입니다. home0303.jsp 입니다.</h1>
	</header>
	<hr>
	<main>
		<table border="1">
			<tr>
				<td>\${boardNo}</td>
				<td>${boardNo}</td>
			</tr>
		</table>
	</main>
	<hr>
	<footer>
		<h1>footer 영역입니다.</h1>
	</footer>
</body>
</html>