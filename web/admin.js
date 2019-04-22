$(document).ready(function(){
    $(".add-row").click(function(){
        var name = $("#name").val();
        var email = $("#email").val();
        var tel = $("#tel").val();
        var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + name + "</td><td>" + email + "</td><td>"+tel+"</td></tr>";
        $("table tbody").append(markup);
    });

    // Find and remove selected table rows
    $(".delete-row").click(function(){
        $("table tbody").find('input[name="record"]').each(function(){
            if($(this).is(":checked")){
                $(this).parents("tr").remove();
            }
        });
    });


    $("td").dblclick(function () {
        var OriginalContent = $(this).text();

        var inputNewText = prompt("Enter new content for:", OriginalContent);

        if (inputNewText != null) {
            $(this).text(inputNewText)
        }
    });

});