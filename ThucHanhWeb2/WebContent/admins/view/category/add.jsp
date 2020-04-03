<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="/FinalWeb09/admins/css/category/add.css">
</head>
<body>
	<form action="/FinalWeb09/admin/category/add" method="post">
		<div class="all">
		<div class="head">
			<h1>Them category</h1>
		</div>
		<div class="main">
			<div class="input">
				<h2>Name</h2>
				<input type="text" name="name" placeholder="nhap vao ten category muon them">
			</div>
			<div class="btn"><button type="submit">ADD</button></div>
		</div>
	</form>
</body>
</html>