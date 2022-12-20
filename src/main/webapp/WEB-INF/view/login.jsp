	<%@include file="header.jsp" %>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<script src="https://kit.fontawesome.com/4dcba643c6.js" crossorigin="anonymous"></script>
	<link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
	
	<!-- Alertify -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
</head>
<body>
	<c:if test="${param.error != null}">
		<input id="notification" type="hidden" value="Sorry! you entered wrong username or password">
	</c:if>
	
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Log In</h3>
				</div>
				<div class="card-body">
					<form action="${pageContext.request.contextPath}/login" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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
	
	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
	
	<script type="text/javascript">
		var notification = document.getElementById("notification");
		if (notification != null && notification.value.length >0) {
			alertify.error(notification.value);
		}
		
	</script>
	
</body>
</html>