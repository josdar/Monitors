<%-- 
    Document   : principal
    Created on : 27-ago-2017, 18:25:56
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js" type="text/javascript"></script>
        <script src="javaScript/Memoriajs.js" type="text/javascript"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Monitor de Table Spaces</title>
    </head>
    <body onload="leerHWM()">
        <header class="barraHeader">
            <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="registroBD.jsp">Monitor de Table Spaces</a>
            </nav>
        </header>
        <div id="top">
            <div class="grafico">
                <div id="chartContainer" style="height: 300px; width:100%;">
                </div>
            </div>
            <div class="tabla">
                <table id="tablaTbs">

                </table>
            </div>
        </div>
        <div id="bottom">
            <table class="tablaDetalles" id="tablaDts">
                <thead>
                    <tr>
                        <th class="headerT" id="nomTS">Nombre</th>
                        <th class="headerT" id="memTotal">Memoria Total</th>
                        <th class="headerT" id="memLibre">Memoria Libre</th>
                        <th class="headerT" id="memUsada">Memoria Usada</th>
                        <th class="headerT" id="hwm">HWM</th>
                        <!--<th class="headerT" id="estado">Estado</th-->  
                    </tr>
                </thead>
                <tr>    
                    <td class="filaT"><label id="nombreDato"></label></td>
                    <td class="filaT"><label id="totalDato"></label></td>
                    <td class="filaT"><label id="libreDato"></label></td>
                    <td class="filaT"><label id="usadaDato"></label></td>
                    <td class="filaT"><input onchange="saveHWM()" type="text" class="form-control" id="hwmDato" value=""/></td>
                    <!--<td class="filaT"><label id="estadoDato"></label></td>-->
                </tr>
            </table>
        </div>
    </body>
</html>
