
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Add User</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
  </head>
  <body>
  
  <%@include file="shared/navbar.jsp"%>

  <div class="container">
    <form action="AddUser" method="post">

      First name:
      <p>
        <input type="text" name="firstName" placeholder="First name" required>
      </p>
      Last name:
      <p>
        <input type="text" name="lastName" placeholder="Last name" required>
      </p>
      Location:
      <p>
        <input type="text" name="location" placeholder="Location" required>
      </p>
      Email:
      <p>
        <input type="email" name="email" placeholder="Email" required>
      </p>
      Phone:
      <p>
        <input type="text" name="phone" placeholder="Phone">
      </p>
      Team Id:
      <p>
        <input type="number" name="teamId" required>
      </p>
      Username:
      <p>
        <input type="text" name="username" placeholder="Username" required>
      </p>
      Password:
      <p>
        <input type="password" name="password" placeholder="Password" required>
      </p>
      Role:
      <p>
        <select name="role" required>
          <option value="ADMIN">Admin</option>
          <option value="PROJECTMANAGER">Project Manager</option>
          <option value="DEVELOPER">Developer</option>
        </select>
      </p>

      <button type="submit">Save Task</button>
    </form>
  </div>

  </body>
</html>
