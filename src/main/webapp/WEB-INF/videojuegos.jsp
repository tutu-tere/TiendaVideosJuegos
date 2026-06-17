<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*, java.text.*" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!-- el prefijo c es para ir llamando a las funciones que tiene esta libreria -->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Videojuegos</title>
    <link rel="stylesheet" href="/css/styles.css">
  </head>
  <body>
    
    <%--<p>
      <c:out value="${mensaje}" /> 
      <!-- esto es para proteger el codigo  -->
    </p>
    <p>
      ${mensaje}
    </p>--%>

    <h1>Videojuegos</h1>
    <ul>
      <c:forEach var="videojuego" items="${videojuegos}">
        <li>Nombre: <b>${videojuego.nombre}</b>, Fecha de Lanzamiento: <b>${videojuego.fecha_lanzamiento}</b></li>
      </c:forEach>
    </ul>
  </body>
</html>
