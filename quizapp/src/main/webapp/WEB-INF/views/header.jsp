<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gaming Quiz</title>
<link rel="stylesheet" type="text/css"
	href="/samplequizapp/resources/css/style.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body class="body">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-4 col-md-3 col-lg-3">
				<a href="index"> <img src="/quizapp/resources/images/home.jpg"
					alt="Quiz" style="float: left; width: 100px; height: 90px;" />
				</a>
			</div>
			<div class="col-xs-4 col-md-6 col-lg-6">
				<div class="middle">
					<h1 class="name">
						<b style="color: #034f84">Gaming Quiz</b>
					</h1>

				</div>
			</div>

		</div>
	</div>
	<nav class="navbar navbar-inverse" style="background-color: black">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index" style="color: white;">Home</a></li>

					<li><a href="AboutUs" style="color: white;">About Us</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">

					<!-- If user is not Logged in, he has to see this -->
					<c:choose>
						<c:when test="${empty LoggedInUser}">
							<li><a href="register" style="color: white;"><span
									class="glyphicon glyphicon-user"></span> Sign Up</a></li>
							<li><a href="login" style="color: white;"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:when>

					</c:choose>

				</ul>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${not empty LoggedInUser}">

						<li class="navbar-text"
							style="font-size: 15px; font-color: white;">Welcome
							${LoggedInUser}!</li>
						<li><div class="media" style="float: right;">

								<h4>
									<a href="userquestionlist" style="color: white;">Question list</a>&nbsp;&nbsp;
									<a href="addquestion" style="color: white;">Add Question</a>&nbsp;&nbsp;
									
								</h4>
								<br>
								<li><a href="perform_logout" style="color: white;">Sign
										out</a></li>
							</div></li>
					</c:when>
					<c:when test="${loggedOut==true }">
						<li class="navbar-text" style="color: white">${LogOutMessage}</li>
					</c:when>

				</c:choose>
			</ul>
		</div>
	</nav>
</body>
</html>