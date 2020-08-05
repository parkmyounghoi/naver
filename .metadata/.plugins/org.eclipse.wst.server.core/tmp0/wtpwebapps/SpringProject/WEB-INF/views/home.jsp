<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<%@include file="head.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="menu.jsp"%>
		<div class="row">
			<div class="col-10 mx-auto p-3 m-3">
				<div id="demo" class="carousel slide" data-ride="carousel">
					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
					</ul>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="/resources/Desert.jpg" alt="Los Angeles">
						</div>
						<div class="carousel-item">
							<img src="/resources/Hydrangeas.jpg" alt="Chicago">
						</div>
						<div class="carousel-item">
							<img src="/resources/Penguins.jpg" alt="New York">
						</div>
						<div class="carousel-item">
							<img src="/resources/Chrysanthemum.jpg" alt="New York">
						</div>
						<div class="carousel-item">
							<img src="/resources/Hydrangeas.jpg" alt="New York">
						</div>
						<div class="carousel-item">
							<img src="/resources/Jellyfish.jpg" alt="New York">
						</div>
						<div class="carousel-item">
							<img src="/resources/Koala.jpg" alt="New York">
						</div>
					</div>
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</a>
					<a class="carousel-control-next" href="#demo" data-slide="next">
						<span class="carousel-control-next-icon"></span>
					</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<form>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label>
						<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
						<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check me out</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div class="col-sm-7">
				<iframe width="665" height="444" src="https://www.youtube.com/embed/UHYHr6DFgQY" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
			<div class="col-sm-2" style="background-color: yellow;">
				한행 한열에 해당됩니다.	
			</div>
		</div>
		
		<div class="row">
			<div class="col p-3 m-3 text-center" style="height: 100px;">
				Copy right	
			</div>
		</div>
	</div>
</body>
</html>
