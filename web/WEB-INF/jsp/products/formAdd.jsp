<%-- 
    Document   : form
    Created on : 25/03/2012, 22:26:08
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
        <form action="add">
            <fieldset>
            
                <legend>Adicionar Produto</legend>
                <label for="nome">Nome:</label>
                
                <input id="name" type="text" name="product.name"/>
                <label for="descricao">Descrição:</label>
                
                <textarea id="description" name="product.description"></textarea>
                <label for="preco">Preço:</label>
                
                <input id="price" type="text" name="product.price"/>
                <button type="submit">Enviar</button>
            
            </fieldset>
        </form>

    </body>
</html>
