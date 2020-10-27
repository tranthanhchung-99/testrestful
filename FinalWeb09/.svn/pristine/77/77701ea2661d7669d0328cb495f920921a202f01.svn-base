<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chi Tiet</title>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/admins/css/billproduct/search.css">
</head>
<body>
	<form action="/FinalWeb09/admin/billproduct/search">
		<div class="all">
			<div class="head">
				<h1>Chi tiet Bill</h1>
			</div>
			<div class="main">
				<div class="search clear"></div>
				<div class="add">
					Click <a href="#">PRINT</a> to print detail bill
				</div>
				<div class="table">
					<table>
						<tr>
							<th>ID</th>
							<th>ID_bill</th>
							<th>ID_KH</th>
							<th>TEN_SP</th>
							<th>GIA_SP</th>
							<th>SOLUONG</th>
							<th>THANH TIEN</th>

						</tr>
						<c:forEach items="${listBillProduct }" var="bp">
							<tr>
								<td>${bp.id }</td>
								<td>${bp.bill.id }</td>
								<td>${bp.bill.user.id }</td>
								<td>${bp.product.name }</td>
								<td>${bp.product.price }</td>
								<td>${bp.quantity }</td>
								<td>${bp.product.price*bp.quantity }</td>

							</tr>
						</c:forEach>
					</table>
					<h5>
						quay lai<a href="/FinalWeb09/admin/dashboach"> trang chu</a>
					</h5>


				</div>
			</div>
		</div>

	</form>
</body>
</html>