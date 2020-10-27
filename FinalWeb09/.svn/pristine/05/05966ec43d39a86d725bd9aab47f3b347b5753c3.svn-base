<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/clients/css/billproduct/search.css">
</head>
<body>
	<form action="/FinalWeb09/billproduct/search">
		<div class="all">
			<div class="head">
				<h1>Chi tiet Bill</h1>
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
							<th>TEN_SP</th>
							<th>GIA_SP</th>
							<th>SOLUONG</th>
							<th>THANH TIEN</th>

						</tr>
						<c:forEach items="${listBillProduct }" var="bp">
							<tr>
								<td>${bp.id }</td>
								<td>${bp.product.name }</td>
								<td>${bp.product.price }</td>
								<td>${bp.quantity }</td>
								<td>${bp.product.price*bp.quantity }</td>

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