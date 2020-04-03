<%@page import="com.trungtamjava.helloword1.model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"></head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/ThucHanhWeb2/client/css/menu.css">
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
<form action="/ThucHanhWeb2/client/product" method="post">
<%
	UserDTO client= (UserDTO) session.getAttribute("loginClient");
%>
	<div class="all">
		<div class="head">
			<div class="logo"></div>
			<div class="banner"></div>
		</div><!--head-->
		<div class="main">
			<div class="main-head">
				<div class="search">
						<input type="text" name="name" placeholder="tim kiem" value="">
						<button type="submit" class="btn btn-default btn-circle btn-lg"><i class="	fas fa-search"></i></button>
						<a href="/ThucHanhWeb2/client/inforclient?id=<%=client.getId() %>"><img src="<%=client.getImageUrl() %>" > </a>
				</div> 
			</div>
			
			<c:forEach items="${productList }" var="p">
			<div id="p1">
				<img alt="#" src="/ThucHanhWeb2/download?image=${p.image } " id="picture" >
				<a href="/ThucHanhWeb2/client/1product?id=${ p.id}">
				<div class="txt">
				
					<h1>Id:${p.id }</h1>
					<h1>Name:${p.name }</h1>
					<h1>Gia:${p.price }vnd</h1>
					<h1>Mo ta:${p.description }</h1>
				</div></a>
			</div>
			</c:forEach>
		</div><!--main-->
		<div class="footer"></div><!--footer-->
	</div>
</form>
</body>
</html>