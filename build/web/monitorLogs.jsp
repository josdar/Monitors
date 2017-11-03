<%-- 
    Document   : monitorLogs
    Created on : Nov 3, 2017, 1:44:20 AM
    Author     : joset
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="javaScript/JS.js" type="text/javascript"></script>
        <title>Monitor Logs</title>
    </head>
    <body>
        <header class="barraHeaderSGA">
            <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="#">Monitor Logs</a>
            </nav>
        </header>
        <div class="infoDB">
            <h5>Nombre Base de Datos: DBHSR</h5>
            <h5>Numero de Logs: 8</h5>
        </div>
        <div class="middle">
            <img class="dbImgAct" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: INACTIVE Porcentaje: 100%  Switch: 8h"/>
            <img class="dbImgAct" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: INACTIVE Porcentaje: 100%  Switch: 8h"/>
            <img class="dbImgAct" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: INACTIVE Porcentaje: 100%  Switch: 8h"/>
            <img class="dbImgAct" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: INACTIVE Porcentaje: 100%  Switch: 8h"/>
            <img class="dbImgAct" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: INACTIVE Porcentaje: 100%  Switch: 8h"/>
            <img class="dbImgAct" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: INACTIVE Porcentaje: 100%  Switch: 8h"/>
            <img class="dbImgAm" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: ACTIVE Porcentaje: 10%  Switch: 8h"/>
            <img class="dbImgIn" src="https://i.imgur.com/I0i0zgk.png" alt="" title="Estado: CURRENT Porcentaje: 50%  Switch: 8h"/>
        </div>
        <div class="AvgSwitch">
            <h5></h5>
            <h5></h5>
            <h5>Average Switch: 8 Horas</h5>
            <h5></h5>
            <h5></h5>
        </div>
    </body>
</html>

