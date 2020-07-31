<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<jsp:include page="../home/link.jsp"></jsp:include>
</head>
<jsp:include page="header.jsp"></jsp:include>
<style type="text/css">
.price {
	position: absolute;
	display: inline-block;
	width: 80px;
	height: 80px;
	line-height: 80px;
	border-radius: 50%;
	background: #f37121;
	font-size: 20px;
	text-align: center;
	color: #fff;
	font-weight: 500;
}
</style>
<body>
<br>
	<div class="container">
		<div class="row">
			<c:choose>
				<c:when test="${allproducts == null}">
					<div>
						<h1 class="text-center">No Products Found</h1>
						<p class="text-center">Unfortunately, Seller didn't add the
							products</p>
					</div>
				</c:when>
				<c:otherwise>
					<%-- 	<!-- <div class="row">
					 -->
					<div class="row" style="display: inline-block;">
						<c:forEach var="product" items="${allproducts}">
							<div class="col-md-5 col-sm-12 col-xs-12">
									<a href="#"> <img
										src="<c:out value = "${product.image}" />
										style=" height: 90%; width: 90%;" />
									</a>
								</div>
							<div class="card-block">
								<h5 class="name">
									<b style="font-size: 30px;"><c:out
											value="${product.productName}" /></b>
								</h5>
								<p>
									<span style="font-size: 20px;">Price:<c:out
											value="${product.price}" /> /kg
									</span>
								</p>
								<div class="row">
									<a
										href="<%=request.getContextPath()%>/product/addtocart?id=<c:out value='${product.id}'/>"
										class="btn btn-danger">To Cart</a>&nbsp;&nbsp;&nbsp;
									<button type="button" class="btn btn-secondary" title=""
										data-container="body" data-toggle="popover"
										data-placement="right"
										data-content="<c:out value='${product.productDescription}'/>"
										data-original-title="Description">Info</button>
									<button type="button" class="btn btn-secondary"
										data-toggle="popover" data-placement="bottom"
										title="<c:out value='${product.productDescription}'/>"
										data-original-title="">Info</button>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- 	</div>
				 -->
		 --%>
					<!-- <div class="col-6 col-md-4 col-lg-3">
				 	 -->
					<div class="card-group">
						<c:forEach var="product" items="${allproducts}">
							<div class="row">
								 <div class="col-md">
								<div>
									<strong class="price"><c:out value=" ${product.price}" />/kg
									</strong>
								</div>
								<div class="p-4">
									<h3 class="text-center">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#"><b
											style="font-size: 30px;"><c:out
													value="${product.productName}" /></b></a>
									</h3><br>
									<p>by <c:out value="${product.seller.companyName}" /></p>
									<br> <a
										href="<%=request.getContextPath()%>/product/addtocart?id=<c:out value='${product.id}'/>"
										class="btn btn-outline-danger">To Cart</a>&nbsp;&nbsp;&nbsp;
									<button type="button" class="btn btn-outline-secondary"
										data-toggle="popover" data-placement="bottom"
										title="<c:out value='${product.productDescription}'/>"
										data-original-title="">Info</button>
								</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>