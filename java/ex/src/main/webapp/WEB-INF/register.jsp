<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to GreatIdeas!</h1>
	<div class="row">
		<div class="col>">
		<h2>Login</h2>
		<form method="POST" action="/login">
			<div class="form-group">
				<label>Email:</label>
				<input class="form-control" type="email" name="lemail">
			</div>
			<div class="form-group">
				<label>Password:</label>
				<input class="form-control" type="password" name="lpassword">
			</div>
			<button class="btn btn-success">Login</button>
			</form>
		</div>
		<div class="col>">
		<h2>Register</h2>
				<form:form action="/" methods="post" modelAttribute="user">
					 <div class="form-group">
						<form:label path="firstName">First Name</form:label>
						<form:errors path="firstName"/>
						<form:input class="form-control" path="firstName"/>
					</div> 
					<div class="form-group">
						<form:label path="lastName">Last Name</form:label>
						<form:errors path="lastName"/>
						<form:input class="form-control" path="lastName"/>
					</div>
					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:errors path="email"/>
						<form:input class="form-control" path="email"/>
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:errors path="password"/>
						<form:input type="password" class="form-control" path="password"/>
					</div>
					<div>
						<form:label path="confirmPassword">Confirm Password</form:label>
						<form:errors path="confirmPassword"/>
						<form:input type="password" class="form-control" path="confirmPassword"/>
						
					</div>
					<input class="btn btn-success" type="submit" value="submit"/>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>