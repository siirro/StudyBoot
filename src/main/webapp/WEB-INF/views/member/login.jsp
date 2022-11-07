<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>login page</h1>
	<div>
		<h3 style="color: red;">${param.error}</h3>
		<h3 style="color: red;">${param.message}</h3>
		<h3 style="color: red;">${requestScope.msg}</h3>
		
	</div>
	
	<div style="display: flex;">
		<form action="./login" method="post" style="margin-left: 15px;">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<input type="text" value="${cookie.userId.value}" name="id" class="form-control" id="id" placeholder="아이디를 입력하세요">
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<input type="text" name="pw" class="form-control" id="pw" placeholder="비밀번호를 입력하세요">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" name="rememberId" class="form-check-input" id="rememberId">
				<label for="rememberId" class="form-check-label">ID 기억하기</label>
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" name="rememberMe" class="form-check-input" id="rememberMe">
				<label for="rememberMe" class="form-check-label">자동 로그인</label>
			</div>
			
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	</div>

	
<script type="text/javascript">
/* history.replaceState({}, null, location.pathname) */
</script>
</body>
</html>