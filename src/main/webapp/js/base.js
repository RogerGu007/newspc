$(function(){

    //下拉菜单处理
    var profile = $("#profile");
    var downMenu = $("#down-menu");

    profile.mouseover(function(){
        downMenu.show();
        $(this).css("background-color","#333");
    }).mouseout(function(){
        downMenu.hide();
        $(this).css("background-color","#3d444c");
    });

    downMenu.mouseover(function(){
        downMenu.show();
    }).mouseout(function(){
        downMenu.hide();
    });
});


function setCookie(name,value,time){
    var exp = new Date();//new Date("December 31, 9998");
    exp.setTime(exp.getTime() + time);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

function getCookie(name){
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) {
        return unescape(arr[2]);
    }
    return null;
}

//删除cookie
function delCookie(name){
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function clearAllCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if(keys) {
        for(var i = keys.length; i--;)
            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
    }
}