$( "#buttonLogin" ).click(function(event) {
	event.preventDefault();
	let numColegiado = $('#numColegiado').val();

	if(numColegiado) {
		window.localStorage.setItem('numColegiado', numColegiado);
		isDoctor(numColegiado);
		datosPaciente();
		window.location = 'http://localhost:8081/medico';
	} else {
		cargarUsuario();
		datosPaciente();
		window.location = 'http://localhost:8081/paciente';
	}

	//let usuario = JSON.parse(window.localStorage.getItem('usuario'));
	//let paciente = JSON.parse(window.localStorage.getItem('paciente'));

});

function cargarUsuario() {

	let pass = $('#logininputpassword').val();
	let login = $('#loginuser').val();

	if(!login || !pass) {
		alert('Debe rellenar todos los campos');
		return false;
	}

	let loginValue = '{"namelogin":"' + login + '", "clave":"' + pass + '"}';

	$.ajax({
		contentType: 'application/json',
		data: loginValue,
		success: function(data) {
			if(data) {
				console.log(data);
				let usuario = JSON.stringify(data);
				window.localStorage.setItem('usuario', usuario);
			} else {
				alert('Usuario no válido');
			}
		},
		error: function(xhr, textStatus, error){
			console.log(xhr.responseText);
			console.log(xhr.statusText);
			console.log(textStatus);
			console.log(error);
		},
		processData: false,
		url: '/usuario/login',
		type: 'POST',
		beforeSend: function(xhr) {
			xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('access_token'));
		},
	});
}

function isDoctor(numColegiado) {
	
	let usuario = JSON.parse(window.localStorage.getItem('usuario'));

	$.ajax({
		contentType: 'application/json',
		data: usuario.id,
		success: function(data) {
			if(data) {
				console.log(data);
				let medic = JSON.stringify(data);
				let medico = JSON.parse(medic);
				if((medico.numColegiado != null || medico.numColegiado != undefined) && 
						(numColegiado == medico.numColegiado)) {
					window.localStorage.setItem('medico', medico);					
				}
			} else {
				alert('Usuario no válido');
			}
		},
		error: function(xhr, textStatus, error){
			console.log(xhr.responseText);
			console.log(xhr.statusText);
			console.log(textStatus);
			console.log(error);
		},
		processData: false,
		url: '/medico/colegiado?numColegiado=' + numColegiado,
		type: 'GET',
		beforeSend: function(xhr) {
			xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('access_token'));
		},
	});
}

function datosPaciente() {

	let usuario = JSON.parse(window.localStorage.getItem('usuario'));

	$.ajax({
		contentType: 'application/json',
		data: usuario.id,
		success: function(data) {
			if(data) {
				console.log(data);
				let paciente = JSON.stringify(data);
				if(paciente != null || paciente != undefined) {
					window.localStorage.setItem('paciente', paciente);					
				}
			} else {
				alert('Usuario no válido');
			}
		},
		error: function(xhr, textStatus, error){
			console.log(xhr.responseText);
			console.log(xhr.statusText);
			console.log(textStatus);
			console.log(error);
		},
		processData: false,
		url: '/paciente/find?paciente=' + usuario.id,
		type: 'GET',
		beforeSend: function(xhr) {
			xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('access_token'));
		},
	});
}