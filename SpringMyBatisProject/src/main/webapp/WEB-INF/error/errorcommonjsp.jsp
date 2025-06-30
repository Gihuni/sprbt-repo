<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<div>
		<h2>고객님 서버에 문제가 발생하였습니다. 빠르게 조치하도록 하겠습니다.</h2>
		<h2>${message}</h2>
		<a href="/board/list">List</a>
	</div>
</main>

<%@ include file="./footer.jsp"%>