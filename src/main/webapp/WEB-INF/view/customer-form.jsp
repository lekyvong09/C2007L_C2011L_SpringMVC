<%@include file="header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

</head>
<body>
	<div class="container py-3">
		<h1 class="text-center mb-4 test-header">Customer Form</h1>
		
		
		<div class="d-flex flex-column align-items-center py-5">
			<form:form action="saveCustomer?${_csrf.parameterName}=${_csrf.token}" modelAttribute="customer" method="post" style="width:350px;"
					enctype="multipart/form-data">
				<form:hidden path="id" />
				<div class="form-floating mb-3">
					<form:input path="firstName" class="form-control" id="firstName" placeholder="firstName"/>
					<label for="firstName">First Name</label>
				</div>
				<div class="form-floating mb-3">
					<form:input path="lastName" class="form-control" id="lastName" placeholder="lastName"/>
					<label for="lastName">Last Name</label>
				</div>
				<div class="form-floating mb-3">
					<form:input path="email" class="form-control" id="email" placeholder="email"/>
					<label for="email">Email</label>
				</div>
				
				<div class="d-flex justify-content-center mb-3">
					<input name="file" onchange="loadFile(event)" class="form-control" type="file" accept="image/*">
				</div>
				
				<div class="mt-4 d-flex justify-content-center">
					<button type="submit" class="btn btn-primary btn-lg ">Save</button>
				</div>
				
			</form:form>
			
			<img id="preview-image-before-image" style="width: 440px; object-fit:cover;" class="mt-4" />
		</div>
		
		<p><a href="<c:url value="/customer/list" />">Back to List</a></p>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
		function loadFile(event) {
			if (event.target.files.length > 0) {
				var previewImage = document.getElementById('preview-image-before-image');
				previewImage.src = URL.createObjectURL(event.target.files[0]);
			}
		}
	</script>
</body>
</html>