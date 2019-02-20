//permite el menu en modo movil
$(document).ready(function(){
	$('.sidenav').sidenav();
});
//permite que funcione el modalLogin
$(document).ready(function(){
	$('.modal').modal();
});


//eventos modal, moverse en el menu
$(document).ready(function(){
    $("#registerIn").hide();
    $("#recuperarContrasenaIn").hide();
	$("#showLogin").click(function(){
		  if($("#showLogin").hasClass("active")){
			  
		  }else{
			    $("#showLogin").addClass("active");
			    $("#loginIn").show();
                $("#showRegister").removeClass("active");
                $("#recuperarContrasenaIn").hide();
			    $("#registerIn").hide();
		  }
		});
	$("#showRegister").click(function(){
		  if($("#showRegister").hasClass("active")){
			  
		  }else{
                $("#showRegister").addClass("active");
                $("#registerIn").show();
                $("#showLogin").removeClass("active");
                $("#loginIn").hide();
                $("#recuperarContrasenaIn").hide();
		  }
        });
	$("#showRecuperarContrasena").click(function(){
		  if($("#showRecuperarContrasena").hasClass("active")){
			  console.log("dsadas");
		  }else{
                $("#showRecuperarContrasena").addClass("active");
                $("#recuperarContrasenaIn").show();
                $("#showLogin").removeClass("active");
                $("#showRegister").removeClass("active");
                $("#loginIn").hide();
                $("#registerIn").hide();
                console.log("dsadas");
		  }
		});  
});
//eventos modal, moverse en el menu
