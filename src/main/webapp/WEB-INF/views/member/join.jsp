<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/util.js"></script>
<!-- <script defer src="/js/memberJoin.js"></script> -->
</head>
<body>
	<h1>Join page</h1>
	
	<div style="display: flex;">
		<div style="margin-left: 15px;">
		<form:form modelAttribute="memberVO" method="post">
		<%-- <form action="./add" method="post" id="joinForm" style="margin-left: 15px;"> --%>
			
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<form:input path="id" cssClass="form-control" id="id" placeholder="아이디를 입력하세요"/>
				<form:errors path="id"></form:errors>
				<label for="id" class="form-label" id="idLabel"></label>
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<form:password path="pw" cssClass="form-control" id="pw" placeholder="비밀번호를 입력하세요"/>
				<form:errors path="pw"></form:errors>
				<label for="pw" class="form-label" id="pwLabel"></label>

			</div>
			<div class="mb-3">
				<label for="pwCheck" class="form-label">PW</label>
				<form:password path="pwCheck" cssClass="form-control" id="pwCheck" placeholder="비밀번호를 다시 입력해주세요"/>
				<form:errors path="pwCheck"></form:errors>
				<label for="pwCheck" class="form-label" id="pwCheckLabel"></label>
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">NAME</label>
				<form:input path="name" cssClass="form-control" id="name" placeholder="이름을 입력하세요"/>
				<!-- <form:errors path="name"></form:errors> -->
				<label for="name" class="form-label" id="nameLabel">라벨!${name}</label>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">EMAIL</label>
				<form:input path="email" cssClass="form-control" id="email" placeholder="이메일을 입력하세요"/>
				<form:errors path="email"></form:errors>
				<label for="email" class="form-label" id="emailLabel"></label>
			</div>
			<div class="mb-3">
				<label for="age" class="form-label">AGE</label>
				<form:input path="age" cssClass="form-control" id="age" placeholder="나이를 입력하세요"/>
				<form:errors path="age"></form:errors>
				<label for="age" class="form-label" id="ageLabel"></label>
			</div>
			<div class="mb-3">
				<label for="birth" class="form-label">BIRTH</label>
				<form:input path="birth" cssClass="form-control" id="birth" placeholder="생일을 입력하세요"/>
				<form:errors path="birth"></form:errors>
				<label for="birth" class="form-label" id="birthLabel"></label>
			</div>
			<button type="submit" id="joinButton" class="btn btn-primary">회원가입</button>
		</form:form>
		</div>
	</div>

	<!-- 포스트 버튼 -->
	<div>
		<button type="button" id="test">Post Test</button>
		<button type="button" id="test2">Ajax Get Test</button>
		<button type="button" id="test3">Ajax Post Test</button>

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

	<div>
		<select id="s1">
			<option>1</option>
			<option>2</option>
		</select>
		<button type="button" id="s1Add">Add</button>
	</div>
	

</body>
</html>