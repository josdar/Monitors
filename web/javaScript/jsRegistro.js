

function guardado(){
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
    getServidores();
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

function dibujarTablaServidores(data){
    var listado=document.getElementById("listado");
    listado.innerHTML="";
    for(var i = 0; i < data.length; i++){
        var row = $("<tr />");
        $("#tablaReg").append(row);
        row.append('<td>'+data[i].nombre+'</td><td>'+data[i].ip+'</td><td><img src="images/delete.png" onclick="eliminaServidor(\''+data[i].nombre+'\')"></td>');
    }
}

function cancelaRegistro(){
    window.location.href = "SeleccionBD.jsp";
}

function eliminaServidor(dataName){
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