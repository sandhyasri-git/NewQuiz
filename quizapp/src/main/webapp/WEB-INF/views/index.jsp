<%@include file="header.jsp"%>

<c:if test='${not empty sessionScope.name}'>

	<div style="position: absolute; top: 70px; left: 1100px">
		Logged as <a href="#" class="button username">${sessionScope.name}</a>
	</div>

	<div style="position: absolute; top: 70px; left: 1300px">
		<a href='${pageContext.request.contextPath}/logout'>Logout</a>
	</div>

</c:if>

<div style="position: absolute; left: 120px; top: 60px">
	<br> <br> <br> <br> <br> <br>
	<table cellpadding="0" cellspacing="50">

		<tr>
			<td><a href="#"><img height="200" width="200"
					src="/quizapp/resources/images/java.png" /></a></td>
			<td><a href="#"><img height="200" width="200"
					src="/quizapp/resources/images/javascript.png" /></a></td>
			<td><a href=""#><img height="200" width="200"
					src="/quizapp/resources/images/sql-logo.png" /></a></td>
			<td><a href="#"><img height="200" width="200"
					src="/quizapp/resources/images/python.jpg" /></a></td>
		</tr>

		<tr>
			<td><a href="#"><img height="200" width="200"
					src="/quizapp/resources/images/css.jpg" /></a></td>
			<td><a href="#"><img height="200" width="200"
					src="/quizapp/resources/images/php-logo.jpg" /></a></td>
			<td><a href="takeExam?test=linux"><img height="200"
					width="200" src="/quizapp/resources/images/logo-linux.png" /></a></td>
			<td><a href="takeExam?test=mongodb"><img height="200"
					width="200" src="/quizapp/resources/images/mongodb_logo.png" /></a></td>
		</tr>

	</table>
</div>


</body>
</html>
