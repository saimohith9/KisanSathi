<%@page import="com.skillassure.model.dto.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<jsp:include page="../home/link.jsp"></jsp:include>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div class="jumbotron">
	<% Cart cart = (Cart) session.getAttribute("cart");%>
		<h1 class="text-center">Payment is Processing</h1>
		<h3 class="text-center">
			Total Price :
			<%=cart.getTotalPrice()%>
			</h3>
		<br>
		<br> <h3 class="text-center"><a href="<%=request.getContextPath()%>/cart/order"
			class="btn btn-warning">Proceed To
			Payment</a></h3>
	</div>
</body>
</html>
