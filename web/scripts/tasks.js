$(document).ready(function () {
    $('#btnAddTask').click(function () {
        $('#addForm').fadeIn();
    })


    $("#addForm").on('submit', function (e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.

        let form = $(this);
        let url = form.attr('action');

        let task = {};
        task.textOfTask = $('#textOfTask').val();
        task.assignedTo = $('#assignedTo').val();
        task.createdBy = $('#createdBy').val();
        task.isDone = $('#isDone').val();
        task.dueDate = $('#dueDate').val();
        task.priority = $('#priority').val();
        console.log(JSON.stringify(task))

        $.post(url, {
            textOfTask: $('#textOfTask').val(),
            assignedTo: $('#assignedTo').val(),
            createdBy: $('#createdBy').val(),
            isDone: $('#isDone').val(),
            dueDate: $('#dueDate').val(),
            priority: $('#priority').val()

        }).done(function (data) {
                if (data.resultCode === "SUCCESS") {
                    alert("Task added.")
                    $('#addForm').fadeOut();
                }
                else {
                    alert("Failed.")
                }
            })
            .fail(function () {
                alert("Fail. Try Again!")
            });
    });

})

