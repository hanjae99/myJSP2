function boardCheck(){
    if(document.frm.pass.value.length < 4){
        alert("비밀번호는 4글자 이상 입력해주세요.");
        frm.pass.focus();
        return false;
    }
    return true;
}

function open_win(url, name){
    window.open(url, name, "width=500, height=230");
}

function passCheck(){
    if (document.frm.pass.value.length == 0){
        alert("비밀번호를 입력해주세요.");
        return false;
    }
    return true;
}