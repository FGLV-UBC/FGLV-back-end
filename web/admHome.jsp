<%-- 
    Document   : admHome
    Created on : 14 de nov. de 2023, 17:35:03
    Author     : USER
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!-- 
Informações de todos garçons e podendo excluir um funcionário 
através de um modal que abre quando clica no símbolo de lixeira
(Deve ter logout a no menu superior);
Opção de cadastrar novo funcionário acima da listagem de garçons 
-->

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Administração</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Gerenciamento de Garçons</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="logout()">Logout</a>
      </li>
      <form action="/FGLV/ConsultarProduto" method="post">
            <input class="invisible" name="direcionadorTela" id="direcionadorTela" readonly value="adm">

              <button class="btn btn-primary" type="submit" id="operacao" name="operacao" value="CONSULTAR">Ir para Produtos</button>
                </div>
            </form>
      <li class="nav-item">
          <a class="nav-link" onclick="irParaAdmPedidos()">Pedidos</a>
      </li>
    </ul>
  </div>
</nav>

<section class="container my-4">
  <h2>Cadastrar Novo Funcionário</h2>
  <form id="formCadastro" action="/FGLV/SalvarGarcom" method="POST">
      <output style="color:red;" id="msg">${Mensagem}</output>

    <div class="form-group">
      <label for="nome">Nome:</label>
      <input type="text" class="form-control" id="nome" name="nome" required>
    </div>

    <div class="form-group">
      <label for="login">Login:</label>
      <input type="text" class="form-control" id="login" name="login" required>
    </div>

    <div class="form-group">
      <label for="senha">Senha:</label>
      <input type="password" class="form-control" id="senha" name="senha" required>
    </div>


      <button type="submit" id="operacao" name="operacao" value="SALVAR" class="btn btn-primary" >Cadastrar</button>
  </form>
</section>

<section class="container my-4">
  <h2>Lista de Garçons</h2>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Login</th>
        <th>Senha</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="garcom" items="${listaGarcons}" varStatus="id">
    
        <tr id="${garcom.id}">
          <td>${garcom.id}</td>
          <td id="nome" name="nome">${garcom.nome}</td>
          <td>${garcom.login}</td>
          <td>${garcom.senha}</td>
          <td>
            
              
            <button class="btn btn-primary" onclick="abrirModalAlterar(${garcom.id})">Atualizar</button>
            <button class="btn btn-danger" onclick="abrirModalExcluir(${garcom.id})">Excluir</button>
          </td>
          
          <div id="modalAlterar${garcom.id}" class="modal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Alterar Dados do Garçom</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <!-- Adicione os campos para mostrar os dados atuais e permitir a alteração -->

                  <form action="/FGLV/AlterarGarcom" method="PUT" >
                      <label for="id" name="id" id="id">ID do Garçom: ${garcom.id}</label>
                      <input class="invisible" name="id" id="id" readonly value="${garcom.id}">
                      <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="${garcom.nome}" required>
                      </div>
                      <div class="form-group">
                        <label for="login">Login:</label>
                        <input type="text" class="form-control" id="login" name="login" value="${garcom.login}" required>
                      </div>
                      <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="text" class="form-control" id="senha" name="senha" value="${garcom.senha}">
                      </div>

                    </div>
                    <div class="modal-footer">
                      <button type="submit" class="btn btn-primary" id="operacao" name="operacao" value="ALTERAR">Salvar Alterações</button>
                      <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="fecharModalAlterar()">Cancelar</button>
                    </div>
                  </form>
              </div>
            </div>
        </div>

        </tr>
        
        <form action="/FGLV/ExcluirGarcom" method="DELETE" >
            <div id="modalExcluir${garcom.id}" class="modal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-body">
                      <p>Deseja realmente excluir o funcionário com id ${garcom.id} ?</p>
                    </div>
                    <div class="modal-footer">

                        <input class="invisible" name="id" id="id" readonly value="${garcom.id}">
                        <button class="btn btn-danger" type="submit" id="operacao" name="operacao" value="EXCLUIR">Sim</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="fecharModal()">Não</button>
                    </div>
                  </div>
                </div>
            </div>
        </form>

    </c:forEach>
    
    </tbody>
  </table>
</section>
 
<!-- Modal para confirmar exclusão -->
<div id="modalExcluir" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <p>Deseja realmente excluir este funcionário?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="excluirFuncionario()">Sim</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="fecharModal()">Não</button>
      </div>
    </div>
  </div>
</div>


<!-- Modal para alteração -->



<!-- Adicionando o Bootstrap 4 JavaScript e o jQuery (necessários para o funcionamento dos modais) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
  // Função para abrir o modal de exclusão
  function abrirModalExcluir(idGarcom) {
    $('#modalExcluir' + idGarcom).modal('show');
  }

  // Função para fechar o modal de exclusão
  function fecharModalExcluir() {
    $('#modalExcluir').modal('hide');
  }



  function abrirModalAlterar(idGarcom) {
    
        // Abrir o modal específico
    $('#modalAlterar' + idGarcom).modal('show');
  }

  function fecharModalAlterar() {
    $('#modalAlterar').modal('hide');
  }



  // Função para cadastrar um novo funcionário
  function cadastrarFuncionario() {


    // Limpar os campos do formulário
    $('#formCadastro')[0].reset();
  }

  // Função para excluir um funcionário
  function excluirFuncionario() {
   
    fecharModalExcluir();
  }

  function alterarGarcom() {

    fecharModalAlterar();
  }
  
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