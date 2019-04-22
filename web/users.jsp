<%--
  Created by IntelliJ IDEA.
  User: Bezir
  Date: 21.04.2019
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
    <script src="scripts/users.js"></script>


    <!-- bootstrap -->
    <link href="./css/bootstrap.css" rel="stylesheet">

    <!-- libraries -->
    <link href="./css/font-awesome.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="./css/layout.css">
    <link rel="stylesheet" type="text/css" href="./css/elements.css">

    <!-- this page specific styles -->

    <!-- google font libraries -->
    <link href="./css/css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">



    <title>Users</title>
</head>
<body>
<%@include file="shared/navbar.jsp" %>
<div id="sonuclar">


</div>
<div class="clearfix">

    <div class="pull-right top-page-ui">
        <a href="adduser.jsp" class="btn btn-primary pull-right">
            <i class="fa fa-plus-circle fa-lg"></i> Add user
        </a>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="main-box clearfix">
            <div class="table-responsive">
                <table class="table user-list">
                    <thead>
                    <tr>
                        <th><span>User</span></th>
                        <th><span>Created</span></th>
                        <th class="text-center"><span>Status</span></th>
                        <th><span>Email</span></th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody id="listofusers">
                    <%--<tr>
                        <td>
                            <img src='./img/profile_pic_place_holder.jpg' alt=''>
                            <a href='http://superhero.phoonio.com/users.html#' class='user-link'>Mila Kunis</a>
                            <span class='user-subhead'>Admin</span>
                        </td>
                        <td>
                            2013/08/08
                        </td>
                        <td class='text-center'>
                            <span class='label label-default'>Inactive</span>
                        </td>
                        <td>
                            <a href='http://superhero.phoonio.com/users.html#'>mila@kunis.com</a>
                        </td>
                        <td style='width: 20%;'>
                            <a href='http://superhero.phoonio.com/users.html#' class='table-link'>
															<span class='fa-stack'>
																<i class='fa fa-square fa-stack-2x'></i>
																<i class='fa fa-search-plus fa-stack-1x fa-inverse'></i>
															</span>
                            </a>
                            <a href='http://superhero.phoonio.com/users.html#' class='table-link'>
															<span class='fa-stack'>
																<i class='fa fa-square fa-stack-2x'></i>
																<i class='fa fa-pencil fa-stack-1x fa-inverse'></i>
															</span>
                            </a>
                            <a href='http://superhero.phoonio.com/users.html#' class='table-link danger'>
															<span class='fa-stack'>
																<i class='fa fa-square fa-stack-2x'></i>
																<i class='fa fa-trash-o fa-stack-1x fa-inverse'></i>
															</span>
                            </a>
                        </td>
                    </tr>--%>

                    </tbody>
                </table>
            </div>
            <ul class="pagination pull-right">
                <li><a href="http://superhero.phoonio.com/users.html#"><i class="fa fa-chevron-left"></i></a></li>
                <li><a href="http://superhero.phoonio.com/users.html#">1</a></li>
                <li><a href="http://superhero.phoonio.com/users.html#">2</a></li>
                <li><a href="http://superhero.phoonio.com/users.html#">3</a></li>
                <li><a href="http://superhero.phoonio.com/users.html#">4</a></li>
                <li><a href="http://superhero.phoonio.com/users.html#">5</a></li>
                <li><a href="http://superhero.phoonio.com/users.html#"><i class="fa fa-chevron-right"></i></a></li>
            </ul>
        </div>
    </div>
</div>


</body>
</html>
