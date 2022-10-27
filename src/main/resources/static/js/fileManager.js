let count = 0;
$("#fileBtn").click(function(){
    if(count<5) {
        let add = '<div class="mb-3">';
        add = add+'<label for="file" class="form-label">File</label>';
        add = add+'<input type="file" name="files">';
        add = add+'<button type="button" class="del">X</button>';
        add = add+'</div>';
        
        $("#fileBtnSpace").append(add);
        count++;
    }else{
        alert("파일 5개 까지만 가능");
    }
});

$("#fileBtnSpace").on("click", ".del", function(){
    $(this).parent().remove();
    count--;
});

$(".deleteFile").click(function(){
    //DB, HDD에 파일 삭제
    let check = confirm("삭제 됩니다.. 복구 불가");

    if(check){
        let fileNum = $(this).attr("data-file-num");
        console.log("Before Result This : ", $(this))
        const btn = $(this);
        $.ajax({
            type: "POST",
            url: "fileDelete",
            data: {
                fileNum: fileNum
            },
            success: function(result){
                console.log("Result : ", result)
                console.log("After Result This : ", $(this))
                $(btn).parent().remove();
            },
            error: function(){
                console.log("Error 발생");
            }
        });
    }
});