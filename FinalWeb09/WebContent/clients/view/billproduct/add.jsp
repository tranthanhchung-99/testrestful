<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/FinalWeb09/billproduct/add" method="post">
		<div>
			<lable>ID_BILL</lable>
			<input type="text" name="idBill" placehoder="nhap vao idbill">
		</div>
		<div>
			<lable>ID_PRODUCT</lable>
			<input type="text" name="idProduct" placehoder="nhap vao idproduct">
		</div>
		<div>
			<lable>QUANTITY</lable>
			<input type="text" name="quantity" placehoder="nhap vao so luong">
		</div>
		<div>
			<lable>UNIT_PRICE</lable>
			<input type="text" name="unitPrice" placehoder="nhap vao so luong">
		</div>
		<div>
			<input type="submit" value="ADD">
		</div>
	</form>
</body>
</html>