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
	$("#showLogin").click(function(){
		  if($("#showLogin").hasClass("active")){
			  
		  }else{
			  $("#showLogin").addClass("active");
			  $("#loginIn").show();
			  $("#showRegister").removeClass("active");
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
		  }
		});
});
//eventos modal, moverse en el menu
