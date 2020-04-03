<%@page import="com.trungtamjava.helloword1.model.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.trungtamjava.helloword1.impl.CategoryDaoImpl"%>
<%@page import="com.trungtamjava.helloword1.dao.CategoryDao"%>
<%@page import="com.trungtamjava.helloword1.model.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>add product</title>
	<link rel="stylesheet" type="text/css" href="/FinalWeb09/admins/css/product/update.css">
</head>
<body>
	
	<form action="/FinalWeb09/admin/product/update" method="post" enctype="multipart/form-data">
			
			<%
							CategoryDao categoryDao= new CategoryDaoImpl();
								List<CategoryDTO> list = categoryDao.search("");
								request.setAttribute("listCategory", list);
						%>
			<div class="head">
			<h1>Update Product</h1>
		</div>
		<div class="main">
			<div class="name">
				<h2>Id</h2>
				<input type="text" name="id" value="${product.id }">
			</div>
			<div class="name">
				<h2>Name</h2>
				<input type="text" name="name" value="${product.name }">
			</div>
			<div class="name">
				<h2>Price</h2>
				<input type="text" name="price" value="${product.price }">
			</div>
			<div class="description">
				<h2>Description</h2>
				<select name="description">
					<option value="${product.description }">${product.description }</option>
					<option value="gia re">gia re</option>
					<option value="tam trung">tam trung</option>
					<option value="cao cap">cao cap</option>
				</select>
			</div>
			
			<div class="idcategory">
				<h2>Category</h2>
				<select name="idCategory">
					<option value="${product.category.id }">${product.category.name }</option>
					<c:forEach items="${listCategory }" var="c">
					<option value="${c.id }">${c.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="name">
				<h2>Image</h2>
				<input type="file" name="imageFile" accept="image/*">
			</div>

			<div class="btn">
			<button type="submit">UPDATE</button>
			</div>
		</div>
	</div>
	</form>
</body>
</html>