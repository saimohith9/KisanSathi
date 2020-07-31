<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<jsp:include page="link.jsp"></jsp:include>
</head>
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">
		<jsp:include page="loginheader.jsp"></jsp:include>
				<div class="jumbotron">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<h2 class="mb-5 text-black">
								<strong>LogIn</strong>
							</h2>
							<div class="alert alert-success center" role="alert">
					<p>${Notification }</p>
				</div>
				<form action="<%=request.getContextPath()%>/login" method="post">
					<div class="form-group">
						<label for="userName">User Name/Email	:</label> <input type="email"
							class="form-control" placeholder="Enter Your Mail Id"
							id="userName" name="userName" required>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" placeholder="enter Your password"
							id="password" name="password" required>
					</div>
					<div class="form-group">
						<h1 class="text-center"><button type="submit" class="btn btn-success">Login</button></h1>
					</div>
				</form>
						</div>
					</div>
				</div>
</body>
</html>