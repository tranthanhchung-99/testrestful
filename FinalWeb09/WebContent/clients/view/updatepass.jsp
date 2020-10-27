<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/clients/css/updatepass.css">
<meta charset="UTF-8">
<title>Doi Mat Khau!</title>
</head>
<body>
	<form action="/FinalWeb09/client/updatepass" method="post">

		<div class="all">
			<div class="head">
				<h1>Doi Mat Khau</h1>

			</div>
			<div class="main">
				<div class="password">
					<h2>Old Pass</h2>
					<input type="password" name="oldmatKhau"
						placehoder="nhap mat khau cu">
				</div>
				<div class="password">
					<h2>New Pass</h2>
					<input type="password" name="newmatKhau"
						placehoder="nhap mat khau moi">
				</div>
				<div class="btn">
					<button type="submit">Confirm</button>
					<button type="submit">
						<a
							href="/FinalWeb09/client/inforclient?id=${sessionScope.loginClient.id }">Cancel</a>
					</button>
				</div>
				<h5>yeu cau: nhap dung mat khau cu!</h5>
			</div>
		</div>
	</form>
</body>
</html>