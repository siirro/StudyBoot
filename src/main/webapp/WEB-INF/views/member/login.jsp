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
	
	<div style="display: flex;">
		<form action="./login" method="post" style="margin-left: 15px;">
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<input type="text" name="id" class="form-control" id="id" placeholder="아이디를 입력하세요">
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<input type="text" name="pw" class="form-control" id="pw" placeholder="비밀번호를 입력하세요">
			</div>
			
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	</div>

	

</body>
</html>