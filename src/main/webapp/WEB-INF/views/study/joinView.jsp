<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
</head>

<script>
function fn_idChk(){
	$.ajax({
		url : "/study/idChk",
		type : "post",
		dataType : "json",
		data : {"id" : $("#id").val()},
		success : function(data){
			if(data == 1){
				
			}else if(data == 0){
				$("#idChk").attr("value", "Y");
				
			}
		}
	})
}
</script>
	
<body>
<h1>가입 코드를 입력하세요</h1>
<h1><a href="/">홈으로</a></h1>
<form action="/study/join" method="get">
	<c:if test="${member.userId != null}">	
		<input type="text" name="userSno" title="가입코드 입력란"/>		
		<input type="hidden" onclick="fn_idChk()" name="sno" value="${sno}"/>		
		<input type="submit" value="가입"/>
	</c:if>
	
	<c:if test="${member.userId == null}">
		로그인 후 가입하세요.
	</c:if>
</form>


</body>
</html>