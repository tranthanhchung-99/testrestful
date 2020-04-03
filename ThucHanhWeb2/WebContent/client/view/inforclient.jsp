<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="/ThucHanhWeb2/client/css/inforclient.css">
</head>
<body>
<form action="/ThucHanhWeb2/client/inforclient" method="get"></form>
	<div class="head"><h1>THONG TIN CA NHAN</h1></div>
		<div class="main">
			<div class="image">
				<div class="d1">
					<img id="img" src="${user.imageUrl }" alt="#">
				</div>
			</div>
			<div class="txt">
				<div class="name">Tên:${user.name }</div>
				<div class="price">Tuổi:${user.age }</div>
				<div class="description">Giới tính:${user.gender }</div>
				<div class="category">Địa Chỉ:${user.address }</div>
				<div class="button">
					<a href="#" class="btn btn-info" role="button"><i class="fas fa-edit"></i> UPDATE</a>
				</div>
			</div>
</body>
</html>