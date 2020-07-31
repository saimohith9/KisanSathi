<%@page import="com.skillassure.model.dto.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<jsp:include page="../home/link.jsp"></jsp:include>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div class="jumbotron">
		<c:choose>
			<c:when test="${cart.cartItems == null}">
				<h3 class="text-center">Basket is empty,Start Shopping Now</h3>
				<h1 class="text-center">
					<a href="<%=request.getContextPath()%>/product/products-list"
						class="btn btn-primary" style="justify-content: center;">Continue
						shopping</a>
				</h1>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-sm-4">
						<p class="larger_p">
							<strong>To change the quantity for an item,</strong> enter the
							new quantity and click on the Update button.
						</p>
						<p class="larger_p">
							<strong>To remove an item,</strong> click on the remove button.
						</p>
						<a href="<%=request.getContextPath()%>/product/products-list"
							class="btn btn-warning">Continue shopping</a><br>
						<form method="post" action="<c:url value='/cart/checkCustomer'/>">
							<input type="submit" class="btn btn-primary" value="Checkout" />
						</form>
					</div>
					<div class="col-sm-8">
						<div class="table-responsive">
							<table class="table">
								<colgroup>
									<col class="col-md-1">
									<col class="col-md-1">
									<col class="col-md-1">
									<col class="col-md-1">
									<col class="col-md-1">
								</colgroup>
								<thead>
									<tr>
										<th>Quantity</th>
										<th>Product Name</th>
										<th>Price</th>
										<th>Qty.</th>
										<th>Action</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${cart.cartItems}">
										<tr>
											<td>
												<form action="<c:url value='/cart/updateItem'/>">
													<input type="hidden" name="productid"
														value="<c:out value='${item.product.id}' />" /> <input
														type="number" name="quantity"
														value='<c:out value="${item.qty }"/>'> <input
														type="submit" class="btn btn-warning" value="Update" />
												</form>
											</td>
											<td><b>${item.product.productName}</b></td>
											<td>${item.product.price}</td>
											<td>${item.qty}
											<td>
												<form method="post"
													action="<c:url value='/cart/removeItem'/>">
													<input type="hidden" name="productid"
														value="<c:out value='${item.product.id}' />" /> <input
														type="submit" class="btn btn-danger" value="Remove" />
												</form>

											</td>
										</tr>
									</c:forEach>
									<tr>
										<td><strong>Total Amount: <i class="fa fa-inr"></i> ${cart.getTotalPrice()}
										</strong></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>