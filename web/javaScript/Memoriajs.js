var hwmLeido;
$(document).ready(function () {
    tablespaces();
    $('#info').append("<h5 id='numLogs'>Servidor: " + localStorage.getItem('Nombre') + "</h5>");
});

function tablespaces() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "tablespaces",
            IP: localStorage.getItem('IP')
        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {
            dibujarTabla(data);
        },
        type: 'GET',
        dataType: "json"
    });
}

function leerHWM() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "getHWM"
        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {
            hwmLeido = data;
            $('#hwmDato').val(hwmLeido);
        },
        type: 'GET',
        dataType: "json"
    });
}

function saveHWM() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "saveHWM",
            hwm: $('#hwmDato').val(),
            tableSpace:$('#nombreDato').text()
        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {
            leerHWM();
            getTablespace($('#nombreDato').text());
        },
        type: 'GET',
        dataType: "json"
    });
}

function dibujarTabla(dataJson) {
    $("#tablaTbs").html("");
    var head = $("<thead />");
    var row = $("<tr />");
    head.append(row);
    $("#tablaTbs").append(head);
    row.append($("<th><label class='title'>Table Spaces</label></th>"));

    //carga la tabla con el json devuelto
    for (var i = 0; i < dataJson.length; i++) {
        dibujarFila(dataJson[i]);
    }
}

function dibujarFila(rowData) {
    var row = $("<tr />");
    $("#tablaTbs").append(row);
    row.append($('<td><button onclick="getTablespace( \'' + rowData.nombre + '\' )" type="button" class="tbs">' + rowData.nombre + '</button></td>'));

}

function getTablespace(nombre) {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "buscarTableSpace",
            IP: localStorage.getItem('IP'),
            tableSpace: nombre

        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {
            tablaDetalles(data);
            var hwmInput = $('#hwmDato').val();
            var memT = data.memTotal;
            var hwm = memT * hwmLeido / 100;
            var dps = [{label: data.nombre, y: data.memUsada}];
            var dps2 = [{label: data.nombre, y: data.memLibre}];
            var diasHWMN;
            if(Math.floor(data.diasHwm * 10) / 10 < 0){
                diasHWMN = 0;
            }else{
                diasHWMN= Math.floor(data.diasHwm * 10) / 10;
            }
            CanvasJS.addColorSet("coloresBarras",
                    [//colorSet Array

                        "#0000FF",
                        "#FF1493"
                    ]);

            var chart = new CanvasJS.Chart("chartContainer", {
                colorSet: "coloresBarras",
                toolTip: {
                    content: "Días para alcanzar el HWM: " + diasHWMN + " - " + "Días para alcanzar el total: " + Math.floor(data.diasTotal * 10) / 10 + ""
                },
                title: {
                    text: "Gráfico del Table Space " + data.nombre,
                    fontSize: 30
                },
                axisY: {
                    stripLines: [
                        {
                            value: hwm,
                            thickness: 2,
                            color: "#ff0000",
                            label: "HWM " + hwm + " MB"
                        }
                    ],
                    valueFormatString: "####"
                },

                animationEnabled: true,

                data: [
                    {
                        type: "stackedBar",
                        showInLegend: true,
                        legendText: "Memoria Usada",
                        dataPoints: dps
                    },
                    {
                        type: "stackedBar",
                        showInLegend: true,
                        legendText: "Memoria Libre",
                        dataPoints: dps2
                    }
                ],

                legend: {

                    cursor: "pointer",
                    itemclick: function (e) {
                        if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                            e.dataSeries.visible = false;
                        } else {
                            e.dataSeries.visible = true;
                        }

                        chart.render();
                    }
                }
            });

            chart.render();
        },
        type: 'GET',
        dataType: "json"
    });
}

function tablaDetalles(data) {
    $('#nombreDato').html(data.nombre);
    $('#totalDato').html(data.memTotal + " MB");
    $('#libreDato').html(data.memLibre + " MB");
    $('#usadaDato').html(data.memUsada + " MB");
    $('#estadoDato').html(data.estado);

}