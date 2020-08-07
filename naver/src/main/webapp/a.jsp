<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<button id="abtn">myjson가져오기</button>
</body>
</html>
<script type="text/javascript">
$("#abtn").on("click",function(){
	$.ajax({
		url:"myjson",
		success:function(result){
			alert(result);
		},
		error:function(e){
			alert(e);
		}
	
	});
});
</script>






