<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<jsp:include page="../home/link.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<script>
var typingTimer;                
var doneTypingInterval = 5000;  
var $input = $('#name');

$input.on('keyup', function () {
  clearTimeout(typingTimer);
  typingTimer = setTimeout(doneTyping, doneTypingInterval);
});

$input.on('keydown', function () {
  clearTimeout(typingTimer);
});

function doneTyping() {
 	$.get('<%=request.getRequestURL()%>/home/check.jsp?name=$input);
}
</script>
<body>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/");
	}
%>
	<div class="jumbotron">
		<div class="col-md-9">
		<h2>Add Product</h2>
		<div class="col-md-9 col-md-offset-3">
                <br><div class="alert alert-success center" role="alert">
                    <p>${success}</p>
                </div>
			<form action="<%=request.getContextPath()%>/product/addProduct" id="regForm" method="post">
			<div class="form-group">
				<label for="name">Product Name:</label> <input type="text"
					class="form-control" id="name"
					placeholder="Enter Your product Name" name="proname" required />
			</div>
			<div class="form-group">
				<label for="description">Product Description:</label> <input
					type="text" class="form-control" id="description"
					placeholder="Enter Your product description" name="description"
					required />
			</div>
			<div class="form-group">
				<label for="price">Price:</label> <input type="number"
					class="form-control" id="price"
					placeholder="Enter the Product price" name="price" required />
			</div>
			<!-- <div class="form-group">
				<label for="image">product Image:</label> <input type="file"
					class="form-control" id="image" name="image" required />
			</div> -->
			<div class="form-group">
					<button type="submit" class="btn btn-success">Add</button>
				</div>
				</form>
		</div>
	</div>
	</div>
</body>
</html>