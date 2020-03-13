<%@include file="header.jsp"%>
<body>

<h2 align="center"><c:out value="${pageHeading}"></c:out></h2>


<form:form modelAttribute="questions" method="post" action="addquestion">
	<table align="center">
		 <tr>
			<td><form:label path="languageName">Enter Language :</form:label> <font
				color="red"> <form:errors path="languageName"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="languageName" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="question">Enter Question :</form:label> <font
				color="red"> <form:errors path="question"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:textarea path="question" cols="23"></form:textarea></td>
		</tr>
		<tr>
			<td><form:label path="option1">Enter Answer1 :</form:label> <font
				color="red"> <form:errors path="option1"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option1" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="option2">Enter Answer2 :</form:label> <font
				color="red"> <form:errors path="option2"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option2" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="option3">Enter Answer3 :</form:label> <font
				color="red"> <form:errors path="option3"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option3" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="option4">Enter Answer4 :</form:label> <font
				color="red"> <form:errors path="option4"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option4" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="rightOption">Right Answer :</form:label> <font
				color="red"> <form:errors path="rightOption"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:label path="rightOption">Answer1</form:label> <form:radiobutton
				path="rightOption" value="1" /> <form:label path="rightOption">Answer2</form:label>
			<form:radiobutton path="rightOption" value="2" /></td>
		</tr>
		<tr>
			<td><form:label path="rightOption">Answer3</form:label> <form:radiobutton
				path="rightOption" value="3" /> <form:label path="rightOption">Answer4</form:label>
			<form:radiobutton path="rightOption" value="4" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>