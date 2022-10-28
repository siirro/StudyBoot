<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<h1>Board Update Page</h1>
	
	<div>
		<form action="update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${vo.num}">
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<input name="title" value="${vo.title}" type="text" class="form-control" id="title" placeholder="제목을 입력하세요">
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<input name="writer" value="${vo.writer}" type="text" class="form-control" id="writer" placeholder="작성자를 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" id="summernote" name="contents"></textarea>
			</div>
			

			<div class="mb-3" id="fileBtnSpace" data-file-size="${vo.qnaFileVOs.size()}">
				<c:forEach items="${vo.qnaFileVOs}" var="fileVO">
					<p>${fileVO.oriName}
						<button type="button" data-file-num="${fileVO.fileNum}" class="deleteFile">X</button>
					</p>
				</c:forEach>
			</div>
			<div class="mb-3">
				<button type="button" id="fileBtn">FileAdd</button>
			</div>
			
			<button class="btn btn-primary" type="submit">작성</button>
		</form>
	</div>
	


<script>
$(document).ready(function () {
    $('#summernote').summernote({
        placeholder: '내용을 작성하세요',
        height: 250,
        maxHeight: 400
    });

	$('#summernote').summernote('code', '${vo.contents}')

	setCount('${vo.qnaFileVOs.size()}');
});

/* $('#contents').summernote({
    tabsize: 4,
    height: 250
  }); */
</script>


    
</body>
</html>