	<%@include file="header.jsp" %>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<script src="https://kit.fontawesome.com/4dcba643c6.js" crossorigin="anonymous"></script>
	<link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Log In</h3>
				</div>
				<div class="card-body">
					<form action="${pageContext.request.contextPath}/login" method="post">
						<div class="input-group form-group">
							<span class="input-group-text d-flex"><i class="fa-solid fa-user mx-auto"></i></span>
							<input name="username" type="text" class="form-control" placeholder="username"/>
						</div> 
						<div class="input-group form-group">
							<span class="input-group-text d-flex"><i class="fa-solid fa-key mx-auto"></i></span>
							<input name="password" type="password" class="form-control" placeholder="password"/>
						</div>
						
						<div class="form-group">
							<button type="submit" class="btn login_btn float-end">Login</button>
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Don't have an account?<a href="#">Sign Up</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>