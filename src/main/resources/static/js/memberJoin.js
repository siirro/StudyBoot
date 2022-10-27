console.log("join");

$("#all").click(function(e){
    let ch = $(this).prop("checked");
    
    $(".check").prop("checked", ch);
})

$(".check").click(function(){

    // let flag = true;
    $("#all").prop("checked", true);

    $(".check").each(function(index, item){
        let ch = $(item).prop("checked");
        if(!ch){
            // flag = false;
            $("#all").prop("checked", false);
            return false;
        }
        console.log(ch);
    })

    // $("#all").prop("checked", flag);
    
})





//id, pw, pwEquals, name, email
let results = [false, false, false, false, false];

// ID Check
$("#id").keyup(function(){
    let id = $("#id").val();
    let result = nullCheck(id, "#idLabel", "ID");
    results[0]=result;
    console.log(result)
    //단 id가 비어있지 않을 때
    $.get("./idCheck?id="+id, function(data){
        console.log("Data : ", data);
        if(data=='0'){
            $("#idLabel").html("사용가능한 ID");
            results[0]=true;
        }else {
            $("#idLabel").html("이미 사용중인 ID 입니다");
            results[0]=false;
        }
    })
});

$("#pw").on({
    blur: function(){
        let result = nullCheck($("#pw").val(), "#pwLabel", "PW");
        results[1]=result;
        },
    change: function(){
        $("#pwCheck").val("");
        results[2]=false;
        $("#pwCheckLabel").html("");
    }
})

// PW Check
// $("#pw").keyup(function(){

//     let result = nullCheck($("#pw").val(), "#pwLabel", "PW");
//     let result2 = equals($("#pw").val(), $("#pwCheck").val());
//     if(result2){
//         $("#pwCheckLabel").text("비번이 일치한다");
//     }else{
//         $("#pwCheckLabel").text("불일치");
//     }

//     if(result){
//         results[1]=result2;
//         results[2]=result2;

//     }else{
//         results[1]=false;
//     }
// });

// PW 일치 Check
$("#pwCheck").keyup(function(){
    let result = equals($("#pw").val(), $("#pwCheck").val());
    if(result){
        $("#pwCheckLabel").text("비번이 일치한다");
    }else{
        $("#pwCheckLabel").text("불일치");
    }
    results[2]=result;
    results[1]=result;

});

$("#name").blur(function(){
    let result = nullCheck($("#name").val(), "#nameLabel", "이름");
    results[3]=result;
})

$("#email").blur(function(){
    let result = nullCheck($("#email").val(), "#emailLabel", "이메일");
    results[4]=result;
})



$("#joinButton").click(function(){
    

    //-------------인클루드를 사용!
    // if(results.includes(false)){
    //     alert("필수 입력은 다 입력해");
    // }else{
    //     alert("전송");
    // }
    //-------------인클루드를 사용!

    let c = true;
    let d = true;

    $.each(results, function(idx, item){
        console.log(item);

        if(!item){
            alert("필수 입력은 다 입력해");
            c=false;
            return false;
        }

    })

    if($("#all").prop("checked")){
        d=true;
    }else{
        alert("필수 동의 약관에 체크해주세요.")
        d=false;
    }

    if(c){
        if(d){
        $("#joinForm").submit();
        }
    }
});






// JqueryAjax 브랜치에 있어야할것들.. 인데 나는 마스터에다가 걍함 221027

$("#test").click(function(){
    let id="123";
    let name="iu";

    $.post("./test", {
        id: id,
        name: name
    },function(result){
        console.log("Result : ", result);
        // "{키:밸류}"
        // 
        // result = JSON.parse(result);
        console.log("Name : ", result.name);
    });
});

$("#test2").click(function(){
    let id = "abcd";
    $.ajax({
        type: "GET",
        url: "idCheck",
        data:{
            id:id
        },
        success:function(data){
            console.log("Data : ", data);
        },
        error:function(xhr, status, error){
            console.log("Xhr : ", xhr);
            console.log("Status : ", status);
            console.log("Error : ", error);
        }
    })
});

$("#test3").click(function(){
    let id = "1234";
    let name = "iu";
    let ar = [1, 2, 3];
    $.ajax({
        type: "POST",
        url: "test",
        traditional:true, //배열을 전송할 때 사용, true 주면 끝.
        data: {
            id: id,
            name: name,
            ar: ar
        },
        success:function(result){
            console.log("result : ", result);
        }
    });
});
let count = 3;
$("#s1Add").click(function(){
    console.log(count);
    let add = '<option class="abc" id="abc'+count+'">'+count+'</option>';
    $("#s1").append(add);
    count++;
    console.log(count);

});

$("#s1").click(function(){
    $("#s1").empty();
});

