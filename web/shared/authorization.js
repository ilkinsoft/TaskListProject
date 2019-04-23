function chechAuthorization() {

    var role = localStorage.getItem("role");

    if (role === "PROJECTMANAGER") {
        //Can assign user to teams OK
        //Can add/edit/delete teams OK
        //Can add/edit/delete tasks OK
        //Can't create/delete users! OK
        //Can only edit team of the user! OK



        //users.jsp
        $('#buttonAddUser').css('visibility', 'gone');
        $('#buttonAddUser').text(""); //if i delete this, visibility method doesnt work, interesting

        $('.deleteUser').css('visibility', 'gone');
        $('.deleteUser').text('');


        //userDetails.jsp
        $("#inputFirstName").prop('disabled', true);
        $("#inputLastName").prop('disabled', true);
        $("#inputEmail").prop('disabled', true);
        $("#inputPassword").prop('disabled', true);
        $("#inputPassword2").prop('disabled', true);
        $("#inputPhone").prop('disabled', true);
        $("#role").prop('disabled', true);


        //$('#buttonAddUser').hide();


    } else if (role === "DEVELOPER") {
        //todo sayfa gizlenecekse bile o sayfa ile ilgili butun kisitlamalari ekle buraya
        //cant see teams page
        //cant see users page
        //cant update/delete/add task
        //can only mark as done task if it assigned to him ---PENDING
        //cannot see other pages even if he types to address bar


        //navbar.jsp
        $('.usersButton').css('visibility', 'gone');
        $('.usersButton').text('');

        $('.teamsButton').css('visibility', 'gone');
        $('.teamsButton').text('');

        //tasks.jsp
        $('.buttonDelete').css('visibility', 'gone');
        $('.buttonDelete').text(""); //if i delete this, visibility method doesnt work, interesting

        $('.buttonUpdate').css('visibility', 'gone');
        $('.buttonUpdate').text('');

        $('#btnAddTaskDiv').css('visibility', 'gone');
        $('#btnAddTaskDiv').text('');

    } else {
        //admin can only do user stuffs


    }
}


