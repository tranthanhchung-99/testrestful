<%@page import="java.util.List"%>
<%@page import="com.trungtamjava.helloword1.model.CategoryDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="/FinalWeb09/admins/css/category/search.css">
</head>
<body>
	<form action="/FinalWeb09/admin/category/search" method="get">
		
		
		<div class="all"> 
		<div class="head">
			<h1>Danh Sach Category</h1>
		</div>
		<div class="main">
			<div class="search clear">
				<input type="text" name="name" placeholder="nhap vao ten category can tim">
				<button type="submit"></button>
			</div>
			<div class="add">
				Click <a href="/FinalWeb09/admin/category/add">ADD</a> to add category
			</div>
			<div class="table">
				<table>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>OPTION</th>
					</tr>
					<c:forEach items="${listCategory }" var="cat" >
					<tr>
						<td>${cat.id }</td>
						<td>${cat.name }</td>
						<td>
							<button><a href="/FinalWeb09/admin/category/update?id=${cat.id }">update</a></button>
							<button><a href="/FinalWeb09/admin/category/delete?id=${cat.id }">delete</a></button>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	</form>
</body>
</html>