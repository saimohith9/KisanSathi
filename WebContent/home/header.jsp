<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<%-- <header>
	<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand"
			href="<%=request.getContextPath()%>/home/homepage.jsp"
			style="color: green"><b><i>KisanSathi</i></b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end"
			id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item justify-content-start"><a class="nav-link"
					href="<%=request.getContextPath()%>/product/products-list">
						Buy Products</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/home/homepage.jsp">Login</a></li>
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
 --%>
<!-- <body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">
 -->
<!-- <div class="site-wrap">
		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>
	 -->
<header class="site-navbar py-4 site-navbar-target" role="banner">
	<div class="container">
		<div class="d-flex align-items-center">
			<div class="site-logo">
				<a href="<%=request.getContextPath()%>/"
					class="d-block" style="color: white"><b><i>KisanSathi</i></b> </a>
			</div>
			<div class="mr-auto">
				<nav class="site-navigation position-relative text-right"
					role="navigation">
					<ul
						class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
						<li><a
							href="<%=request.getContextPath()%>/product/products-list"
							class="nav-link text-left">Buy</a></li>
						<li class="has-children"><a href="services.html"
							class="nav-link text-left">Register</a>
							<ul class="dropdown">
								<li><a
									href="<%=request.getContextPath()%>/home/customerregister.jsp">Customer
										Register</a></li>
								<li><a
									href="<%=request.getContextPath()%>/home/sellerregister.jsp">Become a Seller</a></li>
							</ul></li>
						<li><a href="<%=request.getContextPath()%>/home/login.jsp"
							class="nav-link text-left">Log In</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</header>