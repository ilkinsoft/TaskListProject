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
    <title>$Title$</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/tasks.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="scripts/tasks.js"></script>
</head>
<body>

<jsp:include page="Tasks"/>
<%@include file="shared/navbar.jsp" %>

<% List<Userr> userList = (ArrayList<Userr>) session.getAttribute("userList"); %>

<div class="container">
    <br/>
    <%--<c:forEach items="${taskList}" var="task">--%>
    <%--<b> ${task.textOfTask} </b>--%>
    <%--</c:forEach>--%>

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
                    <% for (int i = 0; i < userList.size(); i++) { %>
                    <option value="<%= userList.get(i).getId() %>">
                        <%= userList.get(i).getFirstName() + " " + userList.get(i).getLastName()                    %>
                    </option>
                    <% } %>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="createdBy">Created by</label>
                <select class="form-control" id="createdBy" name="createdBy">
                    <% for (int i = 0; i < userList.size(); i++) { %>
                    <option value="<%= userList.get(i).getId() %>">
                        <%= userList.get(i).getFirstName() + " " + userList.get(i).getLastName()                    %>
                    </option>
                    <% } %>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="isDone">Is Done</label>
                <select class="form-control" id="isDone" name="isDone">
                    <option value="0">No</option>
                    <option value="1">Yes</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label for="dueDate">Deadline</label>
                <input type="date" class="form-control" id="dueDate" name="dueDate"
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

    <button class="btn btn-primary" id="btnAddTask">Add Task</button>

    <%
        List<Task> taskList = (ArrayList<Task>) session.getAttribute("taskList");
        for (int i = 0; i < taskList.size(); i++) { %>
    <div class="alert alert-primary" role="alert">
        <div class="float-left">Assigned to:
            <%=taskList.get(i).getAssignedTo().getFirstName()%>
        </div>
        <div class="float-right">
            Mark as done: <input type="checkbox" aria-label="Mark as done">
        </div>

        <%--<hr>--%>
        <div class="alert-link" style="clear:both">
            <%=taskList.get(i).getTextOfTask()%>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <small>Created by: <%=taskList.get(i).getCreatedBy().getFirstName()%>
                </small>
            </div>
            <div class="col-sm-3">
                <small>Created at: <%=taskList.get(i).getCreatedAt()%>
                </small>
            </div>
            <div class="col-sm-3">
                <small>Deadline: <%=taskList.get(i).getDueDate()%>
                </small>
            </div>
            <div class="col-sm-3">
                <small>Priority: <%=taskList.get(i).getPriority()%>
                </small>
            </div>
        </div>
    </div>
    <%
        }
    %>

</div>
</body>
</html>
