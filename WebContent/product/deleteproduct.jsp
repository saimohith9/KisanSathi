<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<br><br><br><br><br><br>
	<h1 class="text-center">Product Deleted Successfully</h1>
	<h1 class="text-center"><a href="<%=request.getContextPath()%>/product/addProduct.jsp"
						class="btn btn-primary" style="justify-content: center;">Continue
						shopping</a>
	</h1>
</body>
</html>