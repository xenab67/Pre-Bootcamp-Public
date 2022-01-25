<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>${product.name}</h1>
<table class="table table-dark">
	<thead>
		<td>Categories</td>
	</thead>
	<tbody>
	<c:forEach items="${product.categories}" var="category">
	<tr>
		<td>${category.name}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<h3>Add Category</h3>
<form:form methods="POST" action="/add/category/${product.id}" modelAttribute="product">
	<div class="form-group">
		<select name ="category" class="form-control">
		<c:forEach items="${allCategories}" var="category">
		<option value="${category.id}">${category.name}</option>
		</c:forEach>
		</select>
	</div>
	<button class="btn btn-primary">Add</button>
</form:form>
</body>
</html>