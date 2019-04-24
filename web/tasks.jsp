<%@ page import="com.wap.model.entity.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wap.model.entity.Userr" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>--%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Tasks</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/tasks.css">
    <script src="shared/authorization.js"></script>

</head>
<body>

<%--<jsp:include page="Tasks"/>--%>
<%@include file="shared/navbar.jsp" %>

<%--<% List<Userr> userList = (ArrayList<Userr>) session.getAttribute("userList"); %>--%>

<div class="container">
    <br/>
    <%--<c:forEach items="${taskList}" var="task">--%>
    <%--<b> ${task.textOfTask} </b>--%>
    <%--</c:forEach>--%>

    <div class="row">
        <div class="col-lg-3">
            <div class="input-group">
                <input id="txtSearch" type="text" class="form-control" placeholder="Search for task text...">
            </div><!-- /input-group -->
        </div><!-- /.col-lg-3 -->
        <div class="col-lg-3">
            <div class="input-group">
                <label class="form-control">Team filter:</label>
                <select id="drpUser" class="form-control">
                    <option value="ALL">ALL</option>
                    <option value="MY_TEAM">MY TEAM</option>
                    <option value="MINE">MINE</option>
                </select>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-3 -->
        <div class="col-lg-3">
            <div class="input-group">
                <label class="form-control">Priority filter:</label>
                <select id="drpPriority" class="form-control">
                    <option value="ALL">ALL</option>
                    <option value="HIGH">HIGH</option>
                    <option value="MEDIUM">MEDIUM</option>
                    <option value="LOW">LOW</option>
                </select>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-3 -->
        <div class="col-lg-3">
            <div class="input-group">
                <label class="form-control">Sort:</label>
                <select id="drpOrder" class="form-control">
                    <option value="NONE">NONE</option>
                    <option value="PRIORITY_ASC">PRIORITY ASC</option>
                    <option value="PRIORITY_DESC">PRIORITY DESC</option>
                    <option value="DEADLINE_ASC">DEADLINE ASC</option>
                    <option value="DEADLINE_DESC">DEADLINE DESC</option>
                </select>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-3 -->
    </div>
    <br>
    <div class="row">
        <div class="col-lg-9"></div>

        <div class="col-lg-3">
            <div class="input-group">
                <label class="form-control">User filter:</label>
                <select id="drpAllUsers" class="form-control">
                </select>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-3 -->

    </div>
    <br>


    <form id="addForm" action="AddTask" method="post">
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="textOfTask">Text of task</label>
                <input type="text" class="form-control" id="textOfTask" name="textOfTask"
                       placeholder="Text of task" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="assignedTo">Assigned to</label>
                <select class="form-control" id="assignedTo" name="assignedTo">
                </select>
            </div>
        </div>
        <%--<div class="form-row">--%>
            <%--<div class="form-group col-sm-6">--%>
                <%--<label for="createdBy">Created by</label>--%>
                <%--<select class="form-control" id="createdBy" name="createdBy">--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="isDone">Is Done</label>
                <select class="form-control" id="isDone" name="isDone">
                    <option value=false>No</option>
                    <option value=true>Yes</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="dueDate">Deadline</label>
                <input type="datetime-local" class="form-control" id="dueDate" name="dueDate"
                       placeholder="Text of task" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="priority">Priority</label>
                <select class="form-control" id="priority" name="priority">
                    <option value="LOW">Low</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HIGH">High</option>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-sm-6">
                <button type="submit" id="btnSaveTask" class="btn btn-primary">Save Task</button>
            </div>
        </div>
    </form>

    <div id="btnAddTaskDiv">
        <button class="btn btn-primary" id="btnAddTask">Add Task</button>

    </div>


    <%--BOOTSTRAP MODAL--%>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editForm" action="EditTask" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="idEdit" name="idEdit">
                        </div>
                        <div class="form-group">
                            <label for="textOfTaskEdit" class="col-form-label">Text of task:</label>
                            <input type="text" class="form-control" id="textOfTaskEdit" name="textOfTaskEdit">
                        </div>
                        <div class="form-group">
                            <label for="assignedToEdit" class="col-form-label">Assigned to:</label>
                            <select class="form-control" id="assignedToEdit" name="assignedToEdit"></select>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<label for="createdByEdit" class="col-form-label">Created by:</label>--%>
                            <%--<select class="form-control" id="createdByEdit" name="createdByEdit"></select>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label for="createdAtEdit" class="col-form-label">Created at:</label>
                            <input type="datetime-local" class="form-control" id="createdAtEdit" name="createdAtEdit">
                        </div>
                        <div class="form-group">
                            <label for="dueDateEdit" class="col-form-label">Deadline:</label>
                            <input type="datetime-local" class="form-control" id="dueDateEdit" name="dueDateEdit">
                        </div>
                        <div class="form-group">
                            <label for="isDoneEdit" class="col-form-label">Is done:</label>
                            <%--<input type="text" class="form-control" id="isDoneEdit" name="isDoneEdit">--%>
                            <select class="form-control" id="isDoneEdit" name="isDoneEdit">
                                <option value=false>No</option>
                                <option value=true>Yes</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="priorityEdit" class="col-form-label">Priority:</label>
                            <select class="form-control" id="priorityEdit" name="priorityEdit">
                                <option value="LOW">Low</option>
                                <option value="MEDIUM">Medium</option>
                                <option value="HIGH">High</option>
                            </select>
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


    <div id="taskListSection"></div>


    <%--<%--%>
    <%--List<Task> taskList = (ArrayList<Task>) session.getAttribute("taskList");--%>
    <%--for (int i = 0; i < taskList.size(); i++) { %>--%>
    <%--<div class="alert alert-primary" role="alert">--%>
    <%--<div class="float-left">Assigned to:--%>
    <%--<%=taskList.get(i).getAssignedTo().getFirstName()%>--%>
    <%--</div>--%>
    <%--<div class="float-right">--%>
    <%--Mark as done: <input type="checkbox" aria-label="Mark as done">--%>
    <%--</div>--%>

    <%--&lt;%&ndash;<hr>&ndash;%&gt;--%>
    <%--<div class="alert-link" style="clear:both">--%>
    <%--<%=taskList.get(i).getTextOfTask()%>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<div class="col-sm-3">--%>
    <%--<small>Created by: <%=taskList.get(i).getCreatedBy().getFirstName()%>--%>
    <%--</small>--%>
    <%--</div>--%>
    <%--<div class="col-sm-3">--%>
    <%--<small>Created at: <%=taskList.get(i).getCreatedAt()%>--%>
    <%--</small>--%>
    <%--</div>--%>
    <%--<div class="col-sm-3">--%>
    <%--<small>Deadline: <%=taskList.get(i).getDueDate()%>--%>
    <%--</small>--%>
    <%--</div>--%>
    <%--<div class="col-sm-3">--%>
    <%--<small>Priority: <%=taskList.get(i).getPriority()%>--%>
    <%--</small>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<%--%>
    <%--}--%>
    <%--%>--%>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="scripts/tasks.js"></script>
<script src="scripts/moment.js"></script>

</body>
</html>
