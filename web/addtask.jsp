<%@ page import="com.wap.model.entity.Userr" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="AddTask"/>
<%@include file="shared/navbar.jsp" %>

<% List<Userr> userList = (ArrayList<Userr>) session.getAttribute("userList"); %>

<div class="container">
    <form action="AddTask" method="post">
        Text of task:
        <p>
            <input type="text" name="textOfTask" placeholder="Text of task" required>
        </p>
        Assigned to:
        <p>
            <select name="assignedTo" required>
                <%
                    for (int i = 0; i < userList.size(); i++) { %>
                        <option value="<%= userList.get(i).getId() %>">
                                <%= userList.get(i).getFirstName() + " " + userList.get(i).getLastName()  %>
                        </option>
                <%
                    }
                %>
            </select>
        </p>
        Created by:
        <p>
            <select name="createdBy" required>
                <%
                    for (int i = 0; i < userList.size(); i++) { %>
                <option value="<%= userList.get(i).getId() %>">
                    <%= userList.get(i).getFirstName() + " " + userList.get(i).getLastName()  %>
                </option>
                <%
                    }
                %>
            </select>
        </p>
        Is completed:
        <p>
            <select name="isDone" required>
                <option value="0">No</option>
                <option value="1">Yes</option>
            </select>
        </p>
        Due date:
        <p>
            <input type="date" name="dueDate">
        </p>
        Priority:
        <p>
            <select name="priority" required>
                <option value="LOW">Low</option>
                <option value="MEDIUM">Medium</option>
                <option value="HIGH">High</option>
            </select>
        </p>
        <button type="submit">Save Task</button>
    </form>
</div>

</body>
</html>
