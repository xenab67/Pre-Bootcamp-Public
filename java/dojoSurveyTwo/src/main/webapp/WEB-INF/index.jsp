<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
</head>
<body>
<form action="/survey" method ="post" class="col-5 p-4 mx-auto">

	<div class="form-group">
		<label for ="name">Your Name:</label>
		<input type = "text" name="name" class="form-control">
	</div>
	<div class="form-group">
		<label for ="location">Dojo Location: </label>
		<select class="form-control" name="location">
			<option>San Jose</option>
			<option>Chicago</option>
			<option>Dallas</option>
			<option>Tulsa</option>
		</select>
	</div>
	<div class="form-group">
		<label for ="language">Favorite Language: </label>
		<select class="form-control" name="language">
			<option value="Java">Java</option>
			<option value="Python">Python</option>
			<option value="JavaScript">JavaScript</option>
			<option value="C++">C++</option>
			<option value="C#">C#</option>
		</select>
	</div>
	<div class="form-group">
    <label for="comment">Comment:</label>
    <textarea class="form-control" rows="3" name="comment"></textarea>
    <small id="commentHelp" class="form-text text-muted">This is optional! We would love to see what you have to say!</small>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</html>