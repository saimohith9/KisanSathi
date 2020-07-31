<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../home/style.css">
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/"
			style="color: white"><b><i>KisanSathi</i></b></a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/product/addProduct.jsp">Add
						Product</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/product/sellerproducts">Seller
						Products</a></li>
			</ul>
		</div>
		<div class="collapse navbar-collapse justify-content-end"
			id="navbarNav">
			<ul class="navbar-nav">
				<p style="color: white">
					Welcome <b><%=session.getAttribute("username")%></b>
				</p>
				&nbsp;&nbsp;&nbsp;
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/product/cart.jsp"
					style="font-size: 25px; color: white;"><svg width="1em"
							height="1em" viewBox="0 0 16 16" class="bi bi-basket2"
							fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
								d="M1.111 7.186A.5.5 0 0 1 1.5 7h13a.5.5 0 0 1 .489.605l-1.5 7A.5.5 0 0 1 13 15H3a.5.5 0 0 1-.489-.395l-1.5-7a.5.5 0 0 1 .1-.42zM2.118 8l1.286 6h9.192l1.286-6H2.118z" />
  <path fill-rule="evenodd"
								d="M11.314 1.036a.5.5 0 0 1 .65.278l2 5a.5.5 0 1 1-.928.372l-2-5a.5.5 0 0 1 .278-.65zm-6.628 0a.5.5 0 0 0-.65.278l-2 5a.5.5 0 1 0 .928.372l2-5a.5.5 0 0 0-.278-.65z" />
  <path
								d="M4 10a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zM0 6.5A.5.5 0 0 1 .5 6h15a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1z" />
</svg></a> <%-- <%=session.getAttribute("cartItemCount")%> --%></li>
				<li class="nav-item"><a class="nav-link"
					style="color: white;"
					href="<%=request.getContextPath()%>/product/logout.jsp">logout</a>
				</li>
			</ul>
		</div>
	</nav>
</header>
