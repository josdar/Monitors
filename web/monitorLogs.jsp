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
        <script src="javaScript/JSLogs.js" type="text/javascript"></script>
        <title>Monitor Logs</title>
    </head>
    <body>
        <header class="barraHeaderSGA">
            <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="menuMonitores.jsp">Monitor de Logs</a>
            </nav>
        </header>
        <table class="topInfo">
            <tr>
                <td>
                    <div class="infoDBSGA" id="info">
                    </div>  
                </td>
                <td>
                    <div class="clasfColores">
                        <label><img class="" src="https://i.imgur.com/x3MJUcm.png"/> CURRENT</label>
                        <label><img class="" src="https://i.imgur.com/dNoroPy.png"/> ACTIVE</label>
                        <label><img class="" src="https://i.imgur.com/2XqAb12.png"/> INACTIVE</label>
                        <label><img class="" src="https://i.imgur.com/f8lmjjx.png"/> UNUSED</label>
                    </div> 
                </td>
            </tr>
        </table>
        <div class="middle" id="centro">

        </div>
        <div class="AvgSwitch" id="avgSwitch">

        </div>
    </body>
</html>

