<%-- 
    Document   : cadastropessoas
    Created on : 27 de ago de 2023, 19:45:33
    Author     : Caio Gustavo
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/cadastropessoas.css">
        <script type="text/javascript" src="js/cadastropessoas.js"></script>
        <title>Cadastro de Pessoas</title>
    </head>
    <body onload="iniciar()">
        <div class="container">
        <div class="form">
            <form action="/FGLV/VisualizarPorNomeGarcom" method="post">
                <div class="input-container">
                    <label for="nome">Nome da Pessoa:</label>
                    <input type="text" id="nome" name="nome" class="input-field" required>
                    <button type="submit" id="operacao" name="operacao" value="VISUALIZAR" class="button">Pesquisar</button>
                    <output id="msg" for="nome" >${msg}</output>
                </div>
            </form>
        </div>
    </div>
    </body>
</html>
