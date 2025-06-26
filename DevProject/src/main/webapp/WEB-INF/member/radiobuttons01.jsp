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
		<h1>Header 영역입니다. registerForm.jsp 입니다.</h1>
	</header>
	<hr>
	<main>
		<form:form modelAttribute="member" method="post" action="register">
			<table>
				<tr>
					<td>성별</td>
					<td><form:radiobuttons path="gender" items="${genderCodeMap}" />
					</td>
				</tr>
			</table>
			<form:button name="register">등록</form:button>
		</form:form>
	</main>
	<hr>
	<footer>
		<h1>footer 영역입니다.</h1>
	</footer>
</body>
</html>