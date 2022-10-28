let count = 0;

function setCount(c){
    if(c<1 || c>5){
        c=1
    }
    count=c;
}
let flag=true;

$("#fileBtn").click(function(){

    if(flag) {
        let size = $("#fileBtnSpace").attr("data-file-size")
        console.log(size);
        if(size==undefined){
            size=0;
        }
        count=size;
        flag=false;    
    }

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

// 글 수정시 첨부파일 삭제
$(".deleteFile").click(function(){
    //DB, HDD에 파일 삭제
    let check = confirm("삭제 됩니다.. 복구 불가");

    if(flag) {
        let size = $("#fileBtnSpace").attr("data-file-size");
        if(size==undefined){
            size=0;
        }
        count=size;
        flag=false;
    }
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
                count--;
            },
            error: function(){
                console.log("Error 발생");
            }
        });
    }
});