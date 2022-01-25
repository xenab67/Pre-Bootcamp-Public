<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Template</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css"/>
<body onload="msg()">
	<script type="text/javascript" src="js/date.js"></script>
</head>

<body>
<%
  Date dNow = new Date( );
  SimpleDateFormat ft = new SimpleDateFormat ("EEEE, 'the' dd 'of', MMMM, YYYY");
  out.print( "<h2 align=\"center\">" + ft.format(dNow) + "</h2>");
    %>
</body>
</html>