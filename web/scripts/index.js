$(document).ready(function () {


    $("#singInForm").on('submit', function (event) {

        event.preventDefault();

        var errors = $("#errors");

        errors.empty();


        var isSubmit = true;




        if (isSubmit) {

            sendAddOrEditUserAsAjax();

        }


    });
});


function sendAddOrEditUserAsAjax() {

    $.post("LogIn", {

        email: $("#inputEmail").val(),
        password: $("#inputPassword").val(),
        rememberMe:$("input[type=checkbox]:checked").val()



    })
        .done(function (data) {
            if(data.resultCode==="SUCCESS"){

                //window.location.href = 'users.jsp';

            }else if(data.resultCode==="NO_SUCH_USER"){

                $("#errors").append("No Such User!");

            }else if(data.resultCode==="WRONG_PASSWORD"){

                $("#errors").append("Wrong password!");

            }

        })
        .fail(function () {
            alert("Fail. Try Again!")

        })

}