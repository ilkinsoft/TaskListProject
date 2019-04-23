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

                localStorage.setItem("email",$("#inputEmail").val());
                localStorage.setItem("role",data.data.role);
                localStorage.setItem("firstName",data.data.firstName);
                localStorage.setItem("lastName",data.data.lastName);
                localStorage.setItem("teamName",data.data.team.name);
                localStorage.setItem("teamID",data.data.team.id);


                window.location.href = 'tasks.jsp';

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