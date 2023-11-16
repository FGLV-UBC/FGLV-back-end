<%-- 
    Document   : gerenciamentoGarcom
    Created on : 18 de out. de 2023, 17:12:26
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gerenciamento de Pedidos</title>
    <!-- Inclua as folhas de estilo do Bootstrap e os scripts do Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <h1>Gerenciamento de Pedidos</h1>

        <!-- Botão para Ver Meus Dados com ID "verMeusDadosBtn" -->
        <button class="btn btn-primary mb-3" id="verMeusDadosBtn">
            Ver Meus Dados
        </button>

        <ul class="list-group" id="mesas">
            <li class="list-group-item">
                Mesa: 1
                <ul>
                    <li>Pedido 1: Pizza</li>
                    <li>Pedido 2: Refrigerante</li>
                </ul>
                <button class="btn btn-success ver-produtos">Ver Produtos</button>
                <button class="btn btn-danger fechar-mesa">Fechar Mesa</button>
            </li>
            <li class="list-group-item">
                Mesa: 2
                <ul>
                    <li>Pedido 1: Hambúrguer</li>
                    <li>Pedido 2: Batata Frita</li>
                </ul>
                <button class="btn btn-success ver-produtos">Ver Produtos</button>
                <button class="btn btn-danger fechar-mesa">Fechar Mesa</button>
            </li>
            <!-- Adicione outras mesas aqui -->
        </ul>
    </div>

    <!-- Modal para Ver Produtos -->
    <div class="modal fade" id="verProdutosModal" tabindex="-1" aria-labelledby="verProdutosModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="verProdutosModalLabel">Produtos da Mesa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" id="produtosDaMesa">
                    <!-- Aqui você pode adicionar dinamicamente os produtos da mesa -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal de Confirmação para Fechar Mesa -->
    <div class="modal fade" id="confirmacaoFecharMesaModal" tabindex="-1" aria-labelledby="confirmacaoFecharMesaModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmacaoFecharMesaModalLabel">Confirmar Fechamento da Mesa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>A mesa já foi paga?</p>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="paga" id="pagaSim" value="sim">
                        <label class="form-check-label" for="pagaSim">
                            Sim
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="paga" id="pagaNao" value="nao">
                        <label class="form-check-label" for="pagaNao">
                            Não
                        </label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-success" id="confirmarFecharMesaBtn">Confirmar</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal para Ver Meus Dados -->
    <div class="modal fade" id="meusDadosModal" tabindex="-1" aria-labelledby="meusDadosModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="meusDadosModalLabel">Meus Dados</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form class="form-container" action="/FGLV/AlterarGarcom" method="POST">
                        <div class="mb-3">
                            <label for="nome" class="form-label">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nome" value="${nome}" required>
                        </div>
                        <div class="mb-3">
                            <label for="login" class="form-label">Login</label>
                            <input type="text" class="form-control" id="login" name="login" value="${login}">
                        </div>
                        <div class="mb-3">
                            <label for="senha" class="form-label">Senha</label>
                            <input type="text" class="form-control" id="senha" name="senha" value="${senha}">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                    <button type="button" class="btn btn-primary" a>Salvar Alterações</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        // Adicione um ouvinte de evento ao botão "Ver Meus Dados" para abrir o modal
        document.getElementById("verMeusDadosBtn").addEventListener("click", function() {
            var meusDadosModal = new bootstrap.Modal(document.getElementById('meusDadosModal'));
            meusDadosModal.show();
        });

        // Adicione um ouvinte de evento aos botões "Ver Produtos" para abrir o modal de produtos
        var verProdutosButtons = document.querySelectorAll(".ver-produtos");
        verProdutosButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                var produtosDaMesa = this.parentElement.querySelector("ul").cloneNode(true);
                document.getElementById("produtosDaMesa").innerHTML = "";
                document.getElementById("produtosDaMesa").appendChild(produtosDaMesa);
                var verProdutosModal = new bootstrap.Modal(document.getElementById('verProdutosModal'));
                verProdutosModal.show();
            });
        });

        // Adicione um ouvinte de evento aos botões "Fechar Mesa" para abrir o modal de confirmação
        var fecharMesaButtons = document.querySelectorAll(".fechar-mesa");
        fecharMesaButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                var verProdutosButton = this.parentElement.querySelector(".ver-produtos");
                verProdutosButton.setAttribute("disabled", true);
                var confirmacaoFecharMesaModal = new bootstrap.Modal(document.getElementById('confirmacaoFecharMesaModal'));
                confirmacaoFecharMesaModal.show();
            });
        });

        // Adicione um ouvinte de evento ao botão "Confirmar" no modal de confirmação para fechar a mesa
        document.getElementById("confirmarFecharMesaBtn").addEventListener("click", function() {
            var mesa = document.querySelector(".ver-produtos[disabled]").parentElement;
            mesa.remove();
            var verProdutosButton = document.querySelector(".ver-produtos[disabled]");
            verProdutosButton.removeAttribute("disabled");
            var confirmacaoFecharMesaModal = new bootstrap.Modal(document.getElementById('confirmacaoFecharMesaModal'));
            confirmacaoFecharMesaModal.hide();
        });
    </script>
</body>
</html>
