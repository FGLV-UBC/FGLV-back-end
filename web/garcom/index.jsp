<%-- 
    Document   : index
    Created on : 14 de nov. de 2023, 17:48:03
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container d-flex justify-content-around" style="margin-top: 30vh;">
            <button class="btn btn-primary" onclick="irParaAdm()">Ir para Administrador</button>
            <button class="btn btn-primary" >Ir para listagem de garçom</button>
            <button class="btn btn-primary" >Ir para cadastro de garçom</button>
            <button class="btn btn-primary" >Alteração ou deleção de garçom</button>
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
            function irParaAdm() {
                window.location.href = "./administrador/admHome.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
        </script>
    </body>
</html>
