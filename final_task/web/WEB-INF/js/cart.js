
let ID_CART_NAVBAR="#itemCount";
let ID_CART_MOBILE_NAVBAR="#itemCountMobile";
let ID_CARD_BEGIN="#card";
let ID_COUNT_RECORD_BEGIN="#count";


let BEGIN_ID_CHECKBOX="#choseProduct";
let ATTRIBUTE_DATA_ID_PRODUCT_IN_CHECKBOX="data_id_product";
let ATTRIBUTE_DATA_ID_PRODUCT_CHOSE_IN_CHECKBOX="data_id_chose_product";
let ID_ORDER_COST='#OrderCost';
let ATTRIBUTE_COUNT="countProduct";
let ATTRIBUTE_COST="costProduct";
let ATTRIBUTE_ID_CHOSEPRODUCT_IN_CARD="choseProductId";

let ID_CHECKBOX_PICKUP="#type_delivery_pickup";
let ID_CHECKBOX_COURIER="#type_delivery_courier";
let ID_CHECKBOX_CASH="#type_pay_cash";
let ID_CHECKBOX_CASHLESS="#type_pay_cashless";
let order = {
    user_id: null,
    chose_product:[],
    type_pay:"CASH",
    delivery_type:'PICKUP',
    final_cost:0.0
};


function addEventOnButtonRemoveInCart(idProduct, idChoseProduct) {
    let idRecordCountProduct=ID_COUNT_RECORD_BEGIN+idProduct;
    let idCard=ID_CARD_BEGIN+idProduct;
    let idChoseBox=BEGIN_ID_CHECKBOX+idChoseProduct;
        $.ajax({
            type:"POST",
            url : '/shop/removeOutCart',
            data : {
                idProduct :idProduct,
                idChoseProduct: idChoseProduct
            },
            success:function (response) {
                let  countProductInCart = $(ID_CART_NAVBAR).text();
                countProductInCart--;
                $(ID_CART_NAVBAR).text(countProductInCart);
                $(idRecordCountProduct).text(response);

                let element=$(idChoseBox);
               // if (positionInOrder(idChoseProduct)!=-1) {
                if (positionInOrder(idChoseProduct)>=0) {
                    let chose_product_id=element.attr(ATTRIBUTE_ID_CHOSEPRODUCT_IN_CARD);
                    let cost=element.attr(ATTRIBUTE_COST);
                    order.final_cost=order.final_cost-cost;
                    $(ID_ORDER_COST).text(order.final_cost);
                    if (Number(response)===0) {
                        let position= positionInOrder(chose_product_id);
                        console.log("position"+position);
                        order.chose_product.splice(position,1);
                    }

                }

                if (Number(response)===0){
                    $(idCard).remove();
                }

            }
        });
}
function addEventOnButtonAddInCart(idProduct,idChoseProduct){
    let idCountProduct=ID_COUNT_RECORD_BEGIN+idProduct;
    let idChoseBox=BEGIN_ID_CHECKBOX+idChoseProduct;
        $.ajax({
            type:"POST",
            url : '/shop/addInCart',
            data : {
                idProduct :idProduct
            },
            success:function (response) {
                let  countProductInCart = $(ID_CART_NAVBAR).text();
                countProductInCart++;
                $(ID_CART_NAVBAR).text(countProductInCart);
                $(idCountProduct).text(response);
                let element=$(idChoseBox);
                if (positionInOrder(idChoseProduct)>=0)
                //if (positionInOrder(idChoseProduct)!=-1)
                {
                    console.log("in add");
                    let cost=element.attr(ATTRIBUTE_COST);
                    console.log("cost="+cost);
                    order.final_cost=Number(order.final_cost)+Number(cost);
                    $(ID_ORDER_COST).text(order.final_cost);
                }
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
            $($)
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

function createOrder(id) {
    order.user_id=id;
    if (order.chose_product.length!==0){
        $.ajax({
            type:"POST",
            url : '/shop/createOrder',
            data: {order:JSON.stringify(order)},
            success : function () {
                console.log("remove");
                order.chose_product.forEach(function (element) {
                    $("div[choseProductId*="+element+"]").remove();
                });
               order.chose_product=[];
               order.final_cost=0.0;
               $(ID_ORDER_COST).text(order.final_cost);
               updateCart();
            }
        })
    }
}
function positionInOrder(chose_product_id) {
    let result=-1;
    let i=0;
    order.chose_product.forEach(function (element) {
        if (element==chose_product_id){
            result=true;
            result=i;
        }
        i=i+1;
    })
    return result;
}

function delivery_type_set_only_one() {
    $("input[id*='type_delivery_']").click(function() {
        $("input[id*='type_delivery_']").not(this).prop('checked', false);
    });
}
function type_pay_only_one() {
    $("input[id*='type_pay_']").click(function() {
        $("input[id*='type_pay_']").not(this).prop('checked', false);
    });
}
function onPickUpChecked() {
    $(ID_CHECKBOX_PICKUP).on('change', function(){
        if(this.checked)
        {
           order.delivery_type="PICKUP";
        }
    })
}
function onCourierChecked() {
    $(ID_CHECKBOX_COURIER).on('change', function(){
        if(this.checked)
        {
            order.delivery_type="COURIER";
        }
    })
}
function onCashCheck() {
    $(ID_CHECKBOX_CASH).on('change', function(){
        if(this.checked)
        {
            order.type_pay="CASH";
        }
    })
}
function onCashlessCheck() {
    $(ID_CHECKBOX_CASHLESS).on('change', function(){
        if(this.checked)
        {
            order.type_pay="CASHLESS";
        }
    })
}
$(document).ready(function(){
    delivery_type_set_only_one();
    type_pay_only_one();
    updateCart();
    onPickUpChecked();
    onCourierChecked();
    onCashCheck();
    onCashlessCheck();
    $("input[id*='choseProduct']").on('change', function(){ // on change of state
        let chose_product_id=this.getAttribute(ATTRIBUTE_DATA_ID_PRODUCT_CHOSE_IN_CHECKBOX);
        let product_id=this.getAttribute(ATTRIBUTE_DATA_ID_PRODUCT_IN_CHECKBOX);
        let cost=this.getAttribute(ATTRIBUTE_COST);
        let count=$(ID_COUNT_RECORD_BEGIN+product_id).text();
        if(this.checked)
        {
            order.chose_product.push(chose_product_id);
            order.final_cost=order.final_cost+cost*count;
            $(ID_ORDER_COST).text(order.final_cost);
            console.log(order.toString());
        } else{
            if (!this.check){
                order.final_cost=order.final_cost-cost*count;
                $(ID_ORDER_COST).text(order.final_cost);
                let position=positionInOrder(chose_product_id);
                order.chose_product.splice(position,1);
                console.log(order.toString());
            }
        }
        console.log(order)
    });
});