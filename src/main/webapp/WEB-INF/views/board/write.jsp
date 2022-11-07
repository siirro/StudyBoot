<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer src="/js/fileManager.js"></script>

</head>
 <body>
	<h1>Board Write Page</h1>
	
	<div>
		<form:form modelAttribute="qnaVO" method="post" enctype="multipart/form-data">
			<sec:csrfInput/>
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<form:input path="title" cssClass="form-control" id="title" placeholder="제목을 입력하세요"/>
				<form:errors path="title"></form:errors>
				<!-- <input name="title" type="text" class="form-control" id="title" placeholder="제목을 입력하세요"> -->
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<input name="writer" type="text" class="form-control" id="writer" placeholder="작성자를 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" id="summernote" name="contents"></textarea>
			</div>

			<div class="mb-3" id="fileBtnSpace">

			</div>
			<div class="mb-3">
				<button type="button" id="fileBtn">FileAdd</button>
			</div>
			 
			<!-- <div class="mb-3">
				<label for="file" class="form-label">File</label>
				<input type="file" name="files">
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">File</label>
				<input type="file" name="files">
			</div> -->
			
			<button class="btn btn-primary" type="submit">작성</button>
		</form:form>
	</div>
	


<script>
$(document).ready(function () {
    $('#summernote').summernote({
        placeholder: '내용을 작성하세요',
        height: 400,
        maxHeight: 400
    });
});

/* $('#contents').summernote({
    tabsize: 4,
    height: 250
  }); */
</script>


    
</body>
</html>