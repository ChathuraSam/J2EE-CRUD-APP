<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


	<h1>User List</h1>
	<a href="new">
		<button class="btn btn-success" onclick="">Add New User</button>
	</a>
	
	
	<table class="table table-striped">
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Email</td>
				<td>Country</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td><c:out value="${user.id }"/></td>
					<td><c:out value="${user.name }"/></td>
					<td><c:out value="${user.email }"/></td>
					<td><c:out value="${user.country }"/></td>
					<td><a href="edit?id=<c:out value='${user.id}'/>">Edit</a>
						&nbsp;&nbsp;&nbsp;
						<a href="delete?id=<c:out value='${user.id}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>  
</body>
</html>