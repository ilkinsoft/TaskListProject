$(document).ready(function () {

    $.get("users")
        .done(function (data) {
            //alert("done")
            if (data.resultCode === "SUCCESS") {
                $.each(data.data, function (key, value) {

                    var hour = value.createdAt.time.hour;
                    var min = value.createdAt.time.minute;
                    var team;

                    try {
                        team = value.team.name;
                    } catch (e) {
                        console.log(e);
                    }

                    if (hour.length === 1) {
                        hour = "0" + hour;
                    }

                    if (min.length === 1) {
                        min = "0" + min;
                    }

                    /*                    var backToDate = new Date(value.createdAt);
                                        console.log(value.createdAt);
                                        console.log(backToDate);*/

                    $("#listofusers").append("<tr>\n" +
                        "                        <td>\n" +
                        "                            <img src='./img/profile_pic_place_holder.jpg' alt=''>\n" +
                        "                            <a href='http://superhero.phoonio.com/users.html#' class='user-link'>" + value.firstName + " " + value.lastName + "</a>\n" +
                        "                            <span class='user-subhead'>" + value.role + "</span>\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            " + value.createdAt.date.month + "-" + value.createdAt.date.day + "-" + value.createdAt.date.year + " " + hour + ":" + min + "    \n" +
                        "                        </td>\n" +
                        "                        <td class='text-center'>\n" +
                        "                           " + value.phone + "\n" +
                        "                        </td>\n" +
                        "                        <td >\n" +
                        "                            " + team + "    \n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            " + value.email + "\n" +
                        "                        </td>\n" +
                        "                        <td style='width: 20%;'>\n" +

                        "                            <a id='"+value.id+"'  class='table-link editUser'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class='fa-stack'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-square fa-stack-2x'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-pencil fa-stack-1x fa-inverse'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                        "                            </a>\n" +
                        "                            <a id='"+value.id+"'  class='table-link danger deleteUser'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class='fa-stack'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-square fa-stack-2x'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-trash-o fa-stack-1x fa-inverse'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                        "                            </a>\n" +
                        "                        </td>\n" +
                        "                    </tr>")
                });


                $(".deleteUser").click(function () {
                    sendDeleteUserPost(this.id);
                });

                $(".editUser").click(function () {
                    sendGetUserPost(this.id);
                });


            }

        })
        .fail(function () {
            alert("Fail. Try Again!")

        });








    function sendDeleteUserPost(uID){

        $.post("DeleteUser", {
            userID:uID
        })
            .done(function () {
                location.reload();

            })
            .fail(function () {

            })

    }


    function sendGetUserPost(uID){

        $.post("GetUser", {
            userID:uID
        })
            .done(function (data) {

                $("#formUserID").val(uID);
                $("#formFirstName").val(data.data.firstName);
                $("#formLastName").val(data.data.lastName);
                $("#formEmail").val(data.data.email);
                $("#formPassword").val(data.data.password);
                $("#formPhone").val(data.data.phone);
                $("#formRole").val(data.data.role);



                $("#userDetailsForm").submit();



            })
            .fail(function () {

            })

    }




});