<%@page import="com.skillassure.service.impl.ProductServiceImpl"%>
<%@page import="com.skillassure.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking</title>
<jsp:include page="../home/link.jsp"></jsp:include>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<br>
	<h1 class="text-center">You're not a seller to add the product</h1>
	<h1 class="text-center">
		<a href="<%=request.getContextPath()%>/product/products-list"
			class="btn btn-primary" style="justify-content: center;">Continue
			shopping</a>
	</h1>
</body>
</html>