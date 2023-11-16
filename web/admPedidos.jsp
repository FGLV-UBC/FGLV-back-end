<%-- 
    Document   : admPedidos
    Created on : 14 de nov. de 2023, 17:35:31
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gerenciamento de Pedidos</title>
  <!-- Adicionando o Bootstrap 4 via CDN -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Gerenciamento de Pedidos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="logout()">Logout</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" onclick="irParaAdmProdutos()">Produtos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" onclick="irParaAdmHome()">Garçons</a>
      </li>
    </ul>
  </div>
</nav>

<section class="container my-4">
  <h2>Listagem de Pedidos</h2>
  <!-- Tabela com informações dos pedidos -->
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>ID do Pedido</th>
        <th>ID da Mesa</th>
        <th>Valor Total</th>
        <th>Pedido Pronto</th>
      </tr>
    </thead>
    <tbody>
      <!-- Os dados dos pedidos serão inseridos dinamicamente aqui -->
      <tr>
        <td>1</td>
        <td>3</td>
        <td>R$ 50.00</td>
        <td>Sim</td>
      </tr>
      <tr>
        <td>2</td>
        <td>5</td>
        <td>R$ 75.50</td>
        <td>Não</td>
      </tr>
      <!-- Adicione mais linhas conforme necessário -->
    </tbody>
  </table>
</section>

<!-- Adicionando o Bootstrap 4 JavaScript e o jQuery (necessários para o funcionamento dos modais) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
  
      function irParaAdmPedidos() {
        window.location.href = "admPedidos.jsp"; // Substitua com o caminho correto para sua página index
    }
    $(document).ready(function () {
        $('#data').inputmask();
    });
    
    function irParaAdmProdutos() {
        window.location.href = "admProdutos.jsp"; // Substitua com o caminho correto para sua página index
    }
    $(document).ready(function () {
        $('#data').inputmask();
    });
    
    function irParaAdmHome() {
        window.location.href = "admHome.jsp"; // Substitua com o caminho correto para sua página index
    }
    $(document).ready(function () {
        $('#data').inputmask();
    });
</script>

</body>
</html>

