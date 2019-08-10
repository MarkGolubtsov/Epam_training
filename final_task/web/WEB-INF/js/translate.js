function  translate(text,lang,id) {
    $.ajax({
        type: "POST",
        url:'https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20140730T105810Z.a8bb36f8d87c6f11.b4912cbf0f1e4dbe9c51f28c272521b0af68ba42&text=' + text + '&lang=' + lang,
        success:function (response) {
           $(id).text(response.text[0]);
        }
        })
}
function translateDate(text,id) {
    $.ajax({
        url:"/shop/GetLang",
        type: "POST",
        success : function (response) {
            let res = response;
            if(response=='') {
                var userLang = navigator.language || navigator.userLanguage;
                res=userLang;
            }
            translate(text,res,id);
        }
    })

}