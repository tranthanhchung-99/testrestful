<%@page import="com.trungtamjava.helloword1.model.BillProductDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	BillProductDTO billProduct= (BillProductDTO) request.getAttribute("billProduct");
%>
	<form action="/FinalWeb09/billproduct/update" method="post">
		<div>
			<lable>ID</lable>
			<input type="text" name="id" value="<%=billProduct.getId()%>">
		</div>
		<div>
			<lable>ID_BILL</lable>
			<input type="text" name="idBill" value="<%=billProduct.getBill().getId() %>">
		</div>
		<div>
			<lable>ID_PRODUCT</lable>
			<input type="text" name="idProduct" value="<%=billProduct.getProduct().getId() %>">
		</div>
		<div>
			<lable>QUANTITY</lable>
			<input type="text" name="quantity" value="${billProduct.quantity }">
		</div>
		<div>
			<lable>UNITPRICE</lable>
			<input type="text" name="unitPrice" value="${billProduct.unitPrice }">
		</div>
		<div>
			<input type="submit" value="UPDATE">
		</div>
	</form>
</body>
</html>