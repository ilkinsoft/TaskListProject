$(document).ready(function () {

    $.get("users")
        .done(function (data) {
            //alert("done")
            if(data.resultCode==="SUCCESS"){
                $.each( data.data, function( key, value ) {
                    $("#listofusers").append("<tr>\n" +
                        "                        <td>\n" +
                        "                            <img src='./img/profile_pic_place_holder.jpg' alt=''>\n" +
                        "                            <a href='http://superhero.phoonio.com/users.html#' class='user-link'>"+value.firstName+" "+value.lastName+"</a>\n" +
                        "                            <span class='user-subhead'>"+value.role+"</span>\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            2013/08/08\n" +
                        "                        </td>\n" +
                        "                        <td class='text-center'>\n" +
                        "                            <span class='label label-default'>Inactive</span>\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            <a href='http://superhero.phoonio.com/users.html#'>"+value.email+"</a>\n" +
                        "                        </td>\n" +
                        "                        <td style='width: 20%;'>\n" +
                        "                            <a href='http://superhero.phoonio.com/users.html#' class='table-link'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class='fa-stack'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-square fa-stack-2x'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-search-plus fa-stack-1x fa-inverse'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                        "                            </a>\n" +
                        "                            <a href='http://superhero.phoonio.com/users.html#' class='table-link'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class='fa-stack'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-square fa-stack-2x'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-pencil fa-stack-1x fa-inverse'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                        "                            </a>\n" +
                        "                            <a href='http://superhero.phoonio.com/users.html#' class='table-link danger'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class='fa-stack'>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-square fa-stack-2x'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class='fa fa-trash-o fa-stack-1x fa-inverse'></i>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                        "                            </a>\n" +
                        "                        </td>\n" +
                        "                    </tr>")
                });


            }

        })
        .fail(function () {
            alert("Fail. Try Again!")

        })



});