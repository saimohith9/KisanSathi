<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>KisanSathi</title>
<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900"
	rel="stylesheet">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">


<link rel="stylesheet" href="css/bootstrap-datepicker.css">

<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">


<link rel="stylesheet" href="css/style.css">


</head>
<%-- <body>
	<div class="jumbotron coloumn-right">
			<div class="col-md-6">
				<br>
				<br>
				<h2>Login</h2>
				<div class="alert alert-success center" role="alert">
					<p>${Notification }</p>
				</div>
				<form action="<%=request.getContextPath()%>/login" method="post">
					<div class="form-group">
						<label for="userName">User Name:</label> <input type="email"
							class="form-control" placeholder="Enter Your Mail Id"
							id="userName" name="userName" required>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" placeholder="enter Your password"
							id="password" name="password" required>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Login</button>
					</div>
				</form>
			</div>
		</div>
</body> --%>
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">
	<div class="site-wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="intro-section"
			style="background-image: url('images/hero_1.jpg');">
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-md-7 mx-auto text-center">
						<h1>The Best Place to Buy and Sell</h1>
						<p>
							<a href="<%=request.getContextPath()%>/product/products-list"
								class="btn btn-primary">Buy Products</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>