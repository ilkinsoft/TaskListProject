
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Teams</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/teams.css">
    <script src="shared/authorization.js"></script>

</head>
<body>

<%@include file="shared/navbar.jsp" %>

<div class="container">
    <br/>

    <form id="addForm" action="AddTeam" method="post">
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="name">Name of team</label>
                <input type="text" class="form-control" id="name" name="name"
                       placeholder="Name of team" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <button type="submit" id="btnSaveTeam" class="btn btn-primary">Save Team</button>
            </div>
        </div>
    </form>

    <button class="btn btn-primary" id="btnAddTeam">Add Team</button>

    <%--BOOTSTRAP MODAL--%>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editForm" action="EditTeam" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="idEdit" name="idEdit">
                        </div>
                        <div class="form-group">
                            <label for="nameEdit" class="col-form-label">Name:</label>
                            <input type="text" class="form-control" id="nameEdit" name="nameEdit">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button id="saveChanges" type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>


    <div id="teamListSection"></div>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="scripts/teams.js"></script>

</body>
</html>
