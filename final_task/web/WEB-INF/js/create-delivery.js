let DATA_ORDER='data-order-id';
let DATA_USER='data-user-id';
let DATA_COURIER='data-courier-id';
let ID_INFO='#infoOrder';
let DELIVERY_ORDER_ID='#order_id';
let DELIVERY_USER_ID='#user_id';
let DELIVERY_COURIER_ID='#courier_id';
let ID_TR='#tr'
function addAdress(order_id,user_id) {
    $.ajax({
        type:"POST",
        url:"/shop/GetAddressOrders",
        data : {
            user_id:user_id,
        },
        success:function(res) {
            $('#delivery'+order_id).remove();
            $('.constDelivery').remove();
            $('.constTotal').css('margin','5% 0% 0% 9%')
            $(ID_INFO+order_id).append(
                "<p class='Street'style='float: left; margin: 5% 0% 0% 7%;' ><fmt:message key='Street' bundle='${value}'/>:</p>\n" +
                "<p id='street"+order_id+"' style='float: left; margin: 5% 0% 0% 0%;' >"+res.street+"</p>" +
                "<p class='House'style='float: left; margin: 5% 0% 0% 7%;' >  <fmt:message key='House' bundle='${value}'/>:</p>\n" +
                "<p id='House"+order_id+"' style='float: left; margin: 5% 0% 0% 0%;' >"+res.house+"</p>"
            )
        }
    })
}




function onOrderChecked() {
    $("input[id*='addOrder']").on('change', function(){
        if(this.checked)
        {
            let order_id =$(this).attr(DATA_ORDER);
            let user_id =$(this).attr(DATA_USER);

            $(DELIVERY_ORDER_ID).text(order_id);
            $(DELIVERY_USER_ID).text(user_id);
        } else {
            if (!this.check) {
                let res=[]
                $("input[id*='addOrder']").each(function () {
                    (this.checked ? res.push(1) : '');

                });
                if (res.length<1) {
                    $(DELIVERY_ORDER_ID).text("");
                    $(DELIVERY_USER_ID).text("");
                }
            }
        }
    })
}
function onCourierChecked() {
    $("input[id*='addCourier']").on('change', function(){
        if(this.checked)
        {
            let courier_id =$(this).attr(DATA_COURIER);
            $(DELIVERY_COURIER_ID).text(courier_id);
        } else {
            if (!this.check) {
                let res=[]
                $("input[id*='addCourier']").each(function () {
                    (this.checked ? res.push(1) : '');

                });
                if (res.length<1) {
                    $(DELIVERY_COURIER_ID).text("");
                }
            }
        }
    })
}

function onlyOneOrder() {
        $("input[id*='addOrder']").click(function() {
            $("input[id*='addOrder']").not(this).prop('checked', false);
        });

}
function onlyOneCourier() {
    $("input[id*='addCourier']").click(function() {
        $("input[id*='addCourier']").not(this).prop('checked', false);
    });

}
function createDelivery() {
    let courier_id =$(DELIVERY_COURIER_ID).text();
    let user_id =$(DELIVERY_USER_ID).text();
    let order_id =$(DELIVERY_ORDER_ID).text();

    if ( (courier_id>0) && (user_id>0) && (order_id>0)) {
            $.ajax({
                url:'/shop/CreateDelivery',
                type: "POST",
                data: {
                    courier_id:courier_id,
                    user_id:user_id,
                    order_id:order_id,
                },
                success:function () {
                    $(ID_TR+order_id).remove();
                   $(DELIVERY_USER_ID).text("");
                    $(DELIVERY_ORDER_ID).text("");
                }
            })
    }
}
$(document).ready(function(){
    onlyOneOrder();
    onOrderChecked();
    onlyOneCourier();
    onCourierChecked();
});