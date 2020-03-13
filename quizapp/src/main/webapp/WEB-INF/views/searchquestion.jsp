<%@include file="header.jsp"%>
<body>

	<h2 align="center">Search Question</h2>
	<hr width=600>

	<form action="searchquestion">
		<table align="center">
			<tr>
				<td>Search Question:</td>
				<td><select path="questionId">
				<option value="-1">Select Language</option>
						<c:forEach items="${languages}" var="language">
							<option value="${language}">${language}</option>
						</c:forEach><select></td>
			</tr>
			<tr>
				<td></td>
				<td><font color="red"><core:out value="${errormessage}"></core:out></font></font>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form>

</body>
</html>