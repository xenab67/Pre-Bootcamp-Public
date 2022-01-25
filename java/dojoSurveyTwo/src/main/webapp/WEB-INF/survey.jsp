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
<title>Survey Results</title>
</head>
<body>
<h1>Submitted Info</h1>
<p>Name: <c:out value="${name}"></c:out></p>
<p>Dojo Location: <c:out value="${location}"></c:out></p>
<p>Favorite Language: <c:out value="${language}"></c:out></p>
<p>Comment: v<c:out value="${comment}"></c:out></p>
</body>
</html>