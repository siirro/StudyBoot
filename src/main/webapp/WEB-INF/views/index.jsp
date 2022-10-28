<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
<script defer src="/js/test.js"></script>
</head>
<body>
	<h1>Index page</h1>
	<h1><spring:message code="hi" var="h"></spring:message></h1>
	<h1><spring:message code="test" text="code가 없을 때 출력하는 메세지"></spring:message></h1>

	<div style="display: flex;">
		<div>
			<c:if test="${empty member}">
				<a class="btn btn-info" href="./member/login">로그인</a>
				<a class="btn btn-info" href="./member/add">회원가입</a>
			</c:if>
			<c:if test="${not empty member}">
				<h3><spring:message code="welcome" arguments="${member.id}"></spring:message></h3>
				<h3><spring:message code="welcome2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message></h3>
				<h3>${member.roleVOs[0].roleName}등급입니다</h3>
				<a class="btn btn-danger" href="./member/logout">로그아웃</a>
				<a class="btn btn-primary" href="./member/mypage">마이페이지</a>

			</c:if>
		</div>
	</div>

	<img src="/images/weapreciatepower.png" id="id1" width="500px">
	<a href="./qna/list">QNA</a>
	<div>
		<img src="/file/notice/neverfindmyplace.jpg">
 		<a href="/fileDown/qna?fileNum=13">QnaDown</a>
 		<a href="/fileDown/notice?fileNum=13">NoticeDown</a>
	</div>

	<button id="btn">CLICK</button>
	<button class="buttons">BTN1</button>
	<button class="buttons">BTN2</button>
	<button class="buttons">BTN3</button>
	
	<h1>${h}</h1>



<script type="text/javascript">
document.getElementById("id1").addEvent
</script>
</body>
</html>