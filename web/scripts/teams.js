$(document).ready(function () {

    loadTeams();

    $('#btnAddTeam').click(function () {
        $('#addForm').fadeIn();
    });

    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        let id = button.data('id') // Extract info from data-* attributes
        let name = button.data('name')

        var modal = $(this)
        modal.find('.modal-title').text('Edit team with id #' + id)
        modal.find('.modal-body input[name="idEdit"]').val(id)
        modal.find('.modal-body input[name="nameEdit"]').val(name)
    })

    $('#editForm').on('submit', function (e) {
        e.preventDefault();
        let form = $(this);
        let url = form.attr('action');

        $.post(url, {
            id: $('#idEdit').val(),
            name: $('#nameEdit').val()
        }).done(function (data) {
            if (data.resultCode === "SUCCESS") {
                alert("Team changed.")
                loadTeams();
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
            name: $('#name').val()
        }).done(function (data) {
            if (data.resultCode === "SUCCESS") {
                alert("Team added.")
                $('#addForm').fadeOut();
                loadTeams();
            } else {
                alert("Failed.")
            }
        })
            .fail(function () {
                alert("Fail. Try Again!")
            });
    });

})

function loadTeams() {

    $('#teamListSection').empty();
    $.get('Teams')
        .done(function (data) {
            if (data.resultCode === 'SUCCESS') {
                $.each(data.data, function (key, value) {
                    const html =
                        '<div class="alert alert-primary" role="alert">' +
                        '<div class="row">' +
                        '<div class="col-sm-12">' +
                        '<div class="float-left">Name: ' +
                        '<label class="lblName">' +
                        this.name +
                        '</label>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        // '</div>' +
                        '<div class="row">' +
                            '<div class="col-sm-3">' +
                        '       <button onclick="deleteTeam(' + this.id + ')" class="btn btn-danger btn-sm">Delete</button>' +
                        '    </div>' +
                            '<div class="col-sm-9">' +
                                '<button id="' + this.id + '" class="btn btn-primary btn-sm float-right" data-toggle="modal" data-target="#exampleModal" ' +
                        'data-id="' + this.id + '" ' +
                        'data-name="' + this.name + '" ' +
                        '>Update team</button>' +
                            '</div>' +
                        '</div>' +
                        '</div>';

                    if (html != undefined) {
                        $('div#teamListSection').append(html)
                    } else
                        alert('append is empty')
                });
            } else
                alert("Fail. Try Again!")
        }).fail(function () {
        alert("Fail. Try Again!")
    });
}

function deleteTeam(id) {
    $.post('DeleteTeam', {
        id: id
    }).done(function (data) {
        if (data.resultCode === "SUCCESS") {
            alert("Team deleted.")
            loadTeams();
        } else {
            alert("Failed.")
        }
    })
        .fail(function () {
            alert("Fail. Try Again!")
        });
}
