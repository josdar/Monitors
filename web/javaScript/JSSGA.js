var sgaFree = 0.0;
var sPool = 0.0;
var sgaUsed = 0.0;
var HWM;
var HWMleido;
var porHWM;
$(document).ready(function () {
    $('#info').append("<h5 id='numLogs'>Servidor: " + localStorage.getItem('Nombre') + "</h5>");
    leerHWMSGA();
    setInterval(function () {
        $.ajax({
            url: 'conexionBase',
            data: {
                accion: "free",
                IP: localStorage.getItem('IP')
            },
            error: function () {
            },
            success: function (data) {
                HWM = $('#HWM').val();
                sgaFree = data.m.freeSga;
                sPool = data.m.sharedPool;
                sgaUsed = data.m.usedSga;

                porHWM = (HWMleido * 1000) / 100;
                if (sgaUsed > porHWM) {
                    guardarAlerta();
                }
                $('#memLibre').html(sgaFree);
                $('#SharedPool').html(sPool);
                $('#usedSga').html(sgaUsed);
                sgaFree = parseInt(sgaFree);
                sPool = parseInt(sPool);
                sgaUsed = parseInt(sgaUsed);
            },
            type: 'GET',
            dataType: "json"
        });
    }, 1000);

    /*-----------------------GRAFICO--------------------------------------------*/

    window.onload = function () {
        var dps = []; // dataPoints
        var puntosHWM = [];
        var instance = (new Date()).getTime();
        var chart = new CanvasJS.Chart("chartContainer", {
            title: {
                text: "Memoria SGA"
            },
            axisX: {
                title: "Tiempo",
                valueFormatString: "hh:mm:ss"
            },
            axisY: {
                minimum: 10,
                maximum: 100,
                interval: 10,
                title: "% MegaBytes",
                stripLines: puntosHWM
            },
            data: [{
                    type: "spline",
                    xValueType: "dateTime",
                    dataPoints: dps
                }]
        });
        var updateInterval = 1000;
        var time = new Date();
        var updateChart = function (count) {
            count = count || 1;
            for (var j = 0; j < count; j++) {
                time.setSeconds(time.getSeconds() + 1);
                puntosHWM.pop();
                puntosHWM.push({
                    value: HWMleido,
                    thickness: 2,
                    color: "#ff0000",
                    label: "HWM"
                });
                dps.push({
                    x: time.getTime(),
                    y: (sgaUsed * 100) / 1000
                });
                if (dps.length > 10) {
                    dps.shift();
                }
            }
            chart.render();
        };
        updateChart(10);
        setInterval(function () {
            updateChart();
        }, updateInterval);
    }
});

function guardarAlerta() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "guardarAlerta",
            IP: localStorage.getItem('IP')
        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {

        },
        type: 'POST'
    });
}


function leerHWMSGA() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "getHWMSGA"
        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {
            HWMleido = data;
            $('#HWM').val(HWMleido);
            localStorage.setItem('HWMSGA', HWMleido);
        },
        type: 'GET',
        dataType: "json"
    });
}

function saveHWMSGA() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "saveHWMSGA",
            hwmSGA: $('#HWM').val()
        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {
            leerHWMSGA();
        },
        type: 'GET',
        dataType: "json"
    });
}

function abrirArchivo() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "abrirArchivo",
            IP: localStorage.getItem('IP')
        },
        error: function () { //si existe un error en la respuesta del ajax
        },
        success: function (data) {
           
        },
        type: 'GET',
        dataType: "json"
    });
}