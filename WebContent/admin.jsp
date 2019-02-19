<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% if(session.getAttribute("usuario") != null){ %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= session.getAttribute("usuario") %>
	<%= session.getCreationTime() %>
	<%= session.getLastAccessedTime() %>
<a href="index.jsp">volver index.jsp</a>
</body>
</html>
<% }else{  
		response.sendRedirect(request.getContextPath() + "/index.jsp");
 	} %>