<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<jsp:include page="link.jsp"></jsp:include>
<%-- <header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" role = "navigation">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/"
			style="color: white"><b><i>KisanSathi</i></b></a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li><a
					href="<%=request.getContextPath()%>/product/products-list"
					class="nav-link">Buy</a></li>
				<li class="has-children"><a href="services.html"
					class="nav-link text-left">Register</a>
					<ul class="dropdown">
						<li><a
							href="<%=request.getContextPath()%>/home/customerregister.jsp">Customer
								Register</a></li>
						<li><a
							href="<%=request.getContextPath()%>/home/sellerregister.jsp">Seller
								Register</a></li>
							</ul></li>
				<li><a href="<%=request.getContextPath()%>/home/login.jsp"
					class="nav-link">Log In</a></li>
			</ul>
		</div>
	</nav>
</header>
 --%>
 <header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"">
		<a class="navbar-brand"
			href="<%=request.getContextPath()%>/"
			style="color: white"><b><i>KisanSathi</i></b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse"
			id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item justify-content-start"><a class="nav-link"
					href="<%=request.getContextPath()%>/product/products-list">
						Buy</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/home/login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/home/customerregister.jsp">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/home/sellerregister.jsp">Become
						a Seller</a></li>
			</ul>
		</div>
	</nav>
</header>
 