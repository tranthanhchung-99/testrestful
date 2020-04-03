<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>dash boarch</title>
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"></head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" type="text/css" href="/ThucHanhWeb2/admins/css/dashboach.css">
</head>
<body>
	<div class="all">
		<div class="left">
			<div class="left-head">
				<div class="logo"><img src="/ThucHanhWeb2/admins/image/logodash.png"></div>
			</div>
			<div class="left-main">
				<div class="btn1">
					<div class="btn-group">
						  
					      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
					      <div class="icon"><i class="	fas fa-user-alt"></i> </div>
					        Manager
					      </button>
				      <div class="dropdown-menu">
				      	<a class="dropdown-item" href="/ThucHanhWeb2/admin/user/search">USER</a>
				        <a class="dropdown-item" href="/ThucHanhWeb2/admin/product/search">PRODUCT</a>
				        <a class="dropdown-item" href="/ThucHanhWeb2/admin/category/search">CATEGORY</a>
				      </div>
					</div>
				</div>
				
				<div class="btn1">
					<div class="btn-group">
						  
					      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
					      <div class="icon"><i class="	far fa-clipboard"></i> </div>
					        HistoryBill
					      </button>
				      <div class="dropdown-menu">
				      	<a class="dropdown-item" href="/ThucHanhWeb2/bill/search">Bill</a>
				       
				      </div>
					</div>
				</div>
				
			</div>
		</div>
		<div class="main">
			<div class="main-head"> 
				<div class="search">
					<input type="text" name="" placeholder="tim kiem" value="">

					<button type="submit" class="btn btn-default btn-circle btn-lg"><i class="	fas fa-search"></i></button>
				</div>
				<div class="admin"> 
					<a href="#"><img src="/ThucHanhWeb2/admins/image/anhnen1.jpg" > </a>
				</div>   
			</div>
			<div class="main-content">
				
			</div>
		</div>
	</div>
</body>
</html>