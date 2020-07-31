<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Something Went Wrong</title>
<jsp:include page="link.jsp"></jsp:include>
<jsp:include page="../product/header.jsp"></jsp:include>
</head>
<body>
	<h1 class="text-center">You're register as a customer,<br>Please register as a seller for selling your products</h1>
	<h3 class="text-center"><a href="<%=request.getContextPath()%>/product/products-list"
			class="btn btn-primary" style="justify-content: center;">Continue
			shopping</a></h3>
</body>
</html>