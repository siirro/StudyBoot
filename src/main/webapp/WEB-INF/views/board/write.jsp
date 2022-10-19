<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/boot.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
 <body>
	<h1>Board Write Page</h1>
	
	<div>
		<form action="add" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<input name="title" type="text" class="form-control" id="title" placeholder="제목을 입력하세요">
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<input name="writer" type="text" class="form-control" id="writer" placeholder="작성자를 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea id="summernote" name="contents"></textarea>
			</div>
			 
			<div class="mb-3">
				<label for="file" class="form-label">File</label>
				<input type="file" name="files">
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">File</label>
				<input type="file" name="files">
			</div>
			
			<button class="btn btn-primary" type="submit">작성</button>
		</form>
	</div>
	
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>


<script>
$(document).ready(function () {
    $('#summernote').summernote({
        placeholder: '내용을 작성하세요',
        height: 400,
        maxHeight: 400
    });
});
</script>


    
</body>
</html>