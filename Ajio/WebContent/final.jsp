<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#9cffb3">
	<center>
		<nav class="navbar bg-info">

		<div class="container">

			<img src=" ProjectImages/ajiologo.png"
				style="height: 60px; width: 120px;">

			<ul class="nav">
				<li class="nav-item"><button class="btn btn-danger"
						data-toggle="modal" data-target="#username">Welcome <%=session.getAttribute("name") %></button></li>&nbsp;
				<li class="nav-item"><a href="logout.jsp" class="btn btn-danger">Logout</a></li>
			</ul>
		</div>
		</nav>
	</center>
	<br>
	<br>
	<center>
		<h1>You have successfully ordered your products</h1>
		<br>
		<br>
		<h1>Thank You for visting us</h1>
		<br>
		<br>
		<span style='font-size:100px;'>&#128522;</span>
	</center>
</body>
</html>