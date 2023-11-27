<%-- 
    Document   : pedidoConfirmar
    Created on : 27 de nov. de 2023, 13:56:55
    Author     : USER
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <title>Cardápio</title>
  <style>
    .card:hover {
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      transform: scale(1.05);
      transition: all 0.3s ease;
      cursor: pointer;
    };
    
  </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light d-flex text-center justify-content-center fixed-top">
        <a class="navbar-brand" href="#">Pedido</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                
                
                
                <form action="/FGLV/ConsultarProduto" method="post">
                    <input class="invisible" name="direcionadorTela" id="direcionadorTela" readonly value="cardapio">
                    <button class="btn btn-success" onclick="irParaPedidoCardapio()" type="submit" id="operacao" name="operacao" value="CONSULTAR">Cardápio</button>
                </form>
                    
            </a>
            </li>
          </ul>
        </div>
    </nav>
<br><br><br>
<div class="container" >
  <h1 class="my-4">Seu pedido</h1>

  <div class="row" >
    <div class="col-md-3">
      <div class="card">
        <div class="card-body" onclick="abrirModalConfirmar()">
          <h5 class="card-title">Produto 1</h5>
          <p class="card-text">Descrição do Produto 1.</p>
          <p class="card-text">R$ 10,00</p>
        </div>
      </div>
    </div>

    <div class="col-md-3">
      <div class="card">
        <div class="card-body" onclick="abrirModalConfirmar()">
          <h5 class="card-title">Produto 2</h5>
          <p class="card-text">Descrição do Produto 2.</p>
          <p class="card-text">R$ 15,00</p>
        </div>
      </div>
    </div>

    <div class="col-md-3">
      <div class="card">
        <div class="card-body" onclick="abrirModalConfirmar()">
          <h5 class="card-title">Produto 3</h5>
          <p class="card-text">Descrição do Produto 3.</p>
          <p class="card-text">R$ 20,00</p>
        </div>
      </div>
    </div>

    <div class="col-md-3">
      <div class="card">
        <div class="card-body" onclick="abrirModalConfirmar()">
          <h5 class="card-title">Produto 4</h5>
          <p class="card-text">Descrição do Produto 4.</p>
          <p class="card-text">R$ 25,00</p>
        </div>
      </div>
    </div>
  </div>

</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

  


    <div id="modalProdutoEspecifico" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form action="/FGLV/SalvarItemPedido" method="PUT" >

                    <div class="modal-header">
                        <h5 class="modal-title">${produto.nome}</h5>
                        <input class="invisible" name="id" id="id" readonly value="${produto.id}">

                        <input class="invisible" name="nome" id="nome" readonly value="${produto.nome}">

                        <input class="invisible" name="categoria" id="categoria" readonly value="${produto.categoria}">

                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">

                        
                        <div class="form-group">
                            <label for="descricao">Descrição:</label>
                            <label for="descricao">${produto.descricao}</label>
                            <input type="text" class="invisible" id="descricao" name="descricao" readonly value="${garcom.nome}" required>
                        </div>
                        <div class="form-group">
                            <label for="valor">Valor:</label>
                            <label for="descricao">${produto.valor}</label>
                        </div>
                        <div class="form-group">
                            <label for="quantidade">Quantidade:</label>
                            <input class="text-center" style="width: 50px;" type="number" min="1"name="" id="">
                        </div>
                        

                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" id="operacao" name="operacao" value="SALVAR">Adicionar ao pedido</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="fecharModalConfirmar()">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

  

  <footer class="page-footer font-small" style="background-color: rgb(179, 179, 179); margin-top: 100px;">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2023 Copyright:
      <a href="/"> FGLV</a>
    </div>
    <!-- Copyright -->
  
  </footer>

  <script>
    function abrirModalConfirmar() {
    
        $('#modalProdutoEspecifico').modal('show');
    }

    function fecharModalConfirmar() {
        $('#modalProdutoEspecifico').modal('hide');
    }
    
    function irParaPedidoCardapio() {
        window.location.href = "pedidoCardapio.jsp"; // Substitua com o caminho correto para sua página index
    }
    $(document).ready(function () {
        $('#data').inputmask();
    });
    
  </script>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

