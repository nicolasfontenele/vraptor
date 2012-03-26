<%-- 
    Document   : listProducts
    Created on : 25/03/2012, 18:48:55
    Author     : nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>            
                <tr>
                    <td>Nome</td>
                    <td>Descricao</td>
                    <td>Preco</td>
                </tr>
             <c:forEach items="${productList}" var="product"> 
                <tr>
                    <td>${product.name }</td>
                    <td>${product.description }</td>
                    <td>${product.price }</td>
                    <td><a href="update?id=${product.id }">Editar</a></td>
                    <td><a href="remove?id=${product.id }">Remover</a></td>
                </tr>
             </c:forEach>        
    </table>

</body>
</html>
