<%-- 
    Document   : consultapessoa
    Created on : 22 de ago de 2023, 22:14:35
    Author     : Caio Gustavo
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultados da Consulta</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.6/jquery.inputmask.min.js"></script>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                height: 100vh;
                background-image: url("imagens/imgindex.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                display: flex;
                flex-direction: column;
                align-items: flex-end;
            }

            .container {
                margin-top: 200px;
                margin-right: 50px;
                background-color: rgba(255, 255, 255, 0.8);
                padding: 20px;
                border-radius: 10px;
            }

            .result {
                display: flex;
                align-items: center;
                margin-bottom: 10px;
            }

            .result-label {
                font-weight: bold;
                width: 100px;
            }

            .result-input {
                width: 250px;
                padding: 5px;
            }

            .button {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                cursor: pointer;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <h2>Registros de Pessoas</h2>

            <div class="table-container">
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Login</th>
                        <th>Data de cadastro</th>
                        <th>Ações</th>
                    </tr>
                    <c:forEach var="garcom" items="${listaGarcons}" varStatus="id">
                        <tr id="${garcom.id}">
                            <td onclick="selecionar(${garcom.id})">${garcom.id}</td>
                            <td onclick="selecionar(${garcom.id})">${garcom.nome}</td>
                            <td>
                              
                              <%--<fmt:formatDate value="${pessoa.datanascimento.time}" pattern="dd/MM/yyyy" />--%>
                            </td>
                            <td onclick="selecionar(${garcom.id})" >${garcom.login}</td>
                            <td onclick="selecionar(${garcom.id})" >${garcom.dtCadastro}</td>

                            <td class="action-buttons">
                                <button class="save-button">Editar</button>
                                <button class="delete-button">Excluir</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        <script>
            function voltarParaIndex() {
                window.location.href = "index.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
        </script>
    </body>
</html>

