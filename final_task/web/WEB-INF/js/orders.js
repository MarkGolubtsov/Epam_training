

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
       $(ID_CONTAINER_FOR_INFO).append("\n" +
           "<div id=\"modal"+element.getAttribute(ATTRIBUTE_DATA_ORDER_ID)+"\" class=\"modal\">\n" +
           "    <div class=\"modal-content\">\n" +
           "<p>Delivery:"+delivery+"</p>\n" +
           "<p>Cost:"+cost+"</p>\n" +
           "<p>Pay:"+pay+"</p>\n" +
           "</div>\n" +
           "<div class=\"modal-footer\">\n" +
           "    <a  class=\"modal-close waves-effect waves-green btn-flat\">Close</a>\n" +
           "    </div>\n" +
           "    </div>");
   });
    $('.modal').modal();
}

$(document).ready(function(){
   addModal();
});