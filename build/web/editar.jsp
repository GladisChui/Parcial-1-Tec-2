<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${requestScope.op == 'nuevo'}" var="res" scope="request">
                Registro de
            </c:if>
            <c:if test="${requestScope.op == 'modificar'}" var="res" scope="request">
                Modificar
            </c:if>
            Vacunados
        </h1>
        
        <jsp:useBean id="miVacuna" scope="request" class="com.emergentes.modelo.Vacunas_gChui" />
            
     
        
        <form action="Controller" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" 
                               value="<jsp:getProperty name="miVacuna" property="id" />">               
                    </td> 
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" 
                               value="<jsp:getProperty name="miVacuna" property="nombre" />">               
                    </td> 
                </tr>

                <tr>
                    <td>Peso</td>
                    <td><input type="text" name="peso" 
                               value="<jsp:getProperty name="miVacuna" property="peso" />">               
                    </td> 
                </tr>  

                <tr>
                    <td>Talla</td>
                    <td><input type="text" name="talla" 
                               value="<jsp:getProperty name="miVacuna" property="talla" />">               
                    </td> 
                </tr>                  

                <tr>
                    <td>Vacunado</td>
                    <td><input type="text" name="vacuna" 
                               value="<jsp:getProperty name="miVacuna" property="vacuna" />">               
                    </td> 
                </tr>   
                <tr>
                    <td>
                        <input type="hidden" name="opg" value="${requestScope.op}" />
                        <input type="hidden" name="op" value="grabar" />
                    </td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
                
            </table>


        </form>
    </body>
</html>
