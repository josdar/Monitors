function getIp() {
    alert($("#bases option:selected").val());
}

function guardarServidor() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "guardarBase",
            nombre: $("#nombre").val(),
            ip: $('#ip').val()
        },
        error: function () {

        },
        success: function (data) {
            
        },
        type: 'GET',
        dataType: "json"
    });
}


function getServidores() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "getServidores"
        },
        error: function () {

        },
        success: function (data) {
            dibujarSelectServidor(data);
        },
        type: 'GET',
        dataType: "json"
    });
}

function setIpLocalStorage() {
    localStorage.setItem('Nombre',$("#bases option:selected").text());
    localStorage.setItem('IP',$("#bases option:selected").val());
    window.location.href = "Index.jsp";
}

function dibujarSelectServidor(data) {
    for (var i = 0; i < data.length; i++) {
        $('#bases').append($('<option>', {value: data[i].ip, text: data[i].nombre}));
    }
}