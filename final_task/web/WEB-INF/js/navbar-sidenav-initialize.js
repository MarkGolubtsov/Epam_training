$(document).ready(function(){
    $('.sidenav').sidenav({
        onOpenStart: function() {
            updateMobileCart()
        }
    });
});