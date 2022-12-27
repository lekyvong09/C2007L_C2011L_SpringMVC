	<%@include file="header.jsp" %>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<script src="https://kit.fontawesome.com/4dcba643c6.js" crossorigin="anonymous"></script>
	<link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
	
</head>
<body>
	
	<div class="d-flex justify-content-center pt-5">
        <h2 class="text-light">Registration form</h2>
    </div>

    <div class="d-flex flex-column align-items-center py-3">
        <form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
                   modelAttribute="registeredUser"
                   method="post"
                   style="width:350px;" >
                   
			<div class="form-floating mb-3">
				<spring:bind path="username">
					<form:input path="username" id="floatingInputUsername" placeholder="username" 
						 class="form-control ${status.error ? 'is-invalid': '' }"/>
					 <label for="floatingInputUsername">User name</label>
					 <div class="invalid-feedback">
					 	<form:errors path="username"/>
					 </div>
				</spring:bind>
				
			</div>
			
			<div class="form-floating mb-3">
				<form:input path="email" type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com" />
				<label for="floatingInputEmail">Email address</label>
			</div>
			
			<div class="form-floating mb-3">
				<form:password path="password" class="form-control" id="floatingInputPassword" placeholder="password" />
				<label for="floatingInputPassword">Password</label>
			</div>
			
			<div class="form-floating mb-3">
				<form:password path="matchingPassword" class="form-control" id="floatingInputMatchingPassword" placeholder="matchingPassword" />
				<label for="floatingInputMatchingPassword">Re-enter password</label>
			</div>


            <div class="d-flex justify-content-center">
            	<button type="submit" class="btn btn-primary btn-lg mt-4" style="width: 30%;">Register</button>
            </div>
        </form:form>
    </div>
    
	
	
</body>
</html>