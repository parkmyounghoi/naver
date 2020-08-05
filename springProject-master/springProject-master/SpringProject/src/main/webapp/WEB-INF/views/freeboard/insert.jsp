<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<%@include file="../head.jsp"%>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#cancelBtn').click(function(){
				location.href='/freeboard';
			});
			$('#saveBtn').click(function(){
				$('#myfrm').attr('action','/freeboard/save')
				$('#myfrm').submit();
			});
		});
	</script>
</head>
<body>
<form id="myfrm">
	<div class="container">
		<%@include file="../menu.jsp"%>
		<div class="row">
			<div class="col">
				글제목 : <input style="margin-bottom: 10px;" type="text" name="btitle"/>
				<textarea rows="15" cols="50" name="bcontent" class="form-control"></textarea>
			</div>
		</div>
		<div style="width:100%;">
			<div style="width:200px; margin:20px auto;">
				<button type="button" id="cancelBtn" class="btn btn-primary">취소</button>
				<button type="button" id="saveBtn" class="btn btn-primary">저장</button>
			</div>
		</div>
	</div>
</form>
</body>
</html>
