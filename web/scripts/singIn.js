$(document).ready(function () {
    $("#singInForm").on('submit', function (event) {

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

            sendAddOrEditUserAsAjax();

        }


    });
});