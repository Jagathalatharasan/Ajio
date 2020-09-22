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
	<br>
	<form action="AppServlet" method="post">
		Customer Name :<input type="text" name="name"
			value="<%=session.getAttribute("name")%>"> <br> <br>
		<table class="table">
			<tr>
				<th>Item-Id</th>
				<th>Image</th>
				<th>Name</th>
				<th>Unit-Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach var="obj" items="${selectedItemsList}" varStatus="st">
				<tr>
					<td name="id">${obj.id}</td>
					<td><img src="ProjectImages/${obj.image_url}"
						style="height: 25%"></td>
					<td>${obj.getName()}</td>
					<td>${obj.getPrice()}</td>
					<td name="qty">${qtyList.get(st.index)}</td>
				</tr>
			</c:forEach>

		</table>
		<br> <br> <br> <br>
		<center>
			<h3>Total Order : ${totalPrice}</h3>
			<br> <br> <br> <br> <input type="submit"
				name="bt" value="Continue" class="btn btn-success">
		</center>
		<br> <br>
	</form>

</body>
</html>