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
                loadEntities();
            } else {
                alert("Failed.")
            }
        })
            .fail(function () {
                alert("Fail. Try Again!")
            });
    });

})

function loadEntities() {
    $.get('Tasks')
        .done(function (data) {
            console.log(data)
            $.each(function (key, value) {
                console.log(value);
            })

        // let html =
        // '<div class="alert alert-primary" role="alert">' +
        //         '<div class="float-left">Assigned to:' +
        //         '<%=taskList.get(i).getAssignedTo().getFirstName()%>' +
        //         '</div>' +
        //         '<div class="float-right">' +
        //         'Mark as done: <input type="checkbox" aria-label="Mark as done">' +
        //         '</div>' +
        //
        //         '<div class="alert-link" style="clear:both">' +
        //     // <%=taskList.get(i).getTextOfTask()%>
        //         '</div>' +
        //         '<div class="row">' +
        //         '<div class="col-sm-3">' +
        //         '<small>Created by: <%=taskList.get(i).getCreatedBy().getFirstName()%>' +
        //         '</small>' +
        //         '</div>' +
        //         '<div class="col-sm-3">' +
        //         '<small>Created at: <%=taskList.get(i).getCreatedAt()%>' +
        //         '</small>' +
        //         '</div>' +
        //         '<div class="col-sm-3">' +
        //         '<small>Deadline: <%=taskList.get(i).getDueDate()%>' +
        //         '</small>' +
        //         '</div>' +
        //         '<div class="col-sm-3">' +
        //         '<small>Priority: <%=taskList.get(i).getPriority()%>' +
        //         '</small>' +
        //         '</div>' +
        //         '</div>' +
        //         '</div>'


            // if (data.resultCode === "SUCCESS") {
        //     alert("Task added.")
        //     $('#addForm').fadeOut();
        //     loadEntities();
        // } else {
        //     alert("Failed.")
        // }
    }).fail(function () {
        alert("Fail. Try Again!")
    });

}

