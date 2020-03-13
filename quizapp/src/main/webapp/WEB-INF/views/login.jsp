<%@include file="header.jsp"%>
<body>

<br><br><br>
<div style="position:absolute;left:500px;top:75px">
<br>
<br>
<br><br><br><br><br><br><br>
Don`t have an account, click here to <a href='register'>Register</a>
<br/>
<h3 align="center">${errorMessage}</h3>
</div>
<div id="wrapper">

	<form name="login-form" class="login-form" action="perform_login" method="post">
	
		<div class="header">
		<h1>Login </h1>
		<span></span>
		</div>
	
		<div class="content">
		<input name="username" type="text" class="input username" placeholder="Username" />
		<div class="user-icon"></div>
		<input name="password" type="password" class="input password" placeholder="Password" />
		<div class="pass-icon"></div>		
		</div>

		<div class="footer">
		<input type="submit" name="submit" value="Login" class="button" />
		
		</div>
	
	</form>

</div>
<div class="gradient"></div>


</body>
</html>
