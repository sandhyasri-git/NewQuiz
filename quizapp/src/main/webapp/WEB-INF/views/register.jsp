<%@include file="header.jsp"%>
<body>

<div id="wrapper">

	<!-- <form name="login-form" class="login-form" action="checkRegister" method="post"> -->
	<form:form method="post" modelAttribute="student" action="checkRegister">
					
	
		<div class="header">
		<h1>Register </h1>
		<span></span>
		</div>
		<div class="content">
		<input name="studentname" type="text" class="input studentname" placeholder="Studentname" />
		<div class="user-icon"></div>
		<input name="password" type="password" class="input password" placeholder="Password" />
		<div class="pass-icon"></div>		
		</div>

		<div class="footer">		
		<input type="submit" class="button" name="submit" value="Register" class="register" />
		</div>
	
	</form:form>

</div>
<div class="gradient"></div>


</body>
</html>
