<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
</head>
<body>
	<h1>Index page</h1>
	<img src="/images/weapreciatepower.png" id="id1">
	<a href="./qna/list">QNA</a>
	<div>
		<img src="/file/qna/3c9f8f5f-7e44-4049-930e-3cc7d0ad7881_title3.jpg">
		<img src="/file/notice/neverfindmyplace.jpg">
<!-- 		<a href="/fileDown/qna/2c4fff2f-7a95-40a9-ae37-8a8f9564ce61_weapreciatepower.png">이미지다운</a> -->		
 		<a href="/fileDown/qna?fileNum=13">QnaDown</a>
 		<a href="/fileDown/notice?fileNum=13">NoticeDown</a>
	</div>

<script type="text/javascript">
document.getElementById("id1").addEvent
</script>
</body>
</html>