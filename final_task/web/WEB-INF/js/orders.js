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
                        "<p style='float: left;margin:  5% 0% 0% 0%'>Delivery:"+delivery+"</p>\n" +
                        "<p style='float: left; margin: 5% 0% 0% 7%;';>Final Cost:"+cost+"  </p>\n" +
                        "<p style='float: left; margin: 5% 0% 0% 7%;' >Pay:"+pay+"</p>\n" +
                    "</div>\n" +
                "</div>\n" +
           "<div style='padding: 0px 40px 0px 40px' id=\"listOrder"+id+"\">\n" +
           "</div>\n" +
           "<div class=\"modal-footer\">\n" +
           "    <a  class=\"modal-close waves-effect waves-green btn-flat\">Close</a>\n" +
           "    </div>\n" +
           "    </div>");
       getOrderProduct(id);
   });
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
            list.append( "<table><thead><tr><th>Name</th><th>Count</th><th>Item Cost</th></tr></thead><tbody id='tbody"+order_id+"'></tbody> </table>");
            let id_tbody="#tbody"+order_id;
            let tbody=$(id_tbody);
           response.forEach(function (element) {
               let count = element.count;
               let name = element.product.name;
               let cost = element.product.cost;
               tbody.append("<tr><td>"+name+"</td><td>"+count+"</td><td>"+cost+"</td></tr>");
           })
        }
    })
}

$(document).ready(function(){
   addModal();
});