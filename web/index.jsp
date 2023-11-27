<%-- 
    Document   : index
    Created on : 14 de nov. de 2023, 18:11:13
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container d-flex justify-content-around" style="margin-top: 30vh;">
            <form action="/FGLV/ConsultarGarcom" method="post">
                <input class="invisible" name="direcionadorTela" id="direcionadorTela" readonly value="adm">
                <button class="btn btn-primary" onclick="irParaAdm()" type="submit" id="operacao" name="operacao" value="CONSULTAR">Ir para Adm</button>
            </form>
            
            <form action="/FGLV/ConsultarProduto" method="post">
                <input class="invisible" name="direcionadorTela" id="direcionadorTela" readonly value="cardapio">

                <button class="btn btn-primary" onclick="irParaCardapio()" type="submit" id="operacao" name="operacao" value="CONSULTAR">Ir para Cardápio</button>
            </form>
        </div>
        
        <script>
           
            function irParaAdm() {
                window.location.href = "admHome.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
            function irParaCardapio() {
                window.location.href = "pedidoCardapio.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
        </script>
    </body>
</html>
