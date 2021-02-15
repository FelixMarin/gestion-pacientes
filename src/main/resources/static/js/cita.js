function crearTablaCitasActivas() {

    let citas = JSON.parse(window.localStorage.getItem('cita'));
    let ul = document.getElementById('lista-proximas-citas');

    if (citas) {

        for (var i = 0; i < citas.length; i++) {
            if (citas[i].estado.nombre !== "CERRADO") {
                let li = document.createElement('li');
                li.setAttribute('class', 'list-group-item');
                li.innerHTML = '<p class="text" onclick="detalleCita('+ citas[i].id +');">Id Cita: ' + citas[i].id 
                    + '&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;'
                    + ' Fecha: ' + citas[i].fecHoraCita + ' '
                    + '<img title="Cita activa" class="float-right" src="img/green_dot.png" alt="logo" width="20" height="20"></img>'
                    + '</p>';

                ul.appendChild(li);
            }
        }

        if (ul.innerHTML == '') {
            let li = document.createElement('li');
            li.setAttribute('class', 'list-group-item');     
            li.innerHTML = '<div><p class="text">No hay citas pendientes</p></div>';       
            ul.appendChild(li);
        }
    }
}

function crearTablaCitasPasadas() {

    let citas = JSON.parse(window.localStorage.getItem('cita'));
    let ul = document.getElementById('lista-citas-pasadas');

    if (citas) {
        for (var i = 0; i < citas.length; i++) {
            if (citas[i].estado.nombre === "CERRADO") {
                let li = document.createElement('li');
                li.setAttribute('class', 'list-group-item')
                li.innerHTML = '<p class="text" style="cursor:pointer;" onclick="detalleCita('+ citas[i].id +');">Id Cita: ' + citas[i].id 
                    + '&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;'
                    + ' Fecha: ' + citas[i].fecHoraCita + ' '
                    + '<img title="Cita cerrada" class="float-right" src="img/gray_dot.png" alt="logo" width="20" height="20"></img>'
                    + '</p>';

                ul.appendChild(li);
            }
        }

        if (ul.innerHTML == '') {
            let li = document.createElement('li');
            li.setAttribute('class', 'list-group-item');
            li.innerHTML = '<div><p class="text">No hay citas anteriores</p></div>';
            ul.appendChild(li);
        }
    }
}

function detalleCita(id) {

    let citas = JSON.parse(window.localStorage.getItem('cita'));
    let cita = '';

    for(var i=0;i<citas.length;i++) {
        if(citas[i].id == id) {
            cita = citas[i];
        }
    }

    if(cita !== '') {
        fetch("/detalle-cita")
        .then(response => {
            return response.text()
        })
        .then(data => {
            document.querySelector("#modal-content").innerHTML = data;
        });
    }
}

function detalleDialog() {
    let modal = document.getElementById("modal");
    let span = document.getElementsByClassName("close")[0];
    span.onclick = function() {
        modal.style.display = "none";
      }
    modal.style.display = "block";
}

window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }