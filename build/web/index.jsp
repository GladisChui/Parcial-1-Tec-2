<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Vacunas_gChui"%>
<%@page import="com.emergentes.modelo.GestorVacunas_gChui"%>
<%
    if (session.getAttribute("vacun") == null)
    {
        GestorVacunas_gChui objeto1 = new GestorVacunas_gChui();
        
        objeto1.insertarVacuna(new Vacunas_gChui(1, "Braulio Diaz",25, 140, "Si"));
        
        session.setAttribute("vacun", objeto1);
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vacunas jPaxi</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>
                    <p>PRIMER PARCIAL TEM-742</p>
                    <p>Nombre: Gladis Andrea Chui Cruz</p>
                    <p>CI: 8296420</p>
                </th>
            </tr>
        </table>
        
        <h1>Registro de Vacunas</h1>
        
        <a href="Controller?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Talla</th>
                <th>Vacuna</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.vacun.getLista()}">    
            <tr>
                <th>${item.id}</th>
                <th>${item.nombre}</th>
                <th>${item.peso}</th>
                <th>${item.talla}</th>
                <th>${item.vacuna}</th>
                <th><a href="Controller?op=modificar&id=${item.id}">Editar</a></th>
                <th><a href="Controller?op=eliminar&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a></th>
            </tr>                           
            </c:forEach>        
        </table>
    </body>
</html>
