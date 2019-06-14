<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <div class="row" id="cardAPi">
    <div class="col s12">
      <div class="card blue-grey darken-1">
        <div class="card-content white-text">
          <span class="card-title">Genera una nueva APi</span>
         	<h6>Selecciona la base de datos que deseas usar</h6>
         	  <div class="input-field col s5">
			    <select  id="databses">
			    </select>
			   
			  </div>
			  <div class="col s1">
			    <a  id="actualizarGenerador" class="waves-effect waves-light btn-large cyan pulse">Actualizar</a>
			  </div>
			  <div class="col s6">
			  </div>
				<div class="col s12 divider" style="margin-bottom: 10px;">
			  </div>
			  <div class="row"  id="dinamicContentDatabase">
			    <div class="card col s12 blue-grey darken-1">
				    <div class="card-content">
				      <spam>Database Selected Data.</spam>
				    </div>
				    <div class="card-tabs">
				      <ul id="menuCardApi" class="tabs tabs-fixed-width">
				      </ul>
				    </div>
				    <div  id="contenctDatabase" class="card-content">

				    </div>
			</div>
		</div>
        </div>
      </div>
    </div>
  </div>   