$(document).ready(function(){
    $('.sidenav').sidenav({
        onOpenStart: function() {
            updateMobileCart()
        }
    });
    $(".RUS").on("click",function () {
        $.ajax({
            url:'/shop/SetRusLang',
            type:"POST",
            success: function () {
                location.reload(true);
            }
        })
    });
    $(".ENG").on("click",function () {
        $.ajax({
            url:'/shop/SetEngLang',
            type:"POST",
            success: function () {
                location.reload(true);
            }
        })
    })
});