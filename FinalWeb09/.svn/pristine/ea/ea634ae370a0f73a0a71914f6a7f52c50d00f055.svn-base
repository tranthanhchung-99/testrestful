<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sach Product</title>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/admins/css/product/search.css">
	<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
</head>
<body>
	<form action="/FinalWeb09/admin/product/search" method="get">
		
		<div class="all">
			<div class="head">
				<h1>DANH SACH THONG TIN PRODUCT</h1>
			</div>
			<div class="main">
				<div class="timkiem">
					<input id="ip1" type="text" name="name"
						placeholder="nhap vao day!! ten product can tim kiem">
					<button id="btn1" type="submit"></button>
				</div>
				<div class="add">
					Click <a href="/FinalWeb09/admin/product/add"><i class="far fa-plus-square"></i></a> to add
					product
				</div>
				<table border="1px solid black">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>PRICE</th>
						<th>IMAGE</th>
						<th>DESCRITION</th>
						<th>IDCATEGORY</th>
						<th>CATEGORYNAME</th>
						<th>OPTION</th>
					</tr>
					<c:forEach items="${productList }" var="pro">
						<tr>
							<td>${pro.id }</td>
							<td>${pro.name }</td>
							<td>${pro.price }</td>
							<td><img src="/FinalWeb09/download?image=${pro.image }"
								style="width: 50px; height: 30px;"></td>
							<td>${pro.description }</td>
							<td>${pro.category.id }</td>
							<td>${pro.category.name }</td>
							<td>
								<button id="btn2">
									<a href="/FinalWeb09/admin/product/update?id=${pro.id }">
										<i class="far fa-edit"></i>update</a>
								</button>
								<button id="btn3">
									<a href="/FinalWeb09/admin/product/delete?id=${pro.id }">
										<i class="far fa-trash-alt"></i>delete</a>
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