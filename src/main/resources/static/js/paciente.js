function init() {
    //$('datos-paciente').click(function(){  });

    let paciente = JSON.parse(window.localStorage.getItem('paciente'));

    if(paciente) {
        cabecera(paciente);
        datosPaciente(paciente);
        menuLateral(paciente);
    } else {
        window.location = 'http://localhost:8081/login';	
    }
}

function cabecera(paciente) {
    let div = document.getElementById('saludo');
    div.innerHTML = 'Hola, ' + paciente.usuario.nombre.trim();
}

function datosPaciente(paciente) {
    
    if(paciente) {

    let div = document.getElementById('datos-paciente');

    var newlabel = document.createElement("Label");
    newlabel.setAttribute("for","label-datos-paciente");
    newlabel.innerHTML = "<div><p class='text h6'><b>Menú Principal</b> </div>";


    /*newlabel.innerHTML += "<b>Nombre:</b> " + paciente.usuario.nombre.trim() + "&emsp;<b>Apellidos:</b> " + paciente.usuario.apellidos.trim() + "&emsp;<b>NNSS:</b> " + paciente.nnss.trim() + 
                            "&emsp;<b>Telefono:</b> " + paciente.telefono.trim() + "</p></div>";*/
    div.appendChild(newlabel);
    }
}

function menuLateral(paciente) {

    let div = document.getElementById('datos-medico');

    if(paciente && div) {
    
        var newlabel = document.createElement("div");        
        newlabel.setAttribute("id","label-datos-medico"); 
        newlabel.setAttribute("name","label-datos-medico");        
        
        var divBuscar = document.createElement("div");
        newlabel.setAttribute("id","div-buscar");  
        newlabel.setAttribute("name","div-buscar"); 

        var pBuscar = document.createElement("p");
        pBuscar.setAttribute("id","p-buscar");  
        pBuscar.setAttribute("name","p-buscar"); 
        pBuscar.setAttribute("value","Buscar"); 
        pBuscar.style.cursor = 'pointer';
        pBuscar.innerText = 'Buscar';
        pBuscar.setAttribute("onclick", "buscar()");
        divBuscar.appendChild(pBuscar);
        newlabel.appendChild(divBuscar);
        
        var divMensajes = document.createElement("div");
        newlabel.setAttribute("id","div-mensajes");  
        newlabel.setAttribute("name","div-mensajes"); 

        var pMensajes = document.createElement("p");
        pMensajes.setAttribute("id","p-mensajes");  
        pMensajes.setAttribute("name","p-mensajes"); 
        pMensajes.style.cursor = 'pointer';
        pMensajes.setAttribute("value","Mensajes"); 
        pMensajes.innerText = 'Mensajes';
        pMensajes.setAttribute("onclick", "mensajes()");
        divMensajes.appendChild(pMensajes);
        newlabel.appendChild(divMensajes);

        var divDiagnosticos = document.createElement("div");
        newlabel.setAttribute("id","div-diagnosticos");  
        newlabel.setAttribute("name","div-diagnosticos"); 

        var pDiagnosticos = document.createElement("p");
        pDiagnosticos.setAttribute("id","p-diagnosticos");  
        pDiagnosticos.setAttribute("name","p-diagnosticos"); 
        pDiagnosticos.style.cursor = 'pointer';
        pDiagnosticos.setAttribute("value","Diagnosticos"); 
        pDiagnosticos.innerText = 'Diagnosticos';
        pDiagnosticos.setAttribute("onclick", "diagnosticos()");
        divDiagnosticos.appendChild(pDiagnosticos);
        newlabel.appendChild(divDiagnosticos);
        
        div.appendChild(newlabel);
        }
}

function buscar() {
    alert('buscar');
}

function mensajes() {
    alert('mensajes');
}

function diagnosticos() {
    alert('diagnosticos');
}