<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<jsp:include page="../home/link.jsp"></jsp:include>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div class="jumbotron">
		<div class="centre-align">
			<h1>Your invoice</h1>
		</div>
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<div class="panel panel-default larger_p additional-padding">
					<p>
						<strong>Date:</strong>
					</p>
					<p>
						<fmt:formatDate value="${order.orderDate}" type="date"
							dateStyle="long" />
					</p>
					<p>
						<strong>Ship to:</strong>
					</p>
					<p class="remove-margin">
						<c:out value='${order.customer.userName}'/><br>
						 <c:out value='${order.customer.name}' />
					</p>
					<p class="remove-margin">
						<c:out value="${order.customer.phoneNo}" />
					</p>
					<table class="table">
						<colgroup>
							<col class="col-md-6">
							<col class="col-md-2">
							<col class="col-md-2">
							<col class="col-md-2">
						</colgroup>
						<thead>
							<tr>
								<th>Description</th>
								<th>Name</th>
								<th>Quantity(kg)</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${order.items}">
								<tr>
								<td>${item.product.productDescription}</td>
								<td><b>${item.product.productName}</b></td>
									<td>${item.qty}</td>
									<td>${item.product.price}</td>
								</tr>
							</c:forEach>
							<tr>
								<td><strong>Total Amount:</strong></td>
								<td>&nbsp;</td>
								<td>${order.getTotalPrice()}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<%-- <div class="push_down">
					<form method="post"
						action="<c:url value='/order/displayCustomer' />">
						<input type="submit" class="btn btn-default float-left"
							value="Edit Address">
					</form>
					<form method="post"
						action="<c:url value='/order/displayPayment' />">
						<input type="submit" class="btn btn-primary" value="Continue">
					</form>
				</div>
 --%>			</div>
		</div>
	</div>
</body>
</html>