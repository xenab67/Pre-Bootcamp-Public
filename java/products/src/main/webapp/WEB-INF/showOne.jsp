<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>${category.name}</h1>
<table class="table table-dark">
	<thead>
		<td>Product</td>
		<td>Description</td>
		<td>Price</td>
	</thead>
	<tbody>
	<c:forEach items="${category.products}" var="product">
	<tr>
		<td>${product.name}</td>
		<td>${product.description}</td>
		<td>${product.price}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<form:form methods="POST" action="/add/product/${category.id}" modelAttribute="category">
	<div class="form-group">
		<select name ="product" class="form-control">
		<c:forEach items="${allProducts}" var="product">
		<option value="${product.id}">${product.name}</option>
		</c:forEach>
		</select>
	</div>
	<button class="btn btn-primary">Add</button>
</form:form>

</body>
</html>