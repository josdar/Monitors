

function guardado() {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "guardarBase",
            nombre: $("#nombre").val(),
            ip: $('#ip').val()
        },
        error: function () {
            swal('Error','Servidor no Guardado','error');
        },
        success: function (data) {
            getServidores();
            $('#nombre').val("");
            $('#ip').val("");
            $('#nombre').prop('disabled', false);
            swal('Listo','Servidor Guardado','success');
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
            dibujarTablaServidores(data);
        },
        type: 'GET',
        dataType: "json"
    });
}

function dibujarTablaServidores(data) {
    $("#tablaReg").html("");
    var head = $("<thead />");
    var row = $("<tr />");
    head.append(row);
    $("#tablaReg").append(head);
    row.append($("<th><label class='title'>Servidor</label></th>"));
    row.append($("<th><label class='title'>Dirección IP</label></th>"));
    row.append($("<th><label class='title'>Actualizar</label></th>"));
    row.append($("<th><label class='title'>Eliminar</label></th>"));

    for (var i = 0; i < data.length; i++) {
        dibujarFila(data[i]);
    }
}

function dibujarFila(data) {
    var row = $("<tr />");
    $("#tablaReg").append(row);
    row.append('<td>' + data.nombre + '</td><td>' + data.ip + '</td>');
    row.append('<td><img src="https://i.imgur.com/3WdUZIF.png" class="botonEditar" onclick="actualizarDatos(\'' + data.nombre + '\',\'' + data.ip + '\')"></td>');
    row.append('<td><img src="https://i.imgur.com/B3smSyn.png" class="botonBorrar" onclick="eliminaServidor(\'' + data.nombre + '\')"></td>');

}

function cancelaRegistro() {
    window.location.href = "SeleccionBD.jsp";
}

function eliminaServidor(dataName) {
    $.ajax({
        url: 'conexionBase',
        data: {
            accion: "eliminarServidor",
            nombre: dataName
        },
        error: function () {

        },
        success: function (data) {
            getServidores();
        },
        type: 'GET',
        dataType: "json"
    });
}

function actualizarDatos(dataName, dataIP) {
    $('#nombre').prop('disabled', true);
    $('#nombre').val(dataName);
    $('#ip').val(dataIP);
}
