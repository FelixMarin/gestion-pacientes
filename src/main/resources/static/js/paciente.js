function init() {
    let paciente = JSON.parse(window.localStorage.getItem('paciente'));

    if (paciente) {
        saludo(paciente);
        cabeceraMenuLateral();
        getComponente('cuerpoMenuLateral', 'cuerpo-menu-lateral');
        infoPaciente(paciente);
        citasPaciente(paciente);
    } else {
        window.location = '/login';
    }
}

function saludo(paciente) {
    let div = document.getElementById('saludo');
    div.innerHTML = 'Hola, ' + paciente.usuario.nombre.trim();
}

function cabeceraMenuLateral() {
    let div = document.getElementById('cabecera-menu-lateral');

    var newlabel = document.createElement("Label");
    newlabel.setAttribute("for", "label-cabecera-menu-lateral");
    newlabel.innerHTML = "<div onclick='recargar();'><p class='text h6'><b>Menú Principal</b> </div>";
    div.appendChild(newlabel);
}

function infoPaciente(paciente) {
    let spanNombre = document.getElementById('nombre-paciente');
    spanNombre.innerText = paciente.usuario.nombre.trim();
    spanNombre.innerText += ' ' + paciente.usuario.apellidos.trim();

    let spanNNSS = document.getElementById('nnss');
    spanNNSS.innerText = paciente.numTarjeta.trim();

}

function getComponente(path, id) {
    fetch("/" + path)
        .then(response => {
            return response.text()
        })
        .then(data => {
            document.querySelector("#" + id).innerHTML = data;
        });
}

function bold(elem) {

    let elements = document.getElementById('p-medicacion').parentNode.parentNode.querySelectorAll('p');

    elements.forEach(function (elemList) {
        elemList.style.fontWeight = 'normal';
        elemList.style.fontSize = "initial";
        elemList.style.color = '#000';
    });
    elem.style.fontWeight = 'bold';
    elem.style.fontSize = "larger";
    elem.style.color = 'darkslateblue';
}

function recargar() {
    window.location = '/paciente';
}

function citasPaciente(paciente) {

    let idPacienteJSON = '{"id":"' + paciente.id + '"}';

    $.ajax({
        contentType: 'application/json',
        async: false,
        data: idPacienteJSON,
        success: function (data) {
            if (data) {
                console.log(data);
                let cita = JSON.stringify(data);
                window.localStorage.setItem('cita', cita);
            } else {
                alert('No se han podido cargar las citas');
            }
        },
        error: function (xhr, textStatus, error) {
            console.log(xhr.responseText);
            console.log(xhr.statusText);
            console.log(textStatus);
            console.log(error);
        },
        processData: false,
        url: '/cita/findbypaciente',
        type: 'POST',
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + window.localStorage.getItem('access_token'));
        },
    });
}

function importCitas() {

    let fs = document.getElementById('fragment-scripts'); 
    fs.innerHTML = '';            
    let newScript = document.createElement("script");
    newScript.type = "text/javascript";
    newScript.async = false;
    newScript.src = "js/cita.js";
    fs.appendChild(newScript);
}