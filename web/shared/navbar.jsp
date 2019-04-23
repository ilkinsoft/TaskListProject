
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Task List</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item adminsPlace facultysPlace studentsPlace">
                <a class="nav-link" href="tasks.jsp">Tasks<span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item adminsPlace">
                <a class="nav-link" href="teams.jsp">Teams</a>
            </li>
            <li class="nav-item adminsPlace">
                <a class="nav-link" href="users.jsp">Users</a>
            </li>
        </ul>
    </div>
</nav>