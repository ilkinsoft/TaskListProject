<%--
  Created by IntelliJ IDEA.
  User: Bezir
  Date: 21.04.2019
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="scripts/singUp.js"></script>

    <!------ Include the above in your HEAD tag ---------->
</head>
<body>


<%@include file="shared/navbar.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Add User</h5>
                    <form class="form-signin">

                        <div class="form-label-group">
                            <input type="text"  name="firstName" id="inputFirstName" class="form-control" placeholder="First Name"
                                   required autofocus>
                        </div>
                        <br>

                        <div class="form-label-group">
                            <input type="text" name="lastName" id="inputLastName" class="form-control" placeholder="Last Name" required>
                        </div>
                        <br>


                        <div class="form-label-group">
                            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address"
                                   required>
                        </div>

                        <br>


                        <div class="form-label-group">
                            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password"
                                   required>
                        </div>
                        <br>


                        <div class="form-label-group">
                            <input type="password" name="password2" id="inputPassword2" class="form-control"
                                   placeholder="Repeat Password" required>
                        </div>
                        <br>

                        <div class="form-label-group">
                            <input type="text" id="inputPhone"  name="phone" class="form-control" placeholder="Phone" required>
                        </div>
                        <br>

                        <div class="form-label-group">
                            <select name="role">
                                <option value="PROJECTMANAGER">Project manager</option>
                                <option value="DEVELOPER">Developer</option>
                                <option value="ADMIN">Admin</option>
                            </select>
                        </div>
                        <br>


                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Add User</button>

                    </form>


                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
