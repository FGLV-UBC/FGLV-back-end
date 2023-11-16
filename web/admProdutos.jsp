<%-- 
    Document   : admProdutos
    Created on : 14 de nov. de 2023, 17:35:20
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Administração</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Gerenciamento de Produtos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" onclick="logout()">Logout</a>
      </li>
      <li class="nav-item">
          <form action="/FGLV/ConsultarGarcom" method="post">
              <button class="btn btn-primary" onclick="irParaAdmHome()()" type="submit" id="operacao" name="operacao" value="CONSULTAR">Ir para Adm</button>
                </div>
            </form>
      </li>
      <li class="nav-item">
          <a class="nav-link" onclick="irParaAdmPedidos()()">Pedidos</a>
      </li>
    </ul>
  </div>
</nav>

<section class="container my-4">
  <h2>Cadastrar Novo Produto</h2>
  <!-- Formulário para cadastrar novo funcionário -->
  <form id="formCadastro">
    <div class="form-group">
      <label for="nome">Nome:</label>
      <input type="text" class="form-control" id="nome" name="nome" required>
    </div>

    <div class="form-group">
      <label for="login">Descrição:</label>
      <input type="text" class="form-control" id="login" name="login" required>
    </div>

    <div class="form-group">
      <label for="senha">Valor:</label>
      <input type="password" class="form-control" id="senha" name="senha" required>
    </div>

    <div class="form-group">
        <label for="categoria">Categoria:</label>
        <select class="form-control" id="categoria" name="categoria">
            <option>...</option>
            <option value="LANCHE">LANCHE</option>
            <option value="BEBIDA">BEBIDA</option>
            <option value="ACOMPANHAMENTO">ACOMPANHAMENTO</option>
            <option value="SOBREMESA">SOBREMESA</option>
        </select>
    </div>
    


    <button type="button" class="btn btn-primary" onclick="cadastrarFuncionario()">Cadastrar</button>
  </form>
</section>

<section class="container my-4">
  <h2>Lista de Produtos</h2>
  <!-- Tabela com informações dos garçons -->
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Valor</th>
        <th>Categoria</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <!-- Os dados dos garçons serão inseridos dinamicamente aqui -->

      <tr>
        <td>1</td>
        <td>Batata Frita</td>
        <td>500g de batata frita</td>
        <td>R$ 88.88</td>
        <td>ACOMPANHAMENTO</td>
        <td>
          <button class="btn btn-primary" onclick="abrirModalAlterar()">Atualizar</button>
          <button class="btn btn-danger" onclick="abrirModalExcluir()">Excluir</button>
        </td>

      </tr>
      <tr>
        <td>2</td>
        <td>X-Salada Bacon</td>
        <td>lorem ipsum bla blass</td>
        <td>R$ 88.88</td>
        <td>LANCHE</td>
        <td>
          <button class="btn btn-primary" onclick="abrirModalAlterar()">Atualizar</button>
          <button class="btn btn-danger" onclick="abrirModalExcluir()">Excluir</button>
        </td>

      </tr>
    </tbody>
  </table>
</section>

<!-- Modal para confirmar exclusão -->
<div id="modalExcluir" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-body">
          <p>Deseja realmente excluir este produto?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" onclick="excluirProduto()">Sim</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="fecharModal()">Não</button>
        </div>
      </div>
    </div>
  </div>
  
  
  <!-- Modal para alteração -->
  <div id="modalAlterar" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Alterar Dados do Produto</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" id="nomeAlterar" name="nomeAlterar" value="Nome Atual do Produto" required>
          </div>
          <div class="form-group">
            <label for="descricao">Descrição:</label>
            <input type="text" class="form-control" id="loginAlterar" name="loginAlterar" value="Descrição Atual do Produto" required>
          </div>
          <div class="form-group">
            <label for="valor">Valor:</label>
            <input type="number" class="form-control" id="senhaAlterar" name="senhaAlterar" value="Valor atual do Produto">
          </div>
          
          <div class="form-group">
            <label for="categoria">Categoria:</label>
            <select class="form-control" id="categoria" name="categoria">
                <option>...</option>
                <option value="LANCHE">LANCHE</option>
                <option value="BEBIDA">BEBIDA</option>
                <option value="ACOMPANHAMENTO">ACOMPANHAMENTO</option>
                <option value="SOBREMESA">SOBREMESA</option>
            </select>
          </div>
            
  
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" onclick="alterarProdutos()">Salvar Alterações</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="fecharModalAlterar()">Cancelar</button>
        </div>
      </div>
    </div>
  </div>
  
  
  <!-- Adicionando o Bootstrap 4 JavaScript e o jQuery (necessários para o funcionamento dos modais) -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <script>
    // Função para abrir o modal de exclusão
    function abrirModalExcluir() {
      $('#modalExcluir').modal('show');
    }
  
    // Função para fechar o modal de exclusão
    function fecharModalExcluir() {
      $('#modalExcluir').modal('hide');
    }
  
  
  
    function abrirModalAlterar() {
      $('#modalAlterar').modal('show');
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
    function excluirProduto() {
     
      fecharModalExcluir();
    }
  
    function alterarProdutos() {
  
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
