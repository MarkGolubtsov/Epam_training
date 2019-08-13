let CONTAINER_ABOUT_USER="#dataUser";
let TRIGGER_USER_INFO_ID="#userInfo";
let CLASS_USERROLE_INFO='.UserRole';
let Id_CHANGE_ROLE='#changeRole';
let ID_TABLE_ORDERS='#TableOrders';
function  showInfo(user_id) {
    alert(user_id);
    $(CONTAINER_ABOUT_USER).empty();
    $(CONTAINER_ABOUT_USER).append("<div class='col s12'><div id='userInfo'>Personal data</div></div>");
    translateDate($(TRIGGER_USER_INFO_ID).text(),TRIGGER_USER_INFO_ID)
}


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