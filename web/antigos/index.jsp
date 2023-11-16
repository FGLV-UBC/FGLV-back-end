<%-- 
    Document   : home
    Created on : 6 de nov. de 2023, 17:06:24
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Home</title>
    </head>
    <body>

        <div class="container d-flex justify-content-around" style="margin-top: 30vh;">
            <button class="btn btn-primary" onclick="irParaGarcom()">Ir para consulta de garçom</button>
            <button class="btn btn-primary" onclick="voltarParaListagemGarcom()">Ir para listagem de garçom</button>
            <button class="btn btn-primary" onclick="irParaCadastroGarcom()">Ir para cadastro de garçom</button>
            <button class="btn btn-primary" onclick="irParaCadastroGarcom()">Alteração ou deleção de garçom</button>
        </div>
        
        <script>
            function irParaCadastroGarcom() {
                window.location.href = "cadastroGarcom.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
            
            function voltarParaListagemGarcom() {
                window.location.href = "listarGarcons.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
            function irParaGarcom() {
                window.location.href = "consultapessoa.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
        </script>


        
    </body>
</html>
