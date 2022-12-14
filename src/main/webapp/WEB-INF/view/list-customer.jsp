<%@include file="header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

</head>
<body>
	<div class="container py-3">
	
		<div class="d-flex align-items-end flex-column" style="height: 70px;">
			<form:form action="${pageContext.request.contextPath}/logout" method="post">
				<input class="btn btn-success" type="submit" value="Logout"/>
			</form:form>
		</div>
		
		<div class="d-flex align-items-center pt-3 flex-column">
			<h1>Welcome to CRM system - <sec:authentication property="principal.username"/></h1>
			<h5>You have roles: <sec:authentication property="principal.authorities"/> </h5>
		</div>
		
		
		
		
		<div class="d-flex justify-content-between align-items-center py-5">
			<input class="btn btn-primary vw-25" type="button" value="Add customer" 
				onclick="window.location.href='new'; return false;" >
				
			<form method="get" action="search">
				<div class="form-group row">
					<div class="col">
						<input name="theSearchName" class="form-control mr-2" type="search"
							placeholder="Search" aria-label="Search"/>
					</div>
					<div class="col">
						<button type="submit" class="btn btn-success">Search</button>
					</div>
				</div>
			</form>
		</div>
		
		<hr class="mx-auto vw-50"/>
		
		<div class="table-responsive py-3">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Image</th>
						<sec:authorize access="hasRole('ADMIN')">
							<th>Action</th>
						</sec:authorize>
					</tr>
				</thead>
					
				<tbody>
					<c:forEach items="${customers}" var="item">
						<!-- http://localhost:8080/customer/load?customerId=${item.id} -->
						<c:url var="updateLink" value="/customer/load">
							<c:param name="customerId" value="${item.id}"/>
						</c:url>
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${item.id}"/>
						</c:url>
						<tr>
							<td>${item.firstName}</td>
							<td>${item.lastName}</td>
							<td>${item.email}</td>
							<td>
								<img src="${pageContext.request.contextPath}/images/customer/${item.id}"
									style="height: 6rem; width: 4rem; object-fit: cover;" alt="temp">
							</td>
							<sec:authorize access="hasRole('ADMIN')">
								<td>
									<a href="${updateLink}">Update</a>
									 | 
									<a href="${deleteLink }" onclick="if (!confirm('Are you sure you want to delete?')) return false;">Delete</a>
								</td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>