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
		<h1>NAME 문자열배열 출력</h1>
		<%
		String[] nameArray = (String[]) request.getAttribute("name");
		for (String data : nameArray) {
		%>
		<p><%=data%></p>
		<%
		}
		%>
		<h1>NAME 문자열배열 출력</h1>
		<c:forEach var="data" items="${name}">
			<p>
				<c:out value="${data}"></c:out>
			</p>
		</c:forEach>
		<h1>NAME 문자열배열 출력 첨자형식으로 출력한다.</h1>
		<p>${name[0]}</p>
		<p>${name[1]}</p>
		<p>${name[2]}</p>

		<h1>NAMELIST LIST 출력</h1>
		<c:forEach var="data" items="${nameList}">
			<p>
				<c:out value="${data}"></c:out>
			</p>
		</c:forEach>
		<h1>NAMELIST LIST 첨자모양으로 출력</h1>
		<p>${nameList[0]}</p>
		<p>${nameList[1]}</p>
		<p>${nameList[2]}</p>
	</main>
	<hr>
	<footer>
		<h1>footer 영역입니다.</h1>
	</footer>
</body>
</html>