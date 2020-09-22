<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body>
	<center>
		<nav class="navbar bg-info">

		<div class="container">

			<img src=" ProjectImages/ajiologo.png"
				style="height: 60px; width: 120px;">
			<h1>Welcome to AJIO</h1>

			<ul class="nav">
				<li class="nav-item"><button class="btn btn-danger"
						data-toggle="modal" data-target="#login">Login</button></li>&nbsp;
				<li class="nav-item"><button class="btn btn-danger"
						data-toggle="modal" data-target="#signup">SignUp</button></li>
			</ul>
		</div>
		</nav>
	</center>

	<div class="modal" id="signup">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Enter User Details</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<form action="AppServlet" method="post">
						<div class="form-group">
							Name : <input type="text" name="t1" class="form-control">
						</div>

						<div class="form-group">
							Email-Id : <input type="email" name="t2" class="form-control">
						</div>
						<div class="form-group">
							Password : <input type="password" name="t3" class="form-control">
						</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">

					<input type="submit" value="Register" name="bt"
						class="btn btn-success" />
				</div>

				</form>

			</div>
		</div>
	</div>



	<div class="modal" id="login">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Welcome</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<form action="AppServlet" method="post">


						<div class="form-group">
							Email-Id : <input type="email" name="f1"
								class="form-control col-sm-6">
						</div>
						<div class="form-group">
							Password : <input type="password" name="f2"
								class="form-control col-sm-6">
						</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<input type="submit" value="Login" name="bt"
						class="btn btn-success" />
				</div>

				</form>

			</div>
		</div>
	</div>
	<br>
	<br>
	<h1 style="text-align: center">OUR SERVICES</h1>
	<br>
	<br>
	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
			<li data-target="#demo" data-slide-to="3"></li>
			<li data-target="#demo" data-slide-to="4"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="ProjectImages/one.jpg" alt="Los Angeles" width="100%"
					height="500">
			</div>
			<div class="carousel-item">
				<img src="ProjectImages/two.jpg" alt="Chicago" width="100%"
					height="500">
			</div>
			<div class="carousel-item">
				<img src="ProjectImages/three.jpg" alt="New York" width="100%"
					height="500">
			</div>
			<div class="carousel-item">
				<img src="ProjectImages/four.jpg" alt="Los Angeles" width="100%"
					height="500">
			</div>
			<div class="carousel-item">
				<img src="ProjectImages/five.jpg" alt="Los Angeles" width="100%"
					height="500">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
	<br>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form action="AppServlet" method="post"> Select Category :
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<select name="category">
		<c:forEach var="obj" items="${cList}">
			<option>${obj}</option>
		</c:forEach>

	</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="Go" name="bt" class="btn btn-success"></form>
	<br>
	<br>
	<br>
	<table class="table">
		<tr>
			<th>Image</th>
			<th>Name</th>
			<th>Unit-Price</th>
		</tr>

		<c:forEach var="obj" items="${pList}">
			<tr>
				<td><img src="ProjectImages/${obj.image_url}" style="height:25%"></td>
				<td>${obj.name}</td>
				<td>${obj.price}</td>
		</c:forEach>
	</table>


</body>
</html>