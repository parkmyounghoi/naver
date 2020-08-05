<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<%@include file="../head.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="../menu.jsp"%>
<!-- 		<div class="row"> -->
<!-- 			<div class="col"> -->
<!-- 				<div id="demo" class="carousel slide" data-ride="carousel"> -->
<!-- 					<ul class="carousel-indicators"> -->
<!-- 						<li data-target="#demo" data-slide-to="0" class="active"></li> -->
<!-- 						<li data-target="#demo" data-slide-to="1"></li> -->
<!-- 						<li data-target="#demo" data-slide-to="2"></li> -->
<!-- 					</ul> -->
<!-- 					<div class="carousel-inner"> -->
<!-- 						<div class="carousel-item active"> -->
<!-- 							<img src="/resources/Desert.jpg" alt="Los Angeles"> -->
<!-- 						</div> -->
<!-- 						<div class="carousel-item"> -->
<!-- 							<img src="/resources/Hydrangeas.jpg" alt="Chicago"> -->
<!-- 						</div> -->
<!-- 						<div class="carousel-item"> -->
<!-- 							<img src="/resources/Penguins.jpg" alt="New York"> -->
<!-- 						</div> -->
<!-- 						<div class="carousel-item"> -->
<!-- 							<img src="/resources/Chrysanthemum.jpg" alt="New York"> -->
<!-- 						</div> -->
<!-- 						<div class="carousel-item"> -->
<!-- 							<img src="/resources/Hydrangeas.jpg" alt="New York"> -->
<!-- 						</div> -->
<!-- 						<div class="carousel-item"> -->
<!-- 							<img src="/resources/Jellyfish.jpg" alt="New York"> -->
<!-- 						</div> -->
<!-- 						<div class="carousel-item"> -->
<!-- 							<img src="/resources/Koala.jpg" alt="New York"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<a class="carousel-control-prev" href="#demo" data-slide="prev"> -->
<!-- 						<span class="carousel-control-prev-icon"></span> -->
<!-- 					</a> -->
<!-- 					<a class="carousel-control-next" href="#demo" data-slide="next"> -->
<!-- 						<span class="carousel-control-next-icon"></span> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="row">
			<div class="col-sm-3" style="background-color: red;">
				한행 한열에 해당됩니다.	
			</div>
			<div class="col-sm-7" style="background-color: green;">
				한행 한열에 해당됩니다.	
			</div>
			<div class="col-sm-2" style="background-color: yellow;">
				한행 한열에 해당됩니다.	
			</div>
		</div>
		<div>
			<table class="table">
				<tr>
					<td>bid</td>
					<td>bname</td>
					<td>btitle</td>
					<td>bdate</td>
				</tr>
			<c:forEach items="${list}" var="temp">
				<tr>
					<td>${temp.bid}</td>
					<td>${temp.bname}</td>
					<td>${temp.btitle}</td>
					<td>${temp.bdate}</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
