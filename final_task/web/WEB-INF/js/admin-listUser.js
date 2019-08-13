
let CLASS_USERROLE_INFO='.UserRole';
let Id_CHANGE_ROLE='#changeRole';
let ID_TABLE_ORDERS='#TableOrders';
let ID_TABLE_DELIVERIES='#TableDeliveries'


function makeAdmin(user_id) {
    let change=CLASS_USERROLE_INFO+user_id;
    $.ajax({
        url: '/shop/MakeAdmin',
        type:"POST",
        data: {
            user_id:user_id
        },
        success: function () {
            $(change).text('ADMIN');
            $(Id_CHANGE_ROLE+user_id).empty();
        }
    })
}
function makeUser(user_id) {
    let change=CLASS_USERROLE_INFO+user_id;
    $.ajax({
        url: '/shop/MakeUser',
        type:"POST",
        data: {
            user_id:user_id
        },
        success: function () {
            $(change).text('USER');
            $(Id_CHANGE_ROLE+user_id).append(' <div id="butCourier'+user_id+'" class="col s3">\n' +
                '<a  onclick="makeCourier('+user_id+')"class="waves-effect waves-light btn-small blue"><fmt:message key="MakeCourier" bundle="${value}"/></a>\n' +
                '</div>');
            $('#butUser'+user_id).remove();
        }
    })
}
function makeCourier(user_id) {
    let change=CLASS_USERROLE_INFO+user_id;
    $.ajax({
        url: '/shop/MakeCourier',
        type:"POST",
        data: {
            user_id:user_id
        },
        success: function () {
            $(change).text('COURIER');
            $(Id_CHANGE_ROLE+user_id).append('  <div id="butUser'+user_id+'" class="col s3">\n' +
                '<a  onclick="makeUser('+user_id+')"class="waves-effect waves-light btn-small blue"><fmt:message key="MakeUser" bundle="${value}"/></a>\n' +
                '</div>');
            $('#butCourier'+user_id).remove();
        }
    })
}

function getOrders(user_id) {
    $.ajax({
        type:"POST",
        url:"/shop/GetUserOrders",
        data : {
            user_id:user_id,
        },
        success:function (response) {
            let list=$('#bodyOrders'+user_id);
            response.forEach(function (element) {
                let id=element.id;
                let delivery = element.delivery;
                let total = element.total_price;
                let typePay = element.type_pay;
                list.append("<tr id='lineOrder"+id+"'><td>"+id+"</td><td id='delivery"+id+"'>"+delivery+"</td><td id='typePay"+id+"'>"+typePay+"</td><td>"+total+"</td><td><i style='cursor: pointer;' onclick='deleteOrder("+id+")' class='material-icons align center '>delete_forever</i></td></tr>");
                translateDate(delivery,"#delivery"+id);
                translateDate(typePay,"#typePay"+id);
            })
        }
    })
}
function deleteOrder(order_id) {
    $.ajax({
        type:"POST",
        url:"/shop/DeleteOrder",
        data:{
            order_id:order_id
        },
        success:function () {
          $('#lineOrder'+order_id).remove();
        }
    })
}
function checkAvailabilityOrders(user_id) {
    $.ajax({
        type:"POST",
        url:"/shop/CheckAvailabilityOrder",
        data:{
            user_id:user_id
        },
        success:function (response) {
            if (response=='no'){
                $(ID_TABLE_ORDERS+user_id).remove();
            }
        }
    })
}

function checkAvailabilityDeliveries(courier_id) {
    $.ajax({
        type:"POST",
        url:"/shop/CheckAvailabilityDeliveries",
        data:{
            courier_id:courier_id
        },
        success:function (response) {
            if (response=='no'){
                $(ID_TABLE_DELIVERIES+courier_id).remove();
            }
        }
    })
}

function getDelivery(courier_id) {
    $.ajax({
        type:"POST",
        url:"/shop/GetDeliveryCourier",
        data: {
            courier_id:courier_id
        },
        success:function (response) {
            let list=$('#bodyDeliveries'+courier_id);
            response.forEach(function (element) {
             let user_id=element.user.id;
             let user_tel=element.user.telephone;
             let order_id=element.order.id;
             let cost=element.order.total_price;
             list.append("<tr id='lineDelivery"+order_id+"'><td>"+order_id+"</td><td>"+user_id+"</td><td>"+user_tel+"</td><td>"+cost+"</td><td><i style='cursor: pointer;' onclick='deleteDelivery("+order_id+","+courier_id+")' class='material-icons align center '>delete_forever</i></td></tr>");
         })
        }
    })
}
function deleteDelivery(order_id,courier_id) {
    $.ajax({
        type:"POST",
        url:"/shop/DeleteDelivery",
        data: {
            order_id:order_id,
            courier_id:courier_id
        },
        success:function () {
            $('#lineDelivery'+order_id).remove();
        }
    })
}