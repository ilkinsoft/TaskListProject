$(document).ready(function () {



    $("#addUserForm").on('submit', function (event) {

        event.preventDefault();

        var password = $("#inputPassword").val();
        var password2 = $("#inputPassword2").val();
        var errors = $("#errors");

        errors.empty();


        var isSubmit = true;

        if (password !== password2) {
            errors.append("Passwords are not equal!");
            isSubmit = false;
        }


        if (isSubmit) {
            sendFormAsAjax();
        }


    });


});

function sendFormAsAjax() {
    $.post("AddUser", {
        firstName: $("#inputFirstName").val(),
        lastName: $("#inputLastName").val(),
        email: $("#inputEmail").val(),
        password: $("#inputPassword").val(),
        phone: $("#inputPhone").val(),
        role: $("#role").val()


    })
        .done(function (data) {
            //alert("done")
            if(data.resultCode==="SUCCESS"){
                window.location.href = '';
            }

        })
        .fail(function () {
            alert("Fail. Try Again!")

        })

}