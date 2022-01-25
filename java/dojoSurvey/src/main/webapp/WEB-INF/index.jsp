<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<div class="form-group">
		<label for ="name">Your Name:</label>
		<input type = "text">
	</div>
	<div class="form-group">
		<label for ="location">Dojo Location: </label>
		<select class="form-control">
			<option>San Jose</option>
			<option>Chicago</option>
			<option>Dallas</option>
			<option>Tulsa</option>
		</select>
	</div>
	<div class="form-group">
		<label for ="language">Favorite Language: </label>
		<select class="form-control">
			<option>Java</option>
			<option>Python</option>
			<option>JavaScript</option>
			<option>C++</option>
			<option>C#</option>
		</select>
	</div>
	<div class="form-group">
    <label for="exampleFormControlTextarea1">Comment:</label>
    <textarea class="form-control" rows="3"></textarea>
    <small id="commentHelp" class="form-text text-muted">This is optional! We would love to see what you have to say!</small>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</html>