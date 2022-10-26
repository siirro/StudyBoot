function nullCheck(data, dest, kind){
    if(data == null || data==''){
        $(dest).html(kind+" 입력은 필수입니다");
        return false;
    }else{
        $(dest).html(kind+" 정상입니다");
        return true;
    }
}

function equals(data, check){
    if(data == check){
        return true;
    }else{
        return false;
    }
}