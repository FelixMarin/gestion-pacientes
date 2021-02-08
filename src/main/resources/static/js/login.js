$( "#buttonLogin" ).click(function(event) {
	event.preventDefault();
	let numColegiado = $('#numColegiado').val();
	let numFuncional = $('#numFuncional').val();

	if(!validaLogin()) {
		alert('Login no válido');
		return false;
	}
	
	cargarUsuario();
	datosPaciente();
	
	if(numColegiado) {		
		isDoctor(numColegiado);		
		window.localStorage.setItem('numColegiado', numColegiado);
		window.location = 'http://localhost:8081/medico';		
	} else if(numFuncional) {
		isFuncional(numFuncional);
		window.localStorage.setItem('numFuncional', numFuncional);
		window.location = 'http://localhost:8081/funcional';
	} else {
		window.location = 'http://localhost:8081/paciente';
	}

	//let usuario = JSON.parse(window.localStorage.getItem('usuario'));
	//let paciente = JSON.parse(window.localStorage.getItem('paciente'));

});

function validaLogin() {
	
	let pass = $('#logininputpassword').val();
	let loginuser = $('#loginuser').val();

	return pass && loginuser;
}

function cargarUsuario() {
	
	if(!validaLogin()) {
		alert('Login no válido');
		return false;
	}

	let pass = $('#logininputpassword').val();
	let login = $('#loginuser').val();

	let loginValue = '{"namelogin":"' + login + '", "clave":"' + pass + '"}';

	$.ajax({
		contentType: 'application/json',
		async:false,
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
		async:false,
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

function isFuncional(numFuncional) {
	
	let usuario = JSON.parse(window.localStorage.getItem('usuario'));

	$.ajax({
		contentType: 'application/json',
		async:false,
		data: usuario.id,
		success: function(data) {
			if(data) {
				console.log(data);
				let func = JSON.stringify(data);
				let funcional = JSON.parse(func);
				if((funcional.numFuncional != null || funcional.numFuncional != undefined) && 
						(numFuncional == funcional.numFuncional)) {
					window.localStorage.setItem('funcional', funcional);					
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
		url: '/funcional/operador?numFuncional=' + numFuncional,
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
		async:false,
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