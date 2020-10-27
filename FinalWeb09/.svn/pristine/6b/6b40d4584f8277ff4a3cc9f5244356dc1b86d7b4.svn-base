<%@page import="com.ttjv.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.ttjv.impl.CategoryDaoImpl"%>
<%@page import="com.ttjv.dao.CategoryDao"%>
<%@page import="com.ttjv.impl.ProductDaoImpl"%>
<%@page import="com.ttjv.model.Product"%>
<%@page import="com.ttjv.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>1pro</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/clients/css/infor1product.css">
</head>
<body>
	<form action="/FinalWeb09/client/1product" method="get">
		<div class="all">
			<div class="head">
				<h1>THONG TIN SAN PHAM</h1>
			</div>
			<div class="main">
				<div class="image">
					<div class="d1">
						<img id="img" src="/FinalWeb09/download?image=${product.image }"
							alt="#">
					</div>
					<div class="button">
						<a href="/FinalWeb09/add-to-cart?pid=${product.id}"
							class="btn btn-info" role="button"><i
							class="	fas fa-cart-arrow-down"></i> Add to cart</a> <a href="#"
							class="btn btn-info" role="button"> <i
							class="		fas fa-cart-plus"></i> Quantity
						</a>
					</div>
				</div>


				<div class="txt">

					<div class="id">Id:${product.id }</div>
					<div class="name">Name:${product.name }</div>
					<div class="price">Gia:${product.price }vnd</div>
					<div class="description">Mo ta:${product.description }</div>
					<div class="category">Category:${product.category.name }</div>

				</div>
			</div>
		</div>
	</form>
</body>
</html>