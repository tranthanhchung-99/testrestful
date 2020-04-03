<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>GIO HANG</title>
	<link rel="stylesheet" type="text/css" href="/ThucHanhWeb2/client/css/cart/listcart.css">
</head>
<body>
	<div class="all">
		<div class="head">
			<div class="logo">
	
			</div>
			<div class="search">
				<input type="" name="" placeholder="Tim Kiem "> 
				<button class="btsearch"><i class="fas fa-search"></i></button>
				<a id="a" href="#">hoi&dap</a>
				<a id="a" href="#">ho tro</a>
				<a id="a" href="#">feedback</a>
				<a href="/ThucHanhWeb2/client/inforclient?id=${sessionScope.loginClient.id }"><img src="${sessionScope.loginClient.imageUrl }"></a>
			</div>
		</div>
		<div class="main">
			<div class="main-head">THONG TIN GIO HANG</div>
			<div class="content">
				<table>
					<tr>
						<th>id</th>
						<th>tensp</th>
						<th>soluong</th>
						<th>giasp</th>
						<th>thanhtien</th>
						<th>option</th>
					</tr>
					<c:forEach items="${sessionScope.cart }" var="entry">
					<tr>
						<th>${entry.key }</th>
						<th>${entry.value.product.name }</th>
						<th>${entry.value.quantity }</th>
						<th>${entry.value.unitPrice }</th>
						<th>${entry.value.quantity*entry.value.unitPrice }</th>
						<th> 
							<a href="/ThucHanhWeb2/delete-from-cart?key=${entry.key}"> xoa</a>
							<a></a>
						</th>
					</tr>
					</c:forEach>
				</table>
				<div class="container">
					<a id="bt1" href="/ThucHanhWeb2/client/product" class="btn btn-info" role="button"><i class="fas fa-cart-plus"></i> MUA TIEP</a>
					<a id="bt2" href="/ThucHanhWeb2/client/bill/add" class="btn btn-info" role="button"><i class="fab fa-cc-amazon-pay"></i> THANH TOAN</a>
				</div>
			</div>
		</div>
	
</body>
</html>

