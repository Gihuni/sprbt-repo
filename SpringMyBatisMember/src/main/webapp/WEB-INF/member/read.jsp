<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%@ include file="./header.jsp" %>

<main>
	<h2>READ</h2>
	<form:form modelAttribute="member">
		<form:hidden path="no" />
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>PWD</td>
				<td><form:input path="pwd" readonly="true" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><form:textarea path="name" readonly="true" /></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnRemove">Remove</button>
		<button type="submit" id="btnList">List</button>
	</div>
</main>

<%@ include file="./footer.jsp" %>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		console.log(formObj);
		$("#btnModify").on("click", function() {
			var memberNo = $("#no");
			var memberNoVal = memberNo.val();
			/* http://~:8080//board/modify?boardNo=1  */
			self.location = "/member/modify?no=" + memberNoVal;
		});
		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/member/remove");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			/* http://~:8080//board/list */
			self.location = "/member/list";
		});
	});
</script>