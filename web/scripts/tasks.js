$(document).ready(function () {

    loadTasks();

    $('#btnAddTask').click(function () {
        $('#addForm').fadeIn();
    });

    // IN-PAGE SEARCH CODE
    const $source = document.querySelector('#txtSearch');
    const typeHandler = function (e) {
        $('.alert').hide();
        let elements = $('.alert-link');
        $.each(elements, function (key, element) {
            if ($(element).text().toLowerCase().includes(e.target.value.toLowerCase())) {
                $(element).parent().show();
            }
        })
    }
    $source.addEventListener('input', typeHandler) // register for oninput


    // IN-PAGE FILTER CODE
    $('#drpPriority').on('change', function () {
        let selectedValue = this.value;
        if (selectedValue == 'ALL') {
            $('.alert').show();
            return;
        }
        $('.alert').hide();
        let elements = $('.lblPriority');
        $.each(elements, function (key, element) {
            if ($(element).text().toLowerCase() == selectedValue.toLowerCase()) {
                $(element).parent().parent().parent().show();
            }
        })
    });

    $('#drpUser').on('change', function () {

        let selectedValue = this.value;
        if (selectedValue == 'ALL') {
            $('.alert').show();
            return;
        }
        $('.alert').hide();

        let selectedText = $("#drpUser option:selected").html();

        if (selectedText == 'MINE') {
            let userName = localStorage.getItem('firstName') + ' ' + localStorage.getItem('lastName');
            let elements = $('.lblAssignedTo');
            $.each(elements, function (key, element) {
                if ($(element).text() == userName) {
                    $(element).parent().parent().show();
                }
            })
        }
        if (selectedText == 'MY TEAM') {
            let teamName = localStorage.getItem('teamName');
            let elements = $('.lblTeamName');
            $.each(elements, function (key, element) {
                if ($(element).text() == teamName) {
                    $(element).parent().parent().show();
                }
            })
        }
    });

    $('#drpAllUsers').on('change', function () {

        let selectedValue = this.value;
        if (selectedValue == 'ALL') {
            $('.alert').show();
            return;
        }
        $('.alert').hide();

        let selectedUserName = $("#drpAllUsers option:selected").html();

        let elements = $('.lblAssignedTo');
        $.each(elements, function (key, element) {
            if ($(element).text() == selectedUserName) {
                $(element).parent().parent().show();
            }
        })

    });


    // IN-PAGE SORT CODE
    $('#drpOrder').on('change', function () {
        let selectedValue = this.value;
        if (selectedValue == 'NONE')
            loadTasks()
        else if (selectedValue == 'PRIORITY_ASC')
            loadTasks('priority', 'asc')
        else if (selectedValue == 'PRIORITY_DESC')
            loadTasks('priority', 'desc')
        else if (selectedValue == 'DEADLINE_ASC')
            loadTasks('dueDate', 'asc')
        else if (selectedValue == 'DEADLINE_DESC')
            loadTasks('dueDate', 'desc')
    });


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
                $("#addForm").trigger('reset');
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

    $(document).on('change', '.chkIsDone', function () {
        let id = $(this).data('id') // Extract info from data-* attributes

        $.post('EditTaskStatus', {
            id: id,
            isDone: this.checked
        }).done(function (data) {
            if (data.resultCode === "SUCCESS") {
                alert("Task changed.")
                loadTasks();
            } else {
                alert("Fail. You are not assigned to this task!");
                /*let chb=$(this);
                chb.prop('checked', !chb.prop('checked'));*/
                location.reload();

            }
        })
            .fail(function () {
                alert("Fail. Try Again!")
            });
    });


})

function loadTasks(orderColumn, orderRule) {

    $('#taskListSection').empty();
    $.get('Tasks')
        .done(function (data) {
            if (data.resultCode === 'SUCCESS') {


                loadUsersToDropdown();  // when loadTasks() complete

                if (orderColumn != undefined)
                    sortJSON(data.data, orderColumn, orderRule);

                $.each(data.data, function (key, value) {

                    let isDoneInput;
                    let taskPanelColor;

                    let currentDate = new Date();
                    let taskDueDate = new Date(this.dueDate.date.year, this.dueDate.date.month - 1, this.dueDate.date.day, this.dueDate.time.hour, this.dueDate.time.minute);

                    if (this.isDone) {
                        isDoneInput = '<input type="checkbox" class="chkIsDone" data-id="' + this.id + '" aria-label="Mark as done" checked>';
                        taskPanelColor = '<div class="alert alert-warning" role="alert">'
                    } else {
                        isDoneInput = '<input type="checkbox" class="chkIsDone" data-id="' + this.id + '" aria-label="Mark as done" >';
                        if (currentDate.valueOf() > taskDueDate.valueOf()) {
                            taskPanelColor = '<div class="alert alert-danger" role="alert">'
                        } else
                            taskPanelColor = '<div class="alert alert-primary" role="alert">';
                    }

                    const html =
                        taskPanelColor +
                        '<div class="float-left">Assigned to: ' +
                        '<label class="lblAssignedTo">' +
                        this.assignedTo.firstName + ' ' + this.assignedTo.lastName +
                        '</label>' +
                        '<input class="txtAssignedTo" name="txtAssignedTo">' +
                        ' / Team: <label class="lblTeamName">' + this.assignedTo.team.name + '</label>' +
                        '</div>' +
                        '<div class="float-right">' +
                        'Is done: ' + isDoneInput +
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
                        '<small>Priority: </small>' +
                        '<small class="lblPriority">' + this.priority + '</small>' +
                        '</small>' +
                        '</div>' +
                        '</div>' +
                        '<div class="row">' +
                        '<div  class="col-sm-3 buttonDelete"><button onclick="deleteTask(' + this.id + ')" class="btn btn-danger btn-sm">Delete</button>' +
                        '</div>' +
                        '<div class="col-sm-9 buttonUpdate">' +
                        '<button id="' + this.id + '" class="btn btn-primary btn-sm float-right " data-toggle="modal" data-target="#exampleModal" ' +
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

                    if (html != undefined) {
                        $('div#taskListSection').append(html).fadeIn(200)
                    } else
                        alert('append is empty')
                });

                chechAuthorization();

            } else
                alert("Fail. Try Again!")
        }).fail(function () {
        alert("Fail. Try Again!")
    });
}

function loadUsersToDropdown() {

    $('select#assignedTo, select#createdBy, select#assignedToEdit, select#createdByEdit, select#drpAllUsers')
        .find('option')
        .remove()

    $.get('users')
        .done(function (data) {
            if (data.resultCode === 'SUCCESS') {
                $('select#drpAllUsers').append('<option value="ALL">ALL</option>');

                $.each(data.data, function (key, value) {
                    let option = '<option value=' + this.id + '>' + this.firstName + ' ' + this.lastName + '</option>';
                    $('select#assignedTo, select#createdBy').append(option);
                    $('select#assignedToEdit, select#createdByEdit').append(option);

                    $('select#drpAllUsers').append(option);
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

function sortJSON(data, key, rule) {
    return data.sort(function (a, b) {
        var x = convertPriority(a[key]);
        var y = convertPriority(b[key]);

        if(key == 'dueDate'){

            x = new Date(x.date.year, x.date.month - 1, x.date.day, x.time.hour, x.time.minute);
            y = new Date(y.date.year, y.date.month - 1, y.date.day, y.time.hour, y.time.minute);

            if (rule == 'asc')
                return ((x.valueOf() < y.valueOf()) ? -1 : ((x.valueOf() > y.valueOf()) ? 1 : 0));
            else
                return ((x.valueOf() > y.valueOf()) ? -1 : ((x.valueOf() < y.valueOf()) ? 1 : 0));
        }
        else{
            if (rule == 'asc')
                return ((x < y) ? -1 : ((x > y) ? 1 : 0));
            else
                return ((x > y) ? -1 : ((x < y) ? 1 : 0));
        }
    });
}

function convertPriority(pName) {
    if (pName == 'LOW')
        return 0;
    else if (pName == 'MEDIUM')
        return 1;
    else if (pName == 'HIGH')
        return 2;

    return pName;
}