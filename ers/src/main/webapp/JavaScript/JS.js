/**
 * Created by yst865 on 4/24/17.
 */

$(document).ready(function () {
    $('[data-toggle="popover"]').popover();

    $('[data-toggle="tooltip"]').tooltip();


    $('form#user').submit( function(e){
        e.preventDefault();


        $.ajax({
            method: "POST",
            url: "UpdatePersonalData",
            data: {
                username: $('#username').val(),
                firstname: $('#firstname').val(),
                lastname: $('#lastname').val(),
                email: $('#email').val()
            },
            success: function (data) {
                    $('#myModal').modal('show')},
            
           error:function (xhr, ajaxOptions, thrownError){
                    if(xhr.status==404) {
                    $('#myModal2').modal('show')}},

        });
    });
});


