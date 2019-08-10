let ATTRIBUTE_DATA_ORDER_ID="data-orderId";
let ATTRIBUTE_DATA_DELIVERY="data-delivery";
let ATTRIBUTE_DATA_TYPE_PAY="data-type-pay";
let ATTRIBUTE_DATA_TOTAL_PRICE="data-total_price";
let ID_CONTAINER_FOR_INFO='#info_abount_order';
let CLASS_MODAL_TRIGGER="secondary-content modal-trigger";
function addModal() {
   let elements=Array.from($("a[class='"+CLASS_MODAL_TRIGGER+"']"));
   elements.forEach(function (element) {
       let delivery =element.getAttribute(ATTRIBUTE_DATA_DELIVERY);
       let cost =element.getAttribute(ATTRIBUTE_DATA_TOTAL_PRICE);
       let pay =element.getAttribute(ATTRIBUTE_DATA_TYPE_PAY);
       let  id = element.getAttribute(ATTRIBUTE_DATA_ORDER_ID);
       $(ID_CONTAINER_FOR_INFO).append("\n" +
           "<div id=\"modal"+id+"\" class=\"modal\">\n" +
                "<div style='padding: 0px 40px 0px 40px' class=\"modal-content\">\n" +
                    "<div  style='overflow: hidden;'>\n" +
                        "<p class='constDelivery' style='float: left;margin:  5% 0% 0% 0%'>Delivery:</p>\n" +
                        "<p id='delivery"+id+"' style='float: left;margin:  5% 0% 0% 0%'>"+delivery+"</p>\n" +
                        "<p class='constTotal' style='float: left; margin: 5% 0% 0% 7%;';>Total:</p>\n" +
                        "<p style='float: left; margin: 5% 0% 0% 0%;';>"+cost+"  </p>\n" +
                        "<p class='constPay'style='float: left; margin: 5% 0% 0% 7%;' >Payment:</p>\n" +
                        "<p id='pay"+id+"' style='float: left; margin: 5% 0% 0% 0%;' >"+pay+"</p>\n" +
                    "</div>\n" +
                "</div>\n" +
           "<div style='padding: 0px 40px 0px 40px' id=\"listOrder"+id+"\">\n" +
           "</div>\n" +
           "<div class=\"modal-footer\">\n" +
           "    <a class=\"modal-close waves-effect waves-green btn-flat\">Close</a>\n" +
           "    </div>\n" +
           "    </div>");
       translateDate(delivery,'#delivery'+id);
       translateDate(pay,'#pay'+id);
       getOrderProduct(id);
   });
    translateDate('Delivery:','.constDelivery');
    translateDate('Total:','.constTotal');
    translateDate('Payment:','.constPay');
    translateDate('Name','.Name');
    translateDate('Amount of goods','.Count');
    translateDate('Cost of goods','.ItemCost');
    $('.modal').modal();
}
function getOrderProduct(order_id) {
    $.ajax({
        type:"POST",
        url:"/shop/getOrderProduct",
        data : {
            Order_id:order_id,
        },
        success:function (response) {
            let id ="#listOrder"+order_id;
            let list=$(id);
            list.append( "<table><thead><tr><th class='Name'>Name</th><th class='Count'>Count</th><th class='ItemCost'>Item Cost</th></tr></thead><tbody id='tbody"+order_id+"'></tbody> </table>");
            let id_tbody="#tbody"+order_id;
            let tbody=$(id_tbody);
           response.forEach(function (element) {
               let id=element.id;
               let count = element.count;
               let name = element.product.name;
               let cost = element.product.cost;
               tbody.append("<tr><td id='tdName"+id+"'>"+name+"</td><td>"+count+"</td><td>"+cost+"</td></tr>");
               translateDate(name,"#tdName"+id);
           })
        }
    })
}

$(document).ready(function(){
   addModal();
});