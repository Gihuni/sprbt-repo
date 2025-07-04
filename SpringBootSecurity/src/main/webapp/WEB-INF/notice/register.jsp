<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="./header.jsp"%>

<main>
	<h3>공지사항 등록 : 로그인한 관리자만 접근 가능</h3>
	<form action="/logout" method="post">
		<sec:csrfInput />
		<button>로그아웃</button>
	</form>
</main>

<%@ include file="./footer.jsp"%>