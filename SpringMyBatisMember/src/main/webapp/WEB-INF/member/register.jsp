<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%@ include file="./header.jsp" %>

<main>
	<h2>REGISTER</h2>
	<form:form modelAttribute="member" action="register">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" /></td>
				<td><font color="red"><form:errors path="id" /></font></td>
			</tr>
			<tr>
				<td>PWD</td>
				<td><form:input path="pwd" /></td>
				<td><font color="red"><form:errors path="pwd" /></font></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><form:textarea path="name" /></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnRegister">게시판 입력</button>
		<button type="submit" id="btnList">게시판 전체출력</button>
	</div>
</main>

<%@ include file="./footer.jsp" %>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/member/register");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			/* http://~:8080/board/list */
			self.location = "/member/list";
		});
	});
</script>