$(document).ready(function () {

    loadTasks();
    loadUsersToDropdown();

    $('#btnAddTask').click(function () {
        $('#addForm').fadeIn();
    });

    // $('.btnUpdateTask').click(function () {
    //     alert()
    //     $('.lblAssignedTo').hide();
    //     $('.txtAssignedTo').show();
    // });

    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        let id = button.data('id') // Extract info from data-* attributes
        let textOfTask = button.data('textoftask')
        let assignedTo = button.data('assignedto')
        let createdBy = button.data('createdby')
        let createdAt = button.data('createdat')
        let dueDate = button.data('duedate')
        let isDone = button.data('isdone') == true ? 'true' : 'false'
        let priority = button.data('priority')

        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('Edit task with id #' + id)
        modal.find('.modal-body input[name="idEdit"]').val(id)
        modal.find('.modal-body input[name="textOfTaskEdit"]').val(textOfTask)
        modal.find('.modal-body select[name="assignedToEdit"]').val(assignedTo)
        modal.find('.modal-body select[name="createdByEdit"]').val(createdBy)
        modal.find('.modal-body input[name="createdAtEdit"]').val(createdAt)
        modal.find('.modal-body input[name="dueDateEdit"]').val(dueDate)
        modal.find('.modal-body select[name="isDoneEdit"]').val(isDone)
        modal.find('.modal-body select[name="priorityEdit"]').val(priority)

        console.log(isDone)
    })

    $('#editForm').on('submit', function (e) {
        e.preventDefault();
        let form = $(this);
        let url = form.attr('action');

        console.log($('#isDoneEdit').val())
        $.post(url, {
            id: $('#idEdit').val(),
            textOfTask: $('#textOfTaskEdit').val(),
            assignedTo: $('#assignedToEdit').val(),
            createdBy: $('#createdByEdit').val(),
            createdAt: $('#createdAtEdit').val(),
            isDone: $('#isDoneEdit').val(),
            dueDate: $('#dueDateEdit').val(),
            priority: $('#priorityEdit').val()

        }).done(function (data) {
            if (data.resultCode === "SUCCESS") {
                alert("Task changed.")
                loadTasks();
                $('#exampleModal').modal('toggle');
            } else {
                alert("Failed.")
            }
        })
            .fail(function () {
                alert("Fail. Try Again!")
            });
    })

    $("#addForm").on('submit', function (e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.

        let form = $(this);
        let url = form.attr('action');

        // let task = {};
        // task.textOfTask = $('#textOfTask').val();
        // task.assignedTo = $('#assignedTo').val();
        // task.createdBy = $('#createdBy').val();
        // task.isDone = $('#isDone').val();
        // task.dueDate = $('#dueDate').val();
        // task.priority = $('#priority').val();
        // console.log(JSON.stringify(task))

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
                    console.log(this.createdAt.date.day)
                    const html =
                        '<div class="alert alert-primary" role="alert">' +
                        '<div class="float-left">Assigned to: ' +
                        '<label class="lblAssignedTo">' +
                        this.assignedTo.firstName + ' ' + this.assignedTo.lastName +
                        '</label>' +
                        '<input class="txtAssignedTo" name="txtAssignedTo">' +
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
                        '<small>Created at: ' + addZero(this.createdAt.date.day) + '/' + addZero(this.createdAt.date.month) + '/' + this.createdAt.date.year + ' ' +
                        addZero(this.createdAt.time.hour) + ':' + addZero(this.createdAt.time.minute) +
                        '</small>' +
                        '</div>' +
                        '<div class="col-sm-3">' +
                        '<small>Deadline: ' + addZero(this.dueDate.date.day) + '/' + addZero(this.dueDate.date.month) + '/' + this.dueDate.date.year + ' ' +
                        addZero(this.dueDate.time.hour) + ':' + addZero(this.dueDate.time.minute) +
                        '</small>' +
                        '</div>' +
                        '<div class="col-sm-3">' +
                        '<small>Priority: ' + this.priority +
                        '</small>' +
                        '</div>' +
                        '</div>' +
                        '<div class="row">' +
                        '<div class="col-sm-3"><button onclick="deleteTask(' + this.id + ')" class="btn btn-danger btn-sm">Delete</button>' +
                        '</div>' +
                        '<div class="col-sm-9">' +
                        '<button id="' + this.id + '" class="btn btn-primary btn-sm float-right" data-toggle="modal" data-target="#exampleModal" ' +
                        'data-id="' + this.id + '" ' +
                        'data-textOfTask="' + this.textOfTask + '" ' +
                        'data-assignedTo="' + this.assignedTo.id + '" ' +
                        'data-createdBy="' + this.createdBy.id + '" ' +
                        'data-createdAt="' +
                        this.createdAt.date.year + '-' + addZero(this.createdAt.date.month) + '-' + addZero(this.createdAt.date.day) + 'T' + addZero(this.createdAt.time.hour) + ':' + addZero(this.createdAt.time.minute) + '" ' +
                        //+ moment(this.createdAt).format("YYYY-MM-DDThh:mm") + '" ' +
                        'data-dueDate="' +
                        this.dueDate.date.year + '-' + addZero(this.dueDate.date.month) + '-' + addZero(this.dueDate.date.day) + 'T' + addZero(this.dueDate.time.hour) + ':' + addZero(this.dueDate.time.minute) + '" ' +
                        //+ moment(this.dueDate).format("YYYY-MM-DDThh:mm") + '" ' +
                        'data-isDone="' + this.isDone + '" ' +
                        'data-priority="' + this.priority + '" ' +
                        '">Update task</button>' +
                        '</div>' +
                        '</div>' +
                        '</div>';

                    // var ilkins = $('.ilkins')[0];
                    // ilkins.innerHTML = 'softdeveloper';
                    // var ownerTag = ilkins.querySelector('.owner');
                    // ownerTag.innerHTML = 'manipulated';
                    // var clone = ilkins.cloneNode(true);

                    // console.log(html)
                    if (html != undefined) {
                        $('div#taskListSection').append(html)
                        // $('div#taskListSection').append(clone)
                    } else
                        alert('append is empty')
                });
            } else
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
                    let option = '<option value=' + this.id + '>' + this.firstName + ' ' + this.lastName + '</option>';
                    $('select#assignedTo, select#createdBy').append(option);
                    $('select#assignedToEdit, select#createdByEdit').append(option);
                });
            }
        }).fail(function () {
        alert("Fail. Try Again!")
    });
}

function deleteTask(id) {
    $.post('DeleteTask', {
        id: id
    }).done(function (data) {
        if (data.resultCode === "SUCCESS") {
            alert("Task deleted.")
            loadTasks();
        } else {
            alert("Failed.")
        }
    })
        .fail(function () {
            alert("Fail. Try Again!")
        });

    // $.get("/DeleteTask/" + id, function () {
    //     alert("success");
    // })
    //     .done(function () {
    //         alert("second success");
    //     })
    //     .fail(function () {
    //         alert("error");
    //     })
    //     .always(function () {
    //         alert("finished");
    //     });
}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}

function addZero(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}