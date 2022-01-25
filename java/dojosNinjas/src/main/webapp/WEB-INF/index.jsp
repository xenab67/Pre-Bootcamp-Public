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
	<h1 class="display-2">Welcome to CodingDojo!</h1>
	<p class="display-6">Please select from the following options!</p>
	<a href="/new/dojo">Create New Dojo</a>
	<a href="/new/ninja">Create New Ninja</a>
	<table class="table table-dark">
		<thead>
			<th>Dojo</th>
		</thead>
		<tbody>
		<c:forEach items="${dojos}" var="dojo">
			<tr>
			<td><a href="/dojo/${dojo.id}">${dojo.name}</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>