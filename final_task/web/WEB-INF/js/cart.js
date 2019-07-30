
let ID_CART_NAVBAR="#itemCount";
let ID_CART_MOBILE_NAVBAR="#itemCountMobile";
let ID_CARD_BEGIN="#card";
let ID_COUNT_RECORD_BEGIN="#count";
function addEventOnButtonRemoveInCart(idProduct) {
    let idRecordCountProduct=ID_COUNT_RECORD_BEGIN+idProduct;
    let idCard=ID_CARD_BEGIN+idProduct;
        $.ajax({
            type:"POST",
            url : '/shop/removeOutCart',
            data : {
                idProduct :idProduct
            },
            success:function (response) {
                let  countProductInCart = $(ID_CART_NAVBAR).text();
                countProductInCart--;
                $(ID_CART_NAVBAR).text(countProductInCart);
                $(idRecordCountProduct).text(response);
                if (response==0){
                    $(idCard).remove();
                }
            }
        });
}
function addEventOnButtonAddInCart(idProduct){
    let idCountProduct=ID_COUNT_RECORD_BEGIN+idProduct;
        $.ajax({
            type:"POST",
            url : '/shop/addInCart',
            data : {
                idProduct :idProduct
            },
            success:function (response) {
                console.log(response);
                let  countProductInCart = $(ID_CART_NAVBAR).text();
                countProductInCart++;
                $(ID_CART_NAVBAR).text(countProductInCart);
                $(idCountProduct).text(response);
            }
            // error: error()
        });
}

function addEventOnButtonAdd(idProduct){
    $.ajax({
        type:"POST",
        url : '/shop/addInCart',
        data : {
            idProduct :idProduct
        },
        success:function (response) {
            console.log(response);
            let  countProductInCart = $(ID_CART_NAVBAR).text();
            countProductInCart++;
            $(ID_CART_NAVBAR).text(countProductInCart);
        }
        // error: error()
    });
}
function updateMobileCart() {
    $.ajax({
        type:"POST",
        url : '/shop/getCountProductInCart',
        success:function (response) {
            $(ID_CART_MOBILE_NAVBAR).text(response);
        }
    });
}
function updateCart() {
    $.ajax({
        type:"POST",
        url : '/shop/getCountProductInCart',
        success:function (response) {
            $(ID_CART_NAVBAR).text(response);
        }
    });
}

$(document).ready(function(){
    updateCart();
});

