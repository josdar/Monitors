<%-- 
    Document   : SeleccionBD
    Created on : 08/11/2017, 06:11:02 PM
    Author     : Manuel Céspedes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js" type="text/javascript"></script>
        <script src="javaScript/jsSeleccion.js" type="text/javascript"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Selección del Servidor</title>
    </head>
    <body onload="getServidores()">
        <header class="barraHeader">
            <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="Index.jsp">Selección del Servidor</a>
            </nav>
        </header>
        <h1 class="titulo">Sistema de Monitoreo de Servidores</h1>
        <table class="tablaSeleccion">
            <tr>
                <td id="columBD">
                    <div class="form-group seleccion">
                        <label for="sel1">Seleccione el servidor:</label>
                        <select class="form-control" id="bases">

                        </select>
                    </div>   
                </td>
            </tr>
            <tr>
                <td>
                    <div class="btn-group botonesSelec">
                        <button type="button" onclick="setIpLocalStorage()" class="btn btn-success monitorear">Monitorear</button>
                        <button type="button" onclick="registroServidor()" class="btn btn-primary monitorear">Registrar Servidor</button>
                    </div> 

                </td>
            </tr>
        </table>
        <div>
            <img class="imagenServer" src="https://i.imgur.com/u6FkPNr.png"/>
        </div>
    </body>
</html>
