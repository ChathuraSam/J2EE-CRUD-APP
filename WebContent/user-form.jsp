<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container p-3 mb-2 bg-info text-white pd-10 mx-auto">

		<div class="row">
			<div class="col-md-8 p-5 m-10">
				<div class="p-5">

					<a href="<%=request.getContextPath()%>/list">
						<button>List of Users</button>
					</a>

					<c:if test="${user != null }">
						<h1>Update User</h1>
						<form action="update" method="post">
					</c:if>
					<c:if test="${user == null }">
						<h1>Add New User</h1>
						<form action="insert" method="post">
					</c:if>

					<c:if test="${user != null }">
						<input type="hidden" value="<c:out value='${user.id }'/>"
							name="id" />
						<h3>
							ID:
							<c:out value='${user.id }' />
						</h3>
					</c:if>

					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter Name" value="<c:out value='${user.name }'/>" />
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" placeholder="Enter Email"
							name="email" value="<c:out value='${user.email }'/>">
					</div>
					<div class="form-group">
						<label for="country">Country:</label> <input type="text"
							class="form-control" id="country" placeholder="Enter Country"
							name="country" value="<c:out value='${user.country }'/>">
					</div>
					<input type="submit" class="btn btn-succesfull">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>