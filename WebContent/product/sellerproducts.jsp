<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Products</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<jsp:include page="../home/link.jsp"></jsp:include>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/");
	}
%>
	<div class="jumbotron">
		<div class="col-md-9 col-md-9">
			<h3>
				If u want to buy the products please click <a
					href="<%=request.getContextPath()%>/product/products-list"
					class="btn btn-warning">Continue shopping</a>
			</h3>
			<c:choose>
				<%-- <c:when test="${exception == true}">
					<div>
						<p class="text-center">Unfortunately, You aren't the seller to
							add the product</p>
					</div>
				</c:when>
				 --%>
				<c:when test="${products == null}">
					<div>
						<h1 class="text-center">No Products Found</h1>
						<p class="text-center">Unfortunately, You didn't add the
							product</p>
					</div>
				</c:when>
				<c:otherwise>
					<h1 class="text-center">Products of a seller</h1>
					<table class="table">
						<colgroup>
							<col class="col-md-8">
							<col class="col-md-1">
							<col class="col-md-1">
							<col class="col-md-1">
						</colgroup>
						<thead>
							<tr>
								<th>Product Description</th>
								<th>Product Name</th>
								<th>Product Price</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}">
								<tr>
									<td><c:out value="${product.productDescription}" /></td>
									<td><b><c:out value="${product.productName}" /></b></td>
									<td><i class="fa fa-inr"></i><c:out value=" ${product.price}" /></td>
									<td><a
										href="<%=request.getContextPath()%>/product/delete?id=<c:out value='${product.id}'/>"
										class="btn btn-primary btn-block">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>