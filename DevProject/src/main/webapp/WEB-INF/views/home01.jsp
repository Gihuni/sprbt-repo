<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>Header 영역입니다. home01.jsp 입니다.</h1>
	</header>
	<hr>
	<main>
		<h2>현재 한국시간은 ${serverTime}</h2>
		<p>boardNo ${board.boardNo}</p>
		<p>title ${board.title}</p>
		<p>content ${board.content}</p>
		<p>writer ${board.writer}</p>
		<p>date ${board.regDate}</p>	
	</main>
	<hr>
	<footer>
		<h1>footer 영역입니다.</h1>
	</footer>
</body>
</html>