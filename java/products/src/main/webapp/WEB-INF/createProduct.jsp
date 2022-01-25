<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Add new product!</h1>
	<form:form methods="POST" action="/new/product" modelAttribute="product">
		<div class="form-group">
			<form:select class="form-control" path="categories">
			<c:forEach items="${allCategories}" var="category">
			<option value="${category.id}">${category.name}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div class="form-group">
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</div>
		<div class="form-group">
			<form:label path="price">Price</form:label>
			<form:errors path="price"/>
			<form:input path="price"/>
		</div>
		<button>Add New Product!</button>
	
	</form:form>
</div>
</body>
</html>