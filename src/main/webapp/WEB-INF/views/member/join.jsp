<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/util.js"></script>
<script defer src="/js/memberJoin.js"></script>
</head>
<body>
	<h1>Join page</h1>
	
	<div style="display: flex;">
		<form action="./add" method="post" id="joinForm" style="margin-left: 15px;">
			
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<div style="display: flex;">
				<input type="text" name="id" class="form-control" id="id" value="" placeholder="아이디를 입력하세요">

				<button class="btn btn-danger" type="button" id="idCheck">중복확인</button>

				</div>
				<label for="id" class="form-label" id="idLabel"></label>
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<input type="password" name="pw" class="form-control" id="pw" placeholder="비밀번호를 입력하세요">
				<label for="pw" class="form-label" id="pwLabel"></label>

			</div>
			<div class="mb-3">
				<label for="pwCheck" class="form-label">PW</label>
				<input type="password" class="form-control" id="pwCheck" placeholder="비밀번호를 입력하세요">
				<label for="pwCheck" class="form-label" id="pwCheckLabel"></label>
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">NAME</label>
				<input type="text" name="name" class="form-control" id="name" placeholder="이름을 입력하세요">
				<label for="name" class="form-label" id="nameLabel"></label>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">EMAIL</label>
				<input type="email" name="email" class="form-control" id="email" placeholder="이메일 주소를 입력하세요">
				<label for="email" class="form-label" id="emailLabel"></label>

			</div>
			<button type="button" id="joinButton" class="btn btn-primary">회원가입</button>
		</form>
	</div>

	<!-- 약관 test -->
	<div class="row justify-content-center mt-5">
		<div>
			ALL <input type="checkbox" id="all">
		</div>

		<div>
			동의1 <input type="checkbox" class="check" name="" id="">
			<div>
				약관1의 내용
			</div>
		</div>

		<div>
			동의2 <input type="checkbox" class="check" name="" id="">
			<div>
				약관2의 내용
			</div>
		</div>

		<div>
			동의3 <input type="checkbox" class="check" name="" id="">
			<div>
				약관3의 내용
			</div>
		</div>
	</div>
	

</body>
</html>