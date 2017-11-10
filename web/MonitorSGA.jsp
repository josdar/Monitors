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
        <script src="javaScript/JSSGA.js" type="text/javascript"></script>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Monitor de Memoria SGA</title>
    </head>
    <body>
        <header class="barraHeaderSGA">
            <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="Index.jsp">Monitor de Memoria SGA</a>
            </nav>
        </header>
        <div class="infoDB" id="info">

        </div>
        <div class="graficoSGA">
            <div id="chartContainer" style="height: 300px; width:100%;">
            </div>
        </div>
        <button onclick="abrirArchivo()" class="btn btn-primary btnArchivo">Abrir archivo de alertas</button>
        <div class="tablaSGA">
            <table class="table" id="tablaMem">
                <thead class="thead-inverse">
                    <tr>
                        <th>Memorias</th>
                        <th>MB</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Memoria Usada</td>
                        <td><label id="usedSga"></label></td>
                    </tr>
                    <tr>
                        <td>Memoria Libre</td>
                        <td><label id="memLibre"></label></td>
                    </tr>
                    <tr>
                        <td>Shared Pool</td>
                        <td><label id="SharedPool"></label></td>
                    </tr>
                    <tr>
                        <td>HWM</td>
                        <td>
                            <div class="col-lg-5">
                                <div class="input-group">
                                    <input type="text" id="HWM" class="form-control inputHWM" placeholder="Cambiar % SGA">
                                    <span class="input-group-btn">
                                        <button class="btn btn-secondary" onclick="saveHWMSGA()" type="button">Cambiar</button>
                                    </span>
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <footer class="piePaginaSGA">

        </footer>
    </body>
</html>
