<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Seller</title>
<jsp:include page="link.jsp"></jsp:include>
</head>
<script type="text/javascript">
	function checkPassword() {
		var password = document.getElementById("password").value;
		var cPassword = document.getElementById("Cpassword").value;
		if (password != cPassword) {
			document.getElementById("password").style.borderColor = "#E34234"
			document.getElementById("Cpassword").style.borderColor = "#E34234"
			alert("password doesn't matches");
			return false;
		} else {
			alert("Password Matches");
			document.getElementById("regForm").submit();
			return true;
		}
	}
</script>
<jsp:include page="loginheader.jsp"></jsp:include>
<body>
	<div class="col-md-6 col-md-offset-3" style="float: left; width: 50%">
		<div class="jumbotron">
			<h2>Seller Registration</h2>
			<div class="alert alert-success center" role="alert">
				<p>${Notification}</p>
			</div>
			<form action="<%=request.getContextPath()%>/seller/register"
				id="regForm" onsubmit="return checkPassword()" method="post">
				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name" placeholder="Enter Your Name"
						name="name" required />
				</div>
				<div class="form-group">
					<label for="email">Email Id:</label> <input type="email"
						class="form-control" id="email" placeholder="Enter Your Email"
						name="email" required />
				</div>
				<div class="form-group">
					<label for="phoneNo">Phone No:</label> <input type="number"
						class="form-control" id="phoneNo"
						placeholder="Enter Your Phone No" name="phoneNo" required />
				</div>
				<div class="form-group">
					<label for="companyName">Company Name:</label> <input type="text"
						class="form-control" id="companyName"
						placeholder="Enter Your Company Name" name="companyName" required />
				</div>
				<div class="form-group">
					<label for="panNo">PAN No:</label> <input type="text"
						class="form-control" id="panNo" placeholder="Enter Your Phone No"
						name="panNo" required />
				</div>
				<div class="form-group">
					<label for="password">password:</label> <input type="password"
						class="form-control" id="password"
						placeholder="Enter Your password" name="password" required />
				</div>
				<div class="form-group">
					<label for="Cpassword">Confirm Password:</label> <input
						type="password" class="form-control" id="Cpassword"
						placeholder="Enter Your password" name="Cpassword" required />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Register</button>
				</div>
			</form>
		</div>
	</div>
	<div class="jumbotron" style="float: right; width: 50%">
		<h3>
			If you are already Registered Please Click <br> <a
				href="<%=request.getContextPath()%>/home/login.jsp">Login</a>
		</h3>
	</div>
</body>
</html>