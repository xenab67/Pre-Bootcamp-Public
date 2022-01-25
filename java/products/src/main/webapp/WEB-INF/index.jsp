<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="container">
	<h1 class="display-2">Welcome to our product catalog!</h1>
	<p class="display-6">Please choose from the following selections:</p>
	<a href="/new/product">Create a New Product</a>
	<a href="/new/category">Create a New Category</a>
	<a href="/products">List of Products</a>
	<a href="/categories">List of Categories</a>
</div>
</body>
</html>