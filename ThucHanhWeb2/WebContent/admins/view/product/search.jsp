<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>Danh Sach Product</title>
	<link rel="stylesheet" type="text/css" href="/FinalWeb09/admins/css/product/search.css">
</head>
<body>
	<form action="/FinalWeb09/admin/product/search" method="get">
	<!--
	<ul>
		<li><a href="/FinalWeb09/admin/product/add"> THEM PRODUCT</a></li>
		<li><a href="/FinalWeb09/admin/product/search"> SEARCH PRODUCT</a></li>
	</ul>
	<label>Name</label>
		<input type="text" name="name" value="" placehoder="nhap vao name">
		<input type="submit" value="TIM">
	<table>
		<tr> 
			<td>id </td>
			<td>name </td>
			<td>price </td>
			<td>image </td>
			<td>description </td>
			<td>id_category </td>
			<td>Tuy chon</td>
		</tr>
		<c:forEach items="${productList }" var="pro">
			<tr> 
				<td> ${pro.id }  </td>
				<td> ${pro.name } </td>
				<td> ${pro.price } </td>
				<td> <img alt="#" src=" ${pro.image }" width="70px">  </td>
				<td> ${pro.description } </td>
				<td> ${pro.category.id } </td>
				<td>
					<a href="/FinalWeb09/admin/product/update?id=${pro.id }"> UPDATE </a>
					<a href="/FinalWeb09/admin/product/delete?id=${pro.id }"> DELETE </a>
				</td>
			</tr>
		</c:forEach>
	</table>  -->
	<div class="all">
		<div class="head">
			<h1>DANH SACH THONG TIN PRODUCT</h1>
		</div>
		<div class="main">
			<div class="timkiem">
				<input id="ip1" type="text" name="name" placeholder="nhap vao day!! ten product can tim kiem">
				<button id="btn1" type="submit"></button>
			</div>
			<div class="add"> 
				Click <a href="/FinalWeb09/admin/product/add">ADD</a> to add product
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
				<td> ${pro.id }  </td>
				<td> ${pro.name } </td>
				<td> ${pro.price } </td>
				<td> ${pro.image }  </td>
				<td> ${pro.description } </td>
				<td> ${pro.category.id } </td>
				<td> ${pro.category.name } </td>
					<td>
						<button id="btn2"><a href="/FinalWeb09/admin/product/update?id=${pro.id }"> UPDATE </a></button>
						<button id="btn3"><a href="/FinalWeb09/admin/product/delete?id=${pro.id }"> DELETE </a></button>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</form>
</body>
</html>