<%-- 
    Document   : update
    Created on : 25/03/2012, 23:16:54
    Author     : nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="updateit">
            <fieldset>
                <legend>Editar Produto</legend>
                
                <input type="hidden" name="product.id" value="${product.id }" />
                <label for="nome">Nome:</label>
                
                <input id="name" type="text" name="product.name" value="${product.name }"/>
                <label for="descricao">Descrição:</label>
                
                <textarea id="description" name="product.description">${product.description }</textarea>
                <label for="preco">Preço:</label>
                
                <input id="price" type="text" name="product.price" value="${product.price }"/>
                <button type="submit">Enviar</button>
            </fieldset>
        </form>

    </body>
</html>
