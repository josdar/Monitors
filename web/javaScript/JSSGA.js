$(document).ready(function () {
    //consultarFreeSGA();
    var sgaFree = 0.0;
    var sPool = 0.0;
    var sgaUsed = 0.0;
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
                sgaFree = data.m.freeSga;
                sPool = data.m.sharedPool;
                sgaUsed = data.m.usedSga;
                $('#memLibre').html(sgaFree); //Here use html()
                $('#SharedPool').html(sPool); //Here use html()
                $('#usedSga').html(sgaUsed); //Here use html()
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
                minimum: 50,
                maximum: 100,
                interval: 10,
                title: "% MegaBytes",
                stripLines: [
                    {
                        value: 60,
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

        //var yVal = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000];
        var updateInterval = 1000;
        //var maxDataLength = yVal.length; // number of dataPoints after which the series shifts
        var time = new Date();
        //var updateCount = 0;

        var updateChart = function (count) {

            count = count || 1;

            for (var j = 0; j < count; j++) {
                time.setSeconds(time.getSeconds() + 1);

                dps.push({
                    x: time.getTime(),
                    y: (sgaUsed * 100) / 1000
                });
                //updateCount++;

                if (dps.length > 10) {
                    dps.shift();
                }
            }


            chart.render();

        };

        // generates first set of dataPoints
        updateChart(10);

        // update chart after specified time.
        setInterval(function () {
            updateChart();
        }, updateInterval);

    }

});