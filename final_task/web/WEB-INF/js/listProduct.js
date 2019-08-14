
$(document).ready(function(){
    $('.filled-in').click(function () {
        $('.filled-in').not(this).prop('checked', false);
    });

    $("#icon_prefix").on("keyup", function() {
        let value = $(this).val().toLowerCase();
        $("#Container .card ").filter(function() {
            let nameSearch =$("#NameSearch").is(':checked');
            let costSearch =$("#costSearch").is(':checked');
            let typeSearch =$("#typeSearch").is(':checked');
            if (costSearch) $(this).toggle((this).getAttribute("costProduct").toLowerCase().indexOf(value) > -1)
            if (nameSearch) $(this).toggle($($(this).find("span[id*='card-title']")).text().toLowerCase().indexOf(value) > -1)
            if (typeSearch) $(this).toggle($($(this).find("p[id*='type']")).text().toLowerCase().indexOf(value) > -1)
        });
    });
})

function deleteProduct(product_id) {

}
// $(document).ready(function(){
//     $('input.autocomplete').autocomplete({
//         data: {
//         },
//     });
// });