<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>

</head>
<body>
	<div class="container-fluid">
	<div class="row justify-content-center">
	<h1>List Page</h1>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.num}</td>
					<td>${list.title}</td>
					<td>${list.contents}</td>
					<td>${list.writer}</td>
					<td>${list.hit}</td>
					<td>${list.regDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<a href="./add" class="btn btn-danger">WRITE</a>
	</div>
	
	<form action="./list" method="get">
		<input name="search" value="${param.search}" type="text">
	</form>
	</div>
	</div>
	
	<!-- 페이지 -->
<%--     <div class="pagediv mt-3" style="display: flex; justify-content: center; ">
        <nav aria-label="Page navigation example">
            <ul class="pagination paginate_sm">

                <c:if test="${pager.pre}">
                    <li class="page-item"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">pre</a></li>
                </c:if>
                <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
                </c:forEach>
                <li class="page-item ${pager.next?'':'disabled'}"><a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">next</a></li>
            </ul>
        </nav>
    </div> --%>
	
	<script type="text/javascript">
		let result = '${param.result}';
		if(result != ""){
			if(result=='1'){
				alert('등록성공');
			}else {
				alert('등록실패');
			}
		}
	</script>
	
</body>
</html>