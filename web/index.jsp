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
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="scripts/singIn.js"></script>

    <!------ Include the above in your HEAD tag ---------->
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Sign In</h5>
                    <form class="form-signin" >
                        <div class="form-label-group">
                            <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                        </div>

                        <br>

                        <div class="form-label-group">
                            <input  name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                        </div>
                        <br>

                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">Remember password</label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>

                    </form>


                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
