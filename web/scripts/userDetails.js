var allUsers;

$(document).ready(function () {




    $.get("users")
            .done(function (data) {
                //alert("done")
                if (data.resultCode === "SUCCESS") {


                    allUsers=data.data;


/*                    $.each(data.data, function (key, value) {

                    });*/


                }

            })
            .fail(function () {
                //alert("Fail. Try Again!")

            });


isInEditMode=$("#isInEditMode").val();

loadTeamsToDropdown();



    $("#addUserForm").on('submit', function (event) {

        event.preventDefault();

        var password = $("#inputPassword").val();
        var password2 = $("#inputPassword2").val();
        var email = $("#inputEmail").val();
        var phone = $("#inputPhone").val();


        var errors = $("#errors");

        errors.empty();


        var isSubmit = true;

        if (password !== password2) {
            errors.append("Passwords are not equal!");
            isSubmit = false;
        }


        $.each(allUsers, function (key, value) {

            if(isInEditMode && $("#userID").val()==value.id){
                //user must not be warned about his own email
                return true;
            }

            if(value.email===email){

                isSubmit=false;
                errors.append("This email is taken!");

            }

            if(value.phone===phone){
                isSubmit=false;
                errors.append("This phone is taken!");

            }

        });



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
        team: $("#team").val(),
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

function loadTeamsToDropdown() {

    $.get('Teams')
        .done(function (data) {
            if (data.resultCode === 'SUCCESS') {
                $.each(data.data, function (key, value) {
                    let option = '<option value=' + this.id + '>' + this.name + '</option>';
                    $('select#team').append(option);
                });

                if ($("#teamHelper").val()!=="") {
                    $('select#team').val($("#teamHelper").val());
                }
            }
        }).fail(function () {
        alert("Fail. Try Again!")
    });
}