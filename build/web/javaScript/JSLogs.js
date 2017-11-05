$(document).ready(function () {
    getAvgSwitch();
    getLogs();
    $('#info').append("<h5 id='numLogs'>Base de datos: " + localStorage.getItem('Nombre') + "</h5>");
});

function getLogs() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "getInfoLogs",
            IP: localStorage.getItem('IP')
        },
        error: function () {

        },
        success: function (data) {
            dibujarLogs(data);
        },
        type: 'GET',
        dataType: "json"
    });
}

function getAvgSwitch() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "getAvgSwitch",
            IP: localStorage.getItem('IP')
        },
        error: function () {

        },
        success: function (data) {
            $('#avgSwitch').append("<h5 id='AvgSwitch'>Average Switch: " + data +" horas"+"</h5>");
        },
        type: 'GET',
        dataType: "json"
    });
}

function dibujarLogs(data) {
    $('#info').append("<h5 id='numLogs'>Número de Logs: " + data.length + "</h5>");
    for (var i = 0; i < data.length; i++) {
        switch (data[i].status) {
            case "INACTIVE":
                $('#centro').append("<img class='dbImgIn' src='https://i.imgur.com/I0i0zgk.png' alt='BD' title='Estado: " + data[i].status +
                        " Tamaño: " + data[i].mb +" MB"+
                        " Ubicación: " + data[i].direccionFisica + "'/>");
                break;
            case "ACTIVE":
                $('#centro').append("<img class='dbImgAct' src='https://i.imgur.com/I0i0zgk.png' alt='BD' title='Estado: " + data[i].status +
                        " Tamaño: " + data[i].mb +" MB"+
                        " Ubicación: " + data[i].direccionFisica + "'/>");
                break;
            case "CURRENT":
                $('#centro').append("<img class='dbImgCurrent' src='https://i.imgur.com/I0i0zgk.png' alt='BD' title='Estado: " + data[i].status +
                        " Tamaño: " + data[i].mb +" MB"+
                        " Ubicación: " + data[i].direccionFisica + "'/>");
                break;
            case "UNUSED":
                $('#centro').append("<img class='dbImgUnused' src='https://i.imgur.com/I0i0zgk.png' alt='BD' title='Estado: " + data[i].status +
                        " Tamaño: " + data[i].mb +" MB"+
                        " Ubicación: " + data[i].direccionFisica + "'/>");
                break;
        }
        $(".dbImgIn").tooltip({
            tooltipClass: "tooltip-styling"
        });
        $(".dbImgCurrent").tooltip({
            tooltipClass: "tooltip-styling"
        });
        $(".dbImgAct").tooltip({
            tooltipClass: "tooltip-styling"
        });
        $(".dbImgUnused").tooltip({
            tooltipClass: "tooltip-styling"
        });
    }
}

setInterval(function(){
    dibujarLogs(); // this will run after every 5 seconds
},10000);