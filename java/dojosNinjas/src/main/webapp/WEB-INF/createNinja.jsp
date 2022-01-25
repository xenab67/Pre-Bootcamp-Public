<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ninja</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="container">
	<h1>Add New Ninja</h1>
	<form:form methods="POST" action="/new/ninja" modelAttribute="ninja">
		<div class="form-group">
			<form:select path="dojo">
			<c:forEach items="${allDojos }" var="dojo">
			<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</div>
		<div class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</div>
		<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:errors path="age"/>
			<form:input path="age"/>
		</div>
		<button>Add New Ninja!</button>
	</form:form>
	<hr>
</div>
</body>
</html>