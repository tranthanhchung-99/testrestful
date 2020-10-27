<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/FinalWeb09/bill/update" method="post">
		<div>
			<lable>ID</lable>
			<input type="text" name="id" value="${bill.id }">
		</div>
		<div>
			<lable>BUYDATE</lable>
			<input type="text" name="buyDate" value="${bill.buyDate }">
		</div>
		<div>
			<lable>PRICETOTAl</lable>
			<input type="text" name="priceTotal" value="${bill.priceTotal }">
		</div>
		<div>
			<lable>ID_USER</lable>
			<input type="text" name="idUser" value="${bill.user.id }">
		</div>
		<div>
			<input type="submit" value="UPDATE">
		</div>
	</form>
</body>
</html>