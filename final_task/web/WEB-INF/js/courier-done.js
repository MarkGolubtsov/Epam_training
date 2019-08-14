
let ID_ORDER='#order';

function doneOrder(order_id,courier_id) {
    $.ajax({
        url:"/shop/DoneOrder",
        type:"POST",
        data:{
            courier_id:courier_id,
            order_id:order_id
        },
        success:function () {
          $(ID_ORDER+order_id).remove();
        }
    })
}