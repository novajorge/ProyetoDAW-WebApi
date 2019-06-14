<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map, bbdd.*, daos.*, java.io.*, java.sql.Connection" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<% Map<String, String> menuAdminJson =  (Map<String, String>) session.getAttribute("menuAdmin"); %>

  <ul id="slide-out" class="sidenav sidenav-fixed">
    <li><div class="user-view">
      <div class="background">
        <img src="resources/images/email-pattern.png">
      </div>
      
      <a id ="abrirCuenta" class="waves-effect modal-trigger" href="#cuenta"><%= menuAdminJson.get("menu5") %></a>
      <a href=""><img class="circle" src="resources/images/profile.png"></a>
      <a href=""><span class="name"><%= session.getAttribute("usuario") %></span></a>
      <a href=""><span class="email"><%= session.getAttribute("email") %></span></a>
    </div></li>
    <li><a class="subheader" ><%= menuAdminJson.get("menu8") %></a></li>
    <li><div class="divider"></div></li>
    <li><a href="#!" class=" dropdown-trigger" data-target="dropdown1"><i class="material-icons">bookmark</i><%= menuAdminJson.get("menu1") %><i class="material-icons right">arrow_drop_down</i></a></li>  
        <ul id='dropdown1' class='dropdown-content'>
	        <c:forEach items="${databaseList}" var="database">
		         <li class="onclickJquery">
		         <a value="${database.name}">Name:${database.name} </a>
		         <a value="${database.host}">Host:${database.host}:${database.puerto}</a></li>
		         <div class="divider"></div>
		         
	   	 	</c:forEach>
    	</ul>
    <li><a class="modal-trigger" href="#modal1"><i class="material-icons">add_circle_outline</i><%= menuAdminJson.get("menu2") %></a>
    
    <li><div class="divider"></div></li>
    
    <li><a href="#!" class=" dropdown-trigger" data-target="dropdown2"><i class="material-icons">business</i><%= menuAdminJson.get("menu3") %><i class="material-icons right">arrow_drop_down</i></a></li>
    <ul id='dropdown2' class='dropdown-content'>

    </ul>
    <li><a class="subheader"><i class="material-icons">add_circle_outline</i><%= menuAdminJson.get("menu4") %></a></li>
    <li><div class="divider"></div></li>
    
    <li><a class="waves-effect" href="LogoutSesion"><%= menuAdminJson.get("menu6") %></a></li>
    
  </ul>
