<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col">
		<ul class="nav nav-pills">
			<li class="nav-item">
				<c:if test="${sessionScope.menu eq 'home' }">
					<a class="nav-link active p-4 m-3" href="/"><img src="/resources/logo.png" alt="로고" width="100%"/></a>
				</c:if>
				<c:if test="${sessionScope.menu ne 'home' }">
				<a class="nav-link p-4 m-3" href="/"><img src="/resources/logo.png" alt="로고" width="100%"/></a>
				</c:if>
			</li>
			<li class="nav-item">
				<c:if test="${sessionScope.menu eq 'student' }">
					<a class="nav-link active p-4 m-3" href="/student">학생관리</a>
				</c:if>
				<c:if test="${sessionScope.menu ne 'student' }">
					<a class="nav-link p-4 m-3" href="/student">학생관리</a>
				</c:if>
			</li>
			<li class="nav-item">
				<c:if test="${sessionScope.menu eq 'freeboard' }">
					<a class="nav-link active p-4 m-3" href="/freeboard">자유게시판</a>
				</c:if>
				<c:if test="${sessionScope.menu ne 'freeboard' }">
					<a class="nav-link p-4 m-3" href="/freeboard">자유게시판</a>
				</c:if>
			</li>
			<li class="nav-item">
				<a class="nav-link p-4 m-3" href="#">메뉴2</a>
			</li>
			<li class="nav-item">
				<a class="nav-link p-4 m-3 disabled" href="#">Disabled</a>
			</li>
		</ul>
	</div>
</div>