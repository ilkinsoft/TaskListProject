$(document).ready(function () {

    loadTasks();
    loadUsersToDropdown();

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
                loadTasks();
            } else {
                alert("Failed.")
            }
        })
            .fail(function () {
                alert("Fail. Try Again!")
            });
    });

})

function loadTasks() {

    $('#taskListSection').empty();
    $.get('Tasks')
        .done(function (data) {
            if (data.resultCode === 'SUCCESS') {
                $.each(data.data, function (key, value) {
                    let html =
                        '<div class="alert alert-primary" role="alert">' +
                        '<div class="float-left">Assigned to: ' +
                        this.assignedTo.firstName + ' ' + this.assignedTo.lastName +
                        '</div>' +
                        '<div class="float-right">' +
                        'Mark as done: <input type="checkbox" aria-label="Mark as done">' +
                        '</div>' +

                        '<div class="alert-link" style="clear:both">' +
                        this.textOfTask +
                        '</div>' +
                        '<div class="row">' +
                        '<div class="col-sm-3">' +
                        '<small>Created by: ' + this.createdBy.firstName + ' ' + this.createdBy.lastName +
                        '</small>' +
                        '</div>' +
                        '<div class="col-sm-3">' +
                        '<small>Created at: ' + this.createdAt.day + '/' + this.createdAt.month + '/' + this.createdAt.year +
                        '</small>' +
                        '</div>' +
                        '<div class="col-sm-3">' +
                        '<small>Deadline: ' + this.dueDate.day + '/' + this.dueDate.month + '/' + this.dueDate.year +
                        '</small>' +
                        '</div>' +
                        '<div class="col-sm-3">' +
                        '<small>Priority: ' + this.priority +
                        '</small>' +
                        '</div>' +
                        '</div>' +
                        '</div>'

                    $('div#taskListSection').append(html)
                    console.log('worked')
                });
            }
            else
                alert("Fail. Try Again!")
        }).fail(function () {
        alert("Fail. Try Again!")
    });
}

function loadUsersToDropdown() {

    $.get('users')
        .done(function (data) {
            if (data.resultCode === 'SUCCESS') {
                $.each(data.data, function (key, value) {
                    let option = '<option value=' + this.id + '>'+this.firstName+' '+this.lastName+'</option>';
                    $('select#assignedTo, select#createdBy').append(option);
                });
            }
        }).fail(function () {
        alert("Fail. Try Again!")
    });
}
