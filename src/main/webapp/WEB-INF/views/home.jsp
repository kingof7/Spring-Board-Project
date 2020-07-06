<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>스터디 게시판에 오신 걸 환영합니다.</title>
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<!-- css는 resources파일안에 -->
<link rel="stylesheet" href="/resources/index.css"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#logoutBtn").on("click", function() {
			location.href = "/member/logout";
		})
		$("#registerBtn").on("click", function() {
			location.href = "/member/register";
		})

		$("#memberUpdateBtn").on("click", function() {
			location.href = "/member/memberUpdateView";
		})

	})
</script>
<body style="margin: 0px auto; width: 80%;">
	<header>
		<div id="title">
			<span> 당신에게 필요한 모임 - StudyM</span>
		</div>
		<div id="menu">
			<a href="/"><span style="margin-left: 50px; color: green;"><b>스터디</b></span><span
				style="color: red;"><b>엠</b></span></a>

			<ul>
				<li style="margin-left: 20px;"><a href="/study/list">스터디목록</a></li>
				<li><a href="/board/list">스터디게시판</a></li>
				<li style="float: right; margin-right: 30px;"><a href="/member/list.do">회원조회</a></li>
				<li style="float: right;">|</li>
				<li style="float: right;"><a href="/member/register">회원가입</a></li>
				<li style="float: right;">|</li>
				<div class="container">
					<c:if test="${member == null}">
						<li style="float: right; padding: 10px; color: #0056b3;"
							type='button' data-toggle="modal" data-target="#popUpWindow">로그인</li>
					</c:if>
					<div class="modal fade" id="popUpWindow">
						<div class="modal-dialog">
							<div class="modal-content">
								<!-- header -->
								<div class="modal-header"
									style="display: block; text-align: center;">
									<h3 class="modal-title">로그인</h3>
								</div>
								<!-- body -->
								<div class="modal-header">
									<form role="form" name='homeForm' method="post"
										action="/member/login">
										<c:if test="${member == null}">
											<div class="form-group">
												<input type="text" id="userId" name="userId"
													class="form-control" placeholder="Id" style="width: 465px;" />
												<input type="password" id="userPass" name="userPass"
													class="form-control" placeholder="Password" />
											</div>

											<!-- footer -->
											<div class="modal-footer">
												<button class="btn btn-primary btn-block">Log In</button>
											</div>
										</c:if>
									</form>
								</div>

							</div>
						</div>
					</div>
				<c:if test="${msg == false}">
					<c:if test="${member == null}">
						<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
					</c:if>
					
				</c:if>				
				<c:if test="${member != null}">
					<ul style="line-height: 2.8; list-style-type: none; margin: 0px;">						
						<li style="padding-right: 10px; float: right; text-decoration: none;"><a href="/member/memberUpdateView" id="memberUpdateBtn" >회원정보수정</a></li>
						<li style="padding-right: 20px; float: right;">|</li>
						<li style="padding-right: 20px; float: right; text-decoration: none;"><a href="#" id="logoutBtn">로그아웃</a></li>
						<li style="padding-right: 20px; float: right;">|</li>
						<li style="padding-right: 20px; float: right; text-decoration: none;"><a>${member.userId}님 환영합니다.</a></li>	
						<li style="padding-right: 20px; float: right;">|</li>
						<li style="padding-right: 20px; float: right; text-decoration: none;"><a href="/study/createView">스터디개설</a></li>				
						<li style="color: red; padding-right: 20px; float: left; text-decoration: none;">${msg1}</li>
						<li style="color: red; padding-right: 20px; float: left; text-decoration: none;">${msg2}</li>
						<li style="color: red; padding-right: 20px; float: left; text-decoration: none;">${msg3}</li>
					</ul>															
				</c:if>
				</div>
			</ul>
		</div>
		<section>				
			<div id="content">			
				<img
					src="https://search.pstatic.net/common/?src=http%3A%2F%2Fldb.phinf.naver.net%2F20190719_42%2F1563527498327ep72X_JPEG%2FXRE0BVqaCxDVC-5dIzVSi2vk.jpg&type=b400" />
				<div class="real">
					<div
						style="padding: 10px; background-color: #fecc84; text-align: center;">실시간
						Best 게시글</div>
					<div
						style="padding-top: 10px; padding-left: 10px; background-color: white; height: 100px;">
						<img src="../img/rank1.png" style="width: 20px; height: 20px;" />
						<span>(서울 신촌,강남)롯데 인적성 스터디 모집합니다!</span>
					</div>
				</div>
				<div class="real">
					<div
						style="padding: 10px; background-color: #fecc84; text-align: center;">접속중
						회원: 0명</div>
					<div
						style="padding-top: 10px; padding-left: 10px; background-color: white; height: 100px; overflow-y: scroll;">

					</div>
				</div>
				<div class="real">
					<div
						style="padding: 10px; background-color: #fecc84; text-align: center;">접속중
						회원: 0명</div>
					<div
						style="padding-top: 10px; padding-left: 10px; background-color: white; height: 100px; overflow-y: scroll;">

					</div>
				</div>
				<div class="real">
					<div
						style="padding: 10px; background-color: #fecc84; text-align: center;">접속중
						회원: 0명</div>
					<div
						style="padding-top: 10px; padding-left: 10px; background-color: white; height: 100px; overflow-y: scroll;">

					</div>
				</div>
			</div>
		</section>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
			integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
			crossorigin="anonymous"></script>
	
</body>
</html>