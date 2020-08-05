<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>
		<a href="/simple01">Hello world!</a>
	</h1>
	<div class="jumbotron">
		<P>  
			<h1>aa 수정</h1> 
			<a href="/simple01/aajoin">aajoinform</a><br/>
			<a href="/simple01/aaselectall">aaselectall</a><br/>
			<a href="/simple01/aaupdate">aaupdateform</a><br/>
		</P>
	</div>
	<div class="row">
		<form action="aaupdate" method="post">
			bb <input class="form-control" type="text" name="bb">
			<input class="btn btn-primary" type="submit" value="저장"/>
		</form>
	</div>
</div>
</body>
</html>





