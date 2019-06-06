<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
	if (session.getAttribute("usuario") != null) {
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<!--  Imports de html y css en el head -->
<%@include file="resources/importsHead.html"%>
<!--  // Imports de html y css en el head // -->
<body style="background-image="url(/images/prims.png)">
	<%@ page import="translate.*"%>
	<%
		Traductor Idioma = new Traductor(request.getLocale().toString(), application.getRealPath("languajes"));
	%>
	<%
		session.setAttribute("menuAdmin", Idioma.getTranslate().get("menuAdmin"));
	%>

	<div class="row" >
		<div class="col s3">
			<!--  Menu web -->
			<%@include file="html/menuAdmin.jsp"%>
			<!-- // Menu web // -->
		</div>
		<div class="col s9">
			<!-- Modal Structure -->
			<div id="modal1" class="modal modal modal-fixed-footer">
				<%@include file="html/forms/addDatabase.jsp"%>
			</div>
			
			  <!-- Modal Structure -->
			  <div id="modal2" class="modal bottom-sheet">
			  <form id="delDatabase" action="DelDatabase" method="post">
			    <div class="modal-content">
			      <h5>¿Seguro que quieres eliminar esta Base de Datos?</h5>
			      
					<input type="text" id="name" name="name" class="hide">
					<input type="text" id="host" name="host" class="hide">
			    </div>
			    <div class="modal-footer">
			      <button class="modal-close waves-effect waves-light btn-small red left" type="submit" name="">Eliminar!</button>
			   </form>
			    </div>
			  </div>
          
			
			<div class="row" id="cardDatabase">
			    <div class="col s12">
			      <div class="card blue-grey darken-1">
			        <div class="card-content white-text">
			          <span class="card-title"></span>
			          <p></p>
			          
			          <div class="divider"></div>
			          
			          <%@include file="html/forms/formBaseDatos.jsp"%>
			          
			        </div>
			        <div class="card-action">		   
			          	<button class="waves-effect waves-light btn-small right" type="submit" name="submit">Actualizar!</button>
					</form> 
					  <!-- Modal Trigger -->
  					<a class="waves-effect waves-light btn modal-trigger red" href="#modal2">Eliminar</a>
						
			        </div>
			      </div>
			    </div>
			</div>
		</div>
	</div>
	</div>




	<script>
		$(document).ready(function() {
			$('#cardDatabase').hide();
			//sidenav haciendo que se habra sola.
			$('.sidenav').sidenav();
			$('.sidenav').sidenav('open');
			//menu dinamicos en en el sidenav
			$('.dropdown-trigger').dropdown();
			$('.dropdown-trigger').dropdown({
				coverTrigger : false,
				alignment : 'right'
			});
			//Apertura de un modal para añadir bases de datos
			$('.modal').modal();
			$('#modal2').modal();
			
			
			//metodos que muestra una card
			$('.onclickJquery').click(function() {

				$.ajax({
					url : 'GetDatabaseInfo',
					data : {
						name : $($( this ).children( "a" )[0]).attr("value"),
						host :  $($( this ).children( "a" )[1]).attr("value")
					},
					success : function(responseText) {
						console.log(responseText);
						var database = responseText;
						$('#cardDatabase .card-title').text(database.name);
						$('#cardDatabase p').text(database.description);
						
						//form placeholder and value for modify
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
						
						//form for delete
						$('#modal2 #delDatabase #name').val(database.name);
						$('#modal2 #delDatabase #host').val(database.host);
						
						$('#cardDatabase').show();
						
					}
				});
			});
		});
	</script>
	 <% if(session.getAttribute("DatabaseAdded") != null){ %>
 <script type="text/javascript">M.toast({html: 'Database Added!'}) </script>
 	<% session.setAttribute("DatabaseAdded", null);%>
 <%} %>
  <% if(session.getAttribute("DatabaseDelete") != null){ %>
 <script type="text/javascript">M.toast({html: 'Database Delete!' ,classes: 'red'}) </script>
 	<% session.setAttribute("DatabaseDelete", null); %>
 <%} %>
   <% if(session.getAttribute("DatabaseUpdate") != null){ %>
 <script type="text/javascript">M.toast({html: 'Database Update!' ,classes: 'blue'}) </script>
 	<% session.setAttribute("DatabaseUpdate", null); %>
 <%} %>
</body>
</html>
<%
	} else {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
%>