<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>dash boarch</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="/FinalWeb09/admins/css/dashboach.css">
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	// Load the Visualization API and the piechart package.
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);

	function drawChart() {

		// Create the data table.
		var data = new google.visualization.DataTable();
		// Create columns for the DataTable
		data.addColumn('string');
		data.addColumn('number', 'Devices');
		// Create Rows with data
		data.addRows([ [ 'Túi', 21 ], [ 'Sách', 14 ], [ 'Váy', 9 ],
				[ 'Áo', 4 ], [ 'Quần', 42 ], [ 'Vở', 5 ], [ 'Khác', 5 ] ]);
		//Create option for chart
		var options = {
			title : 'Thống Kê Số Lượng Sản Phẩm Theo Danh Mục',
			'width' : 910,
			'height' : 500
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<div class="all">
		<div class="left">
			<div class="left-head">
				<div class="logo">
					<img src="/FinalWeb09/admins/image/logodash.png">
				</div>
			</div>
			<div class="left-main">
				<div class="btn1">
					<div class="btn-group">

						<button type="button" class="btn btn-primary dropdown-toggle"
							data-toggle="dropdown">
							<div class="icon">
								<i class="	fas fa-user-alt"></i>
							</div>
							Manager
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/FinalWeb09/admin/user/search">USER</a>
							<a class="dropdown-item" href="/FinalWeb09/admin/product/search">PRODUCT</a>
							<a class="dropdown-item" href="/FinalWeb09/admin/category/search">CATEGORY</a>
						</div>
					</div>
				</div>

				<div class="btn1">
					<div class="btn-group">

						<button type="button" class="btn btn-primary dropdown-toggle"
							data-toggle="dropdown">
							<div class="icon">
								<i class="	far fa-clipboard"></i>
							</div>
							HistoryBill
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/FinalWeb09/admin/bill/search">Bill</a>

						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="main">
			<div class="main-head">
				<div class="search">
					<input type="text" name="" placeholder="tim kiem" value="">

					<button type="submit" class="btn btn-default btn-circle btn-lg">
						<i class="	fas fa-search"></i>
					</button>
				</div>
				<div class="admin">
					<a href="/FinalWeb09/admin/infor"><img
						src="/FinalWeb09/download?image=${sessionScope.loginUser.imageUrl }">
					</a>
				</div>
			</div>
			<div class="main-content">
				<div id="chart_div" class="chart"></div>
			</div>
			<h5>chuyen toi giao dien <a href="/FinalWeb09/client/product">Khach Hang</a></h5>
		</div>
	</div>
</body>
</html>