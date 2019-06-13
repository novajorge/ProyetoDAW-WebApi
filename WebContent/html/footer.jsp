<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.HashMap, java.util.Map" %>
<%@ page import="java.util.HashMap, java.util.Map" %>
<% Map<String, String> footerJson =  (Map<String, String>) session.getAttribute("footer"); %>
<% Map<String, String> menu1Json =  (Map<String, String>) session.getAttribute("menu"); %>
<footer class="page-footer"> 
   <div class="container">
     <div class="row">
       <div class="col l6 s12">
         <h5 class="white-text"> <%= footerJson.get("footer1")  %></h5>
         <p class="grey-text text-lighten-4"><%= footerJson.get("footer2")  %></p>
       </div>
       <div class="col l4 offset-l2 s12">
         <h5 class="white-text">Links</h5>
         <ul>
           <li><a class="grey-text text-lighten-3" href="https://github.com/novajorge/ProyetoDAW-WebApi"><%= menu1Json.get("menu1")  %></a></li>
           <li><a class="grey-text text-lighten-3" href="#!"><%= menu1Json.get("menu2")  %></a></li>
           <li><a class="grey-text text-lighten-3" href="#!"><%= menu1Json.get("menu3")  %></a></li>
         </ul>
       </div>
     </div>
   </div>
   <div class="footer-copyright center-text">
     <div class="container">
     © 2019 Jorge Arroyo Rey
     </div>
   </div>
 </footer>