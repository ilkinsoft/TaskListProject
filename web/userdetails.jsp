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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
    <script src="scripts/userDetails.js"></script>

    <!------ Include the above in your HEAD tag ---------->
    <script src="shared/authorization.js"></script>
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 50%;
            width: 50%;
            margin:  auto;
        }

        /* Optional: Makes the sample page fill the window. */

    </style>

</head>
<body>


<%@include file="shared/navbar.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 id="titleOfForm" class="card-title text-center">Add User</h5>
                    <h6 id="errors" class="text-center" style="color: red"></h6>

                    <form id="addUserForm" class="form-signin">

                        <div class="form-label-group">
                            <input value="${param.firstName}" type="text" name="firstName" id="inputFirstName"
                                   class="form-control" placeholder="First Name"
                                   required autofocus>
                        </div>
                        <br>

                        <div class="form-label-group">
                            <input value="${param.lastName}" type="text" name="lastName" id="inputLastName"
                                   class="form-control" placeholder="Last Name" required>
                        </div>
                        <br>


                        <div class="form-label-group">
                            <input value="${param.email}" type="email" id="inputEmail" name="email" class="form-control"
                                   placeholder="Email address"
                                   required>
                        </div>

                        <br>


                        <div class="form-label-group">
                            <input value="${param.password}" type="password" name="password" id="inputPassword"
                                   class="form-control" placeholder="Password"
                                   required>
                        </div>
                        <br>


                        <div class="form-label-group">
                            <input value="${param.password}" type="password" name="password2" id="inputPassword2"
                                   class="form-control"
                                   placeholder="Repeat Password" required>
                        </div>
                        <br>

                        <div class="form-label-group">
                            <input value="${param.phone}" type="text" id="inputPhone" name="phone" class="form-control"
                                   placeholder="Phone" required>
                        </div>
                        <br>


                        <input id="roleHelper" type="hidden" value="${param.role}">
                        <input id="teamHelper" type="hidden" value="${param.team}">
                        <input id="isInEditMode" type="hidden" value="${param.isInEditMode}">
                        <input id="userID" type="hidden" value="${param.userID}">


                        <div class="form-label-group">
                            <select name="role" id="role">
                                <option value="PROJECTMANAGER">Project manager</option>
                                <option value="DEVELOPER">Developer</option>
                                <option value="ADMIN">Admin</option>
                            </select>
                        </div>
                        <br>


                        <div class="form-label-group">
                            Teams: <select name="team" id="team">

                        </select>
                        </div>
                        <br>


                        <button id="sendButton" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">
                            Add User
                        </button>

                    </form>


                </div>
            </div>
        </div>
    </div>
</div>


<div id="map"></div>
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY"></script>
<script>

    // This example displays a marker at the center of Australia.
    // When the user clicks the marker, an info window opens.

    function initMap() {
        var uluru = {lat: -25.363, lng: 131.044};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 6,
            center: uluru
        });

        var contentString = '<div id="content">'+
            '<div id="siteNotice">'+
            '</div>'+
            '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+
            '<div id="bodyContent">'+
            '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
            'sandstone rock formation in the southern part of the '+
            'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+
            'south west of the nearest large town, Alice Springs; 450&#160;km '+
            '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+
            'features of the Uluru - Kata Tjuta National Park. Uluru is '+
            'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
            'Aboriginal people of the area. It has many springs, waterholes, '+
            'rock caves and ancient paintings. Uluru is listed as a World '+
            'Heritage Site.</p>'+
            '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
            'https://en.wikipedia.org/w/index.php?title=Uluru</a> '+
            '(last visited June 22, 2009).</p>'+
            '</div>'+
            '</div>';

        var infowindow = new google.maps.InfoWindow({
            content: contentString
        });

        var marker = new google.maps.Marker({
            position: uluru,
            map: map,
            title: 'Uluru (Ayers Rock)'
        });
        infowindow.open(map, marker);

    }
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSlCwXSK7VOkcw02tY1DtBi3rjr_GzpWo&callback=initMap"
        async defer></script>


</body>
</html>
