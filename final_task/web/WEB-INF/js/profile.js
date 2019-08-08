let ID_SAVE_BUTTON="#SaveButton";
let ID_NAME_INPUT="#name";
let ID_TELEPHONE_INPUT="#tel";
let ID_STREET_INPUT="#street";
let ID_HOUSE_INPUT="#house";
let ID_RESULT="#result";
$(document).ready(function(){
    $(ID_SAVE_BUTTON).click(function () {
        alert("Dap")
        let name =$(ID_NAME_INPUT).val();
        let tel =$(ID_TELEPHONE_INPUT).val();
        let house =$(ID_HOUSE_INPUT).val();
        let street =$(ID_STREET_INPUT).val();
        if (validateHouse(house) && validateTelephone(tel)) {
            $.ajax({
                url:'/shop/userSaveInfo',
                type:"POST",
                data: {
                    name:name,
                    tel:tel,
                    house:house,
                    street:street,
                },
                success: function () {
                    $(ID_RESULT).text("DONE");
                }
            })
        } else {
            $(ID_RESULT).text("No");
        }

    })
});

function validateHouse(house) {
   let res = house.search( /[a-zA-Z ]/);
   if ((res === -1)&& (house.length>0)) {
       return true;
   } else {
       return false;
   }
}
function validateTelephone(tel) {
    let res = tel[0]==='+';
    let re1 =tel.search( /[a-zA-Z ]/);
    if ((re1===-1) && res) {
        return true;
    } else {
        return false;
    }
}