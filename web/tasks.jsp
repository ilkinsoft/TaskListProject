<%@ page import="com.wap.model.entity.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>--%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>$Title$</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="Tasks"/>
<%@include file="shared/navbar.jsp" %>

<div class="container">
    <br/>
    <%--<b>${tt}</b>--%>
    <%--${taskList[0].textOfTask}--%>

    <%--<c:forEach items="${taskList}" var="task">--%>
    <%--<b> ${task.textOfTask} </b>--%>
    <%--</c:forEach>--%>

    <%
        List<Task> taskList = (ArrayList<Task>) session.getAttribute("taskList");
        for (int i = 0; i < taskList.size(); i++) { %>
    <div class="alert alert-primary" role="alert" >
        <div class="float-left">Assigned to:
            <%=taskList.get(i).getAssignedTo().getFirstName()%>
        </div>
        <div class="float-right">
            Mark as done: <input type="checkbox" aria-label="Mark as done" >
        </div>


    <%--<hr>--%>
        <div class="alert-link" style="clear:both">
            <%=taskList.get(i).getTextOfTask()%>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <small>Created by: <%=taskList.get(i).getCreatedBy().getFirstName()%></small>
            </div>
            <div class="col-sm-3">
                <small>Created at: <%=taskList.get(i).getCreatedAt()%></small>
            </div>
            <div class="col-sm-3">
                <small>Deadline: <%=taskList.get(i).getDueDate()%></small>
            </div>
            <div class="col-sm-3">
                <small>Priority: <%=taskList.get(i).getPriority()%></small>
            </div>
        </div>
    </div>
    <%
        }
    %>

</div>
</body>
</html>
