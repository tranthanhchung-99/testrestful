<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/FinalWeb09/billproduct/search">
		<input type="text" name="name" placehoder="nhap ten sp can tim"> 
		<button type="submit">TIM</button>
		<table>
			<tr>
				<th>ID</th>
				<th>ID_bill</th>
				<th>ID_KH</th>
				<th>TEN_SP</th>
				<th>GIA_SP</th>
				<th>SOLUONG</th>
				<th>PRICE_UNIT</th>
				<th>OPTION</th>
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
				<td>
					<a href="/FinalWeb09/billproduct/update?id=${bp.id }">update</a>
					<a href="/FinalWeb09/billproduct/delete?id=${bp.id }">delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<ul>
			<li><a href="/FinalWeb09/billproduct/add">ADD</a></li>
			<li><a href="/FinalWeb09/billproduct/search">SEARCH</a></li>
		</ul>
	</form>
</body>
</html>