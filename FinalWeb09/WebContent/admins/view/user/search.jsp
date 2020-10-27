<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sach User</title>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/admins/css/user/search.css">
	<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
</head>

<body>
	<form action="/FinalWeb09/admin/user/search" method="get">
		<!--  <label>Name</label>
		<input type="text" name="name" >
		<input type="submit" value="Search">
		<table border ="1px solid black">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>ROLE</th>
				<th>IMAGEURL</th>
				<th>USERNAME</th>
				<th>MATKHAU</th>
				<th>TUYCHON</th>
			</tr>
			<c:forEach items="${userlist }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.age }</td>
					<td>${user.role}</td>
					<td>${user.imageUrl }</td>
					<td>${user.userName }</td>
					<td>${user.matKhau }</td>
					<td>
						<a href="/FinalWeb09/admin/user/update?id=${user.id }">update</a>
						<a href="/FinalWeb09/admin/user/delete?id=${user.id }">delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<ul>
			<li><a href="/FinalWeb09/admin/user/add">ADD USER</a></li>
			<li><a href="/FinalWeb09/admin/user/search">SEARCH USER</a></li>
		</ul>-->
		<div class="all">
			<div class="head">
				<h1>DANH SACH THONG TIN NGUOI DUNG</h1>
			</div>
			<div class="main">
				<div class="timkiem">
					<input id="ip1" type="text" name="name"
						placeholder="nhap vao day!! ten user can tim kiem nhe!!">
					<button id="btn1" type="submit"></button>
				</div>
				<div class="add">
					Click <a href="/FinalWeb09/admin/user/add"><i class="far fa-plus-square"></i></a> to add user 
				</div>
				<table border="1px solid black">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>AGE</th>
						<th>ROLE</th>
						<th>IMAGE</th>
						<th>USERNAME</th>
						<th>PASSWORD</th>
						<th>GENDER</th>
						<th>ADDRESS</th>
						<th>OPTION</th>
					</tr>
					<c:forEach items="${userlist }" var="user">
						<tr>
							<td>${user.id }</td>
							<td>${user.name }</td>
							<td>${user.age }</td>
							<td>${user.role}</td>
							<td><img src="/FinalWeb09/download?image=${user.imageUrl }"
								style="width: 50px; height: 30px;"></td>
							<td>${user.userName }</td>
							<td>${user.matKhau }</td>
							<td>${user.gender }</td>
							<td>${user.address }</td>
							<td>
								<button id="btn2">
									<a href="/FinalWeb09/admin/user/update?id=${user.id }"><i class="far fa-edit"></i>update</a>
								</button>
								<button id="btn3">
									<a href="/FinalWeb09/admin/user/delete?id=${user.id }"><i class="far fa-trash-alt"></i>delete</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
				<h5>
					quay lai<a href="/FinalWeb09/admin/dashboach"> trang chu</a>
				</h5>
			</div>
		</div>
	</form>
</body>
</html>