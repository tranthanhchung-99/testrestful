<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/admins/css/user/update.css">
<meta charset="UTF-8">
<title>UPDATE</title>
</head>
<body>
	<form action="/FinalWeb09/admin/user/update" method="post"
		enctype="multipart/form-data">

		<div class="all">
			<div class="head">
				<h1>Update Thong Tin Nguoi Dung</h1>
			</div>
			<div class="main">
				<div class="name">
					<h2>Id</h2>
					<input type="text" name="id" value="${user.id }">
				</div>
				<div class="name">
					<h2>Name</h2>
					<input type="text" name="name" value="${user.name }">
				</div>
				<div class="age">
					<h2>Age</h2>
					<input type="text" name="age" value="${user.age }">
				</div>
				<div class="gender">
					<h2>Gender</h2>
					<div class="i">
						<input type="radio" checked="checked" name="gender" value="Nam">M
						<input type="radio" name="gender" value="Nu">FM <input
							type="radio" name="gender" value="Khac">D
					</div>
				</div>
				<div class="role">
					<h2>Role</h2>
					<select name="role">
						<option value="${user.role }">${user.role }</option>
						<option value="member">member</option>
						<option value="admin">admin</option>
					</select>
				</div>
				<div class="address">
					<h2>Address</h2>
					<select name="address">
						<option value="${user.address }">${user.address }</option>
						<option value="Ha Noi">Ha Noi</option>
						<option value="Hung Yen">Hung Yen</option>
						<option value="Hai Phong">Hai Phong</option>
						<option value="Hai Duong">Hai Duong</option>
						<option value="Ha Nam">Ha Nam</option>
						<option value="Nam Dinh">Nam Dinh</option>
						<option value="Bac Ninh">Bac Ninh</option>
						<option value="Tp.Ho Chi Minh">Tp.Ho Chi Minh</option>
					</select>
				</div>
				<div class="username">
					<h2>UserName</h2>
					<input type="text" name="userName" value="${user.userName }">
				</div>
				<div class="password">
					<h2>PassWord</h2>
					<input type="password" name="matKhau" value="${user.matKhau }">
				</div>
				<div class="password">
					<h2>ImageUrl</h2>
					<input type="file" name="imageFile" accept="image/*"
						value="${user.imageUrl }">
				</div>

				<div class="btn">
					<button type="submit">UPDATE</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>