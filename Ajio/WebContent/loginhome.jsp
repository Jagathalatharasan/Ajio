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

			<ul class="nav">
				<li class="nav-item"><button class="btn btn-danger"
						data-toggle="modal" data-target="#username">
						Welcome
						<%=session.getAttribute("name")%></button></li>&nbsp;
				<li class="nav-item"><a href="logout.jsp" class="btn btn-danger">Logout</a></li>
			</ul>
		</div>
		</nav>
	</center>
	<br>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<form action="AppServlet" method="post">
		Select Category : <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
			name="category">
			<c:forEach var="obj" items="${cList}">
				<option>${obj}</option>
			</c:forEach>

		</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="GO"
			name="bt" class="btn btn-success"> <br> <br> <br>
		<!-- <form action="AppServlet" method="get"> -->
		<table class="table">
			<tr>
				<th>Image</th>
				<th>Name</th>
				<th>Unit-Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach var="obj" items="${pList}">
				<tr>
					<input type="hidden" name="id" value="${obj.id}">
					<td><img src="ProjectImages/${obj.image_url}"
						style="height: 25%"></td>
					<td>${obj.name}</td>
					<td>${obj.price}</td>
					<td><input type="number" name="qty" min="0"></td>
				</tr>
			</c:forEach>
		</table>
		<!-- </form> -->
		<br> <br> <br> <br>
		<center>
			<input type="submit" value="Add To Cart" name="bt"
				class="btn btn-success">
		</center>
	</form>
	<br>
	<br>
	<br>
	<br>
</body>
</html>