//permite el menu en modo movil
$(document).ready(function() {
	$('.sidenav').sidenav();
});
// permite que funcione el modalLogin
$(document).ready(function() {
	$('.modal').modal();
});

// eventos modal, moverse en el menu
$(document).ready(function() {
	$('label').addClass("active");
	$("#registerIn").hide();
	$("#recuperarContrasenaIn").hide();
	$('.carousel.carousel-slider').carousel({
		fullWidth : true,
		indicators : true
	});
	$("#registrateButton").click(function() {
		if ($("#showRegister").hasClass("active")) {

		} else {
			$("#showRegister").addClass("active");
			$("#registerIn").show();
			$("#showLogin").removeClass("active");
			$("#loginIn").hide();
			$("#recuperarContrasenaIn").hide();
		}
	});
	$("#showLogin").click(function() {
		if ($("#showLogin").hasClass("active")) {

		} else {
			$("#showLogin").addClass("active");
			$("#loginIn").show();
			$("#showRegister").removeClass("active");
			$("#recuperarContrasenaIn").hide();
			$("#registerIn").hide();
		}
	});
	$("#showRegister").click(function() {
		if ($("#showRegister").hasClass("active")) {

		} else {
			$("#showRegister").addClass("active");
			$("#registerIn").show();
			$("#showLogin").removeClass("active");
			$("#loginIn").hide();
			$("#recuperarContrasenaIn").hide();
		}
	});
	$("#showRecuperarContrasena").click(function() {
		if ($("#showRecuperarContrasena").hasClass("active")) {
			console.log("dsadas");
		} else {
			$("#showRecuperarContrasena").addClass("active");
			$("#recuperarContrasenaIn").show();
			$("#showLogin").removeClass("active");
			$("#showRegister").removeClass("active");
			$("#loginIn").hide();
			$("#registerIn").hide();
			console.log("dsadas");
		}
	});
	// //////////////////

	$('#cardDatabase').hide();
	// sidenav haciendo que se habra sola.
	$('.sidenav').sidenav();
	$('.sidenav').sidenav('open');
	// menu dinamicos en en el sidenav
	$('.dropdown-trigger').dropdown();
	$('.dropdown-trigger').dropdown({
		coverTrigger : false,
		alignment : 'right'
	});
	// Apertura de un modal para añadir bases de datos
	$('#modal1').modal({
		endingTop : '4%'
	});
	$('#modal1').modal();
	$('#modal2').modal();
	$('#cuenta').modal();
	$('label').addClass("active");

	$('#abrirCuenta').click(function() {
		$.ajax({
			url : 'getUserInfo',
			success : function(responseText) {

				var usuario = responseText;
				console.log(usuario);
				// form placeholder and value for modify
				$('#userINfo input#name').val(usuario.nombre);
				$('#userINfo input#email').val(usuario.correo);
				if (usuario.empresa != null) {
					$('#userINfo input#empresa').val(usuario.empresa);
				}
			}
		});
	});

	$('#selectTypes').formSelect();
	$('#selectTypes2').formSelect();
	// metodos que muestra una card
	$('.onclickJquery').click(function() {

		$.ajax({
			url : 'GetDatabaseInfo',
			data : {
				name : $($(this).children("a")[0]).attr("value"),
				host : $($(this).children("a")[1]).attr("value")
			},
			success : function(responseText) {
				console.log(responseText);
				var database = responseText;
				$('#cardDatabase .card-title').text(database.name);
				$('#cardDatabase p').text(database.description);

				// form placeholder and value for modify
				$('#UpdateDatabase input#name').val(database.name);
				$('#UpdateDatabase input#host').val(database.host);
				$('#UpdateDatabase input#desc').val(database.description);
				$('#UpdateDatabase input#port').val(database.puerto);
				$('#UpdateDatabase input#active').val(database.activa);
				$('#UpdateDatabase input#user').val(database.usuario);
				$('#UpdateDatabase input#pass').val(database.password);

				$('#UpdateDatabase input#oldName').val(database.name);
				$('#UpdateDatabase input#oldHost').val(database.host);
				$('#UpdateDatabase input#oldCorreo').val(database.correo);
				$('#UpdateDatabase input#schema').val(database.schema);
				// form for delete
				$('#modal2 #delDatabase #name').val(database.name);
				$('#modal2 #delDatabase #host').val(database.host);

				$('#cardDatabase').show();

			}
		});
	});

	$('#testDatabaseNew').click(function() {
		console.log("esdsdasdasd");
		$.ajax({
			url : 'pingDatabase',
			data : {
				host : $('#addDatabase  input#host').val(),
				type : $('#addDatabase  #selectTypes2').val(),
				port : $('#addDatabase  input#port').val(),
				schema : $('#addDatabase  input#schema').val(),
				user : $('#addDatabase  input#user').val(),
				pass : $('#addDatabase  input#pass').val()

			},
			success : function(response) {
				console.log("success");
				console.log(JSON.stringify(response));
				M.toast({
					html : 'DATABASE PING!',
					classes : 'green'
				});

			},
			error : function(response) {
				console.log("error");
				console.log(JSON.stringify(response));
				M.toast({
					html : 'DATABASE DONT PING!',
					classes : 'red'
				});
			}
		});
	});
	$('#pingDatabaseForm').click(function() {

		$.ajax({
			url : 'pingDatabase',
			data : {
				host : $('#UpdateDatabase  input#host').val(),
				type : $('#UpdateDatabase  #selectTypes').val(),
				port : $('#UpdateDatabase  input#port').val(),
				schema : $('#UpdateDatabase  input#schema').val(),
				user : $('#UpdateDatabase  input#user').val(),
				pass : $('#UpdateDatabase  input#pass').val()

			},
			success : function(response) {
				console.log("success");
				console.log(JSON.stringify(response));
				M.toast({
					html : 'DATABASE PING!',
					classes : 'green'
				});

			},
			error : function(response) {
				console.log("error");
				console.log(JSON.stringify(response));
				M.toast({
					html : 'DATABASE DONT PING!',
					classes : 'red'
				});
			}
		});
	});
	
	
	//api 
	// $('#cardAPi');
	 $('#cardAPi card-title').text("lo que sea");

});
// eventos modal, moverse en el menu
