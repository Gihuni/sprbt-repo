<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./header.jsp"%>
<main>
	<h2>현재 한국시간은 ${serverTime}</h2>
	<p>BoardNo ${board.boardNo}</p>
	<p>Title ${board.title}</p>
	<p>Content ${board.content}</p>
	<p>WRiter ${board.writer}</p>
	<p>Date ${board.regDate}</p>
</main>
<%@ include file="./footer.jsp"%>