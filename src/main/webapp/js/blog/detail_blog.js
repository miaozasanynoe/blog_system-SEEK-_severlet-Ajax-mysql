function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return unescape(r[2]); return null;
 }
 function addDynamicJS(src, callback) {
    var script = document.createElement("script");
    script.setAttribute("type", "text/javascript");
    script.src = src;
    script.charset = 'utf-8';
    document.body.appendChild(script);
    if (callback != undefined) {
        script.onload = function () {
            callback();
        }
    }
}
var artjs='';
$(document).ready(function(){
    console.log(GetQueryString('contenturl'));
    addDynamicJS(GetQueryString('contenturl'), function () {
    alert(ffff)
    $("#art_main").prepend(decodeURI(artjs));
    $("#date").append(GetQueryString('date'));
    $("#user").append(GetQueryString('user'));
    $("#title_1").prepend(decodeURI(GetQueryString('title')));
    alert(GetQueryString('title'));
    });
});