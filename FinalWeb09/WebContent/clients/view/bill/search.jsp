<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>History Bill</title>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/clients/css/bill/search.css">
</head>
</head>
<body>
	<form action="/FinalWeb09/bill/search" method="get">
		<div class="all">
			<div class="head">
				<h1>Danh Sach Bill</h1>
				<img
					src="/FinalWeb09/download?image=${sessionScope.loginClient.imageUrl }"></a>
			</div>
			<div class="main">
				<div class="search clear"></div>
				<div class="add"></div>
				<div class="table">
					<table>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>AGE</th>
							<th>ADDRESS</th>
							<th>BUYDATE</th>
							<th>PRICETOTAL</th>
							<th>OPTION</th>
						</tr>
						<c:forEach items="${listBill }" var="b">
							<tr>
								<td>${b.id }</td>
								<td>${b.user.name}</td>
								<td>${b.user.age}</td>
								<td>${b.user.address}</td>
								<td>${b.buyDate }</td>
								<td>${b.priceTotal }</td>
								<td><a
									href="/FinalWeb09/billproduct/search?idBill=${b.id }">detail</a></td>
							</tr>
						</c:forEach>
					</table>
					<h5>quay lai<a href="/FinalWeb09/client/product"> trang chu</a></h5>
				</div>
			</div>
		</div>

	</form>
</body>
</html>