<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<%@include file="../head.jsp"%>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#insertBtn').click(function(){
				location.href='/freeboard/insert';
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<%@include file="../menu.jsp"%>
		<div class="row">
			<div class="col">
				<div class="jumbotron">
					<h1 class="display-4">안녕하세요</h1>
					<p class="lead">자유 게시판</p>
					<hr class="my-4">
					<p>좋아하는 글 남겨주세요.</p>
				</div>
			</div>
		</div>
		<div style="overflow:hidden;">
			<div style="float:right; margin-bottom: 10px;">
				<button id="insertBtn" class="btn btn-primary">글쓰기</button>
			</div>
		</div>
		<div class="row">
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
		<div class="row">
			<div class="col-sm-4 mx-auto">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<%
// 							String pageNum = request.getParameter("pageNum");
// 							if(pageNum.equals("1")){
// 							}
						%>
						<c:if test="${param.pageNum eq 1}">
							<li class="page-item disabled"><a class="page-link" href="#" >Previous</a></li>
						</c:if>
						<c:if test="${param.pageNum ne 1}">
							<li class="page-item"><a class="page-link" href="#" >Previous</a></li>
						</c:if>
						<c:forEach begin="1" end="${pageCount}" var="i">
							<li class="page-item"><a class="page-link" href="/freeboard?pageNum=${i}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>
