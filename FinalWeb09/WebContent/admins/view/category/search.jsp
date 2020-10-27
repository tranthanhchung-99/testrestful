<%@page import="java.util.List"%>
<%@page import="com.ttjv.model.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/admins/css/category/search.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
</head>
<body>



	<div class="all">
		<div class="head">
			<h1>Danh Sach Category</h1>
		</div>
		<div class="main">
			<div class="search clear">
				<form action="/FinalWeb09/admin/category/search" method="post">
					<input  name="keyword" type="text" placeholder="Tim theo ten" value="${keyword}">
					<button type="submit" >Tim</button>
				</form>
			</div>
			<div class="add">
				Click <a href="/FinalWeb09/admin/category/add"><i
					class="far fa-plus-square"></i></a> to add category
			</div>
			<div class="table">
				<table>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>OPTION</th>
					</tr>
					<c:forEach items="${categoryList }" var="cat">
						<tr>
							<td>${cat.id }</td>
							<td>${cat.name }</td>
							<td>
								<button>
									<a href="/FinalWeb09/admin/category/update?id=${cat.id }"><i
										class="far fa-edit"></i>update</a>
								</button>
								<button>
									<a href="/FinalWeb09/admin/category/delete?id=${cat.id }"><i
										class="far fa-trash-alt"></i>delete</a>
								</button>
							</td>
						</tr>
					</c:forEach>

				</table>
				<!-- Phan trang -->
				<c:forEach begin="1" end="${maxPage}" step="1" var="pageNo">
					<a
						href="/FinalWeb09/admin/category/search?pageNo=${pageNo}&?keyword=${keyword}">${pageNo}</a>
				</c:forEach>
				<h5>
					quay lai<a href="/FinalWeb09/admin/dashboach"> trang chu</a>
				</h5>
			</div>
		</div>
	</div>

</body>
</html>