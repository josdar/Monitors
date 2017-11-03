var sgaFree = 0.0;
var sPool = 0.0;
var sgaUsed = 0.0;
var HWM;
var HWMleido;
var porHWM;
$(document).ready(function () {
    //consultarFreeSGA();
    leerHWMSGA();
    setInterval(function () {
        //alert("HOLA");
        $.ajax({
            url: 'conexionBase',

            data: {
                accion: "free",
                IP: localStorage.getItem('IP')
            },
            error: function () { //si existe un error en la respuesta del ajax
            },
            success: function (data) {
                HWM = $('#HWM').val();
                sgaFree = data.m.freeSga;
                sPool = data.m.sharedPool;
                sgaUsed = data.m.usedSga;
                porHWM = (HWMleido * 1000) / 100;
                //alert(HWM);
                if (sgaUsed > porHWM) {
                    guardarAlerta();
                }
                $('#memLibre').html(sgaFree); //Here use html()
                $('#SharedPool').html(sPool); //Here use html()
                $('#usedSga').html(sgaUsed); //Here use html()
                sgaFree = parseInt(sgaFree);
                sPool = parseInt(sPool);
                sgaUsed = parseInt(sgaUsed);

                var dps = []; // dataPoints
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
                        stripLines: [
                            {
                                value: HWM,
                                thickness: 2,
                                color: "#ff0000",
                                label: "HWM"
                            }
                        ]
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

            },
            type: 'GET',
            dataType: "json"
        });
    }, 1000);

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