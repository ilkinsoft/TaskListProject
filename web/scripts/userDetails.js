$(document).ready(function () {


isInEditMode=$("#isInEditMode").val();



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

            sendAddOrEditUserAsAjax();

        }


    });

    if ($("#roleHelper").val()!=="") {
        $("#role").val($("#roleHelper").val());
    }

    if (isInEditMode==="1") {
        $("#sendButton").text("Edit User");
        $("#titleOfForm").text("Edit User");

    }



/*    $("#roleHelper").change(function () {
        alert();
    });

    $("#inputPhone").change(function () {
        alert();
    });*/



});

function sendAddOrEditUserAsAjax() {
    var url;

    if(isInEditMode==="1"){
        url="EditUser";
    }else{
        url="AddUser";
    }

    $.post(url, {
        userID:$("#userID").val(),
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
                window.location.href = 'users.jsp';
            }

        })
        .fail(function () {
            alert("Fail. Try Again!")

        })

}