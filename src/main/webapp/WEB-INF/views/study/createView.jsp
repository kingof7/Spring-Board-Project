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



<title>스터디 개설</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			var formObj = $("form[name='writeForm']");
			$(".write_btn").on("click", function() {
				if (fn_valiChk()) {
					return false;
				}
				formObj.attr("action", "/study/create");
				formObj.attr("method", "post");
				formObj.submit();
			});
			fn_addFile();
		})
		function fn_valiChk() {
			var regForm = $("form[name='writeForm'] .chk").length;
			for (var i = 0; i < regForm; i++) {
				if ($(".chk").eq(i).val() == ""
						|| $(".chk").eq(i).val() == null) {
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
		function fn_addFile() {
			var fileIndex = 1;
			//$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
			$(".fileAdd_btn")
					.on(
							"click",
							function() {
								$("#fileIndex")
										.append(
												"<div><input type='file' style='float:left;' name='file_"
														+ (fileIndex++)
														+ "'>"
														+ "</button>"
														+ "<button type='button' style='float:right;' id='fileDelBtn'>"
														+ "삭제"
														+ "</button></div>");
							});
			$(document).on("click", "#fileDelBtn", function() {
				$(this).parent().remove();

			});
		}
		$(function() {
			$("#totime").datepicker();
			$("#fromtime").datepicker();
		});
	</script>
	<section id="container">
		
		<form name="writeForm" method="post" action="/study/create"
			enctype="multipart/form-data">
			<table>
				<tbody>
					
					<c:if test="${member.userId != null}">
						<tr>
							<td><label for="writer">아이디</label><input type="text"
								id="id" name="id" class="chk" title="아이디를 입력하세요"
								value="${member.userId}" /></td>
						</tr>
						<tr>
							<td><label for="title">스터디명</label><input type="text"
								id="sname" name="sname" class="chk" title="스터디명을 입력하세요." /></td>
						</tr>
						<tr>
							<td><label for="content">목적</label> <textarea id="title"
									name="title" class="chk" title="스터디 목적을 입력하세요."></textarea></td>
						</tr>
						<tr>
							<td><label for="content">내용</label> <textarea id="content"
									name="content" class="chk" title="스터디 내용을 입력하세요."></textarea></td>
						</tr>
						<tr>
							<td><label for="master">스터디장</label><input type="text"
								id="mname" name="mname" class="chk" title="스터디장을 입력하세요." /></td>
						</tr>
						<tr>
							<td><label for="region">지역</label><input type="text"
								id="location" name="location" class="chk" title="지역을 입력하세요." /></td>
						</tr>
						<tr>
							<td><label for="toTime">시작날짜</label><input type="text"
								id="totime" name="totime" class="chk" title="시작날짜를 입력하세요."></td>
						</tr>
						<tr>
							<td><label for="fromTime">종료날짜</label><input type="text"
								id="fromtime" name="fromtime" class="chk" title="종료날짜를 입력하세요."></td>
						</tr>

						<tr>
							<td id="fileIndex"></td>
						</tr>
						<tr>
							<td>
								<button class="write_btn" type="submit">스터디개설</button>
							</td>
						</tr>
					</c:if>
					<c:if test="${member.userId == null}">
						로그인 후 개설하세요.
					</c:if>

				</tbody>
			</table>
		</form>

	</section>

</body>
</html>