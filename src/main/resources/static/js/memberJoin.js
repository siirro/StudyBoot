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
    let result = nullCheck($("#id").val(), "#idLabel", "ID");
    results[0]=result;
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


idCheck.addEventListener("click",function(){
    console.log("중복확인")
    let userID = user_id.value;
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();
    //2.method,url 요청정보
    xhttp.open("POST","./ajaxID");
    //3.Enctype
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //4.post 파라미터 전송
    xhttp.send("user_id="+userID);
    //5.요청발생
    xhttp.onreadystatechange=function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            console.log(userID);
            console.log(xhttp.responseText);
            let result = xhttp.responseText.trim();

            if(result == 1){
                id_check.innerHTML ="중복된 아이디 입니다.";
                user_id.focus();
            }else{
                id_check.innerHTML = "사용 가능한 아이디 입니다.";
            }

        }
    }
})//ajaxID
