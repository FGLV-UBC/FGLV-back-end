<%-- 
    Document   : cardapio
    Created on : 18 de out. de 2023, 17:06:57
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>UBC Lanchonete</title>
   
</head>
<body>
    <!-- <header class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Meu Site</a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Link 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link 2</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link 3</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Link Direito</a>
            </li>
        </ul>
    </header> -->

    <div class="container-fluid">
        <div class="row">
            
            <div class="col-md-10">
                <div class="h2 m-5">
                    Lanches
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/hamburguer.jpg" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Hambúrguer Teste</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>
                    
                                <p class="card-text">X-Salada Bacon com queijo cheddar derretido e gratinado.</p>
                    
                                
                                
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                    
                            </div>
                        </div>
                    </div>

                    

                    
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/hamburguer.jpg" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Hambúrguer Teste</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>
                    
                                <p class="card-text">X-Salada Bacon com queijo cheddar derretido e gratinado.</p>
                    
                                
                                
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                    
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/hamburguer.jpg" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Hambúrguer Teste</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>
                    
                                <p class="card-text">X-Salada Bacon com queijo cheddar derretido e gratinado.</p>
                    
                                
                                
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                    
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/hamburguer.jpg" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Hambúrguer Teste</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>
                    
                                <p class="card-text">X-Salada Bacon com queijo cheddar derretido e gratinado.</p>
                    
                                
                                
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                    
                            </div>
                        </div>
                    </div>
                </div>

                <div class="h2 m-5">
                    Bebidas
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/coca.png" class="card-img-top" alt="Imagem 3" style="width: 100px; margin: 0 auto;">
                            <div class="card-body">
                                <h5 class="card-title">Coca-cola Lata</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Coca cola lata extremamente gelada.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/coca.png" class="card-img-top" alt="Imagem 3" style="width: 100px; margin: 0 auto;">
                            <div class="card-body">
                                <h5 class="card-title">Coca-cola Lata</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Coca cola lata extremamente gelada.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/coca.png" class="card-img-top" alt="Imagem 3" style="width: 100px; margin: 0 auto;">
                            <div class="card-body">
                                <h5 class="card-title">Coca-cola Lata</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Coca cola lata extremamente gelada.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/coca.png" class="card-img-top" alt="Imagem 3" style="width: 100px; margin: 0 auto;">
                            <div class="card-body">
                                <h5 class="card-title">Coca-cola Lata</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Coca cola lata extremamente gelada.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                </div>
                <div class="h2 m-5">
                    Cervejas
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Heineken.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Heineken 600ml</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Cerveja heineken 600ml geladinha.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Heineken.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Heineken 600ml</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Cerveja heineken 600ml geladinha.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Heineken.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Heineken 600ml</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Cerveja heineken 600ml geladinha.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Heineken.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Heineken 600ml</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Cerveja heineken 600ml geladinha.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                </div>
                <div class="h2 m-5">
                    Acompanhamentos
                </div>

                
                <div class="row">
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Batata_Frita.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Porção de Batata Frita</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Porção de batata frita.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Batata_Frita.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Porção de Batata Frita</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Porção de batata frita.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Batata_Frita.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Porção de Batata Frita</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Porção de batata frita.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card mb-3">
                            <img src="imagens/Batata_Frita.png" class="card-img-top" alt="Imagem 3">
                            <div class="card-body">
                                <h5 class="card-title">Porção de Batata Frita</h5>
                                <p class="card-subtitle">R$: 99,99</p><br>

                                <p class="card-text">Porção de batata frita.</p>
                                <div class="input-group input-group-sm my-3" style="width: 100px; margin: 0 auto">
                                    
                                    <div class="input-group-prepend">
                                        <button type="button" class="btn btn-primary" onclick="decrementarQuantidade()">-</button>
                                    </div>
                                    <input type="number" id="quantidade" name="quantidade" class="form-control text-center" value="0">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="incrementarQuantidade()">+</button>
                                    </div>

                                </div>
                                <button type="button" class="card-link btn btn-primary btn-block mt-3" onclick="adicionarAoPedido()">Adicionar ao pedido</button>

                            
                            </div>
                            

                        </div>
                    </div>
                </div>


            </div>

            
            <!-- Pedido -->
            <div class="col-md-2 " style="background-color: antiquewhite;">
                
                <div class="position-fixed">
                    <div class="h2 m-5">
                        Pedido
                    </div>
                    <div class="card my-3">
                        <div class="card-body">
                            <h5 class="card-title">Porção de Batata Frita</h5>
                            
                            <p class="card-subtitle mb-2">R$: 99,99</p>

                            <div class="d-flex">
                                <button type="button" class=" card-link btn btn-danger" style="width: 100px;">Exluir</button>
                                <button type="button" class=" card-link btn btn-info" style="width: 100px;">Alterar</button>
                            </div>                        
                        </div>
                        

                    </div>
                    <div class="card my-3">
                        <div class="card-body">
                            <h5 class="card-title">Hambúrguer Teste</h5>
                            
                            <p class="card-subtitle mb-2">R$: 99,99</p>

                            <div class="d-flex">
                                <button type="button" class=" card-link btn btn-danger" style="width: 100px;">Exluir</button>
                                <button type="button" class=" card-link btn btn-info" style="width: 100px;">Alterar</button>
                            </div>
                            

                        
                        </div>
                        

                    </div>
                    <div class="card my-3">
                        <div class="card-body">
                            <h5 class="card-title">Coca-cola Lata</h5>
                            
                            <p class="card-subtitle mb-2">R$: 99,99</p>

                            <div class="d-flex">
                                <button type="button" class=" card-link btn btn-danger" style="width: 100px;">Exluir</button>
                                <button type="button" class=" card-link btn btn-info" style="width: 100px;">Alterar</button>
                            </div>
                            

                        
                        </div>
                        

                    </div>

                    <div class="text-center mx-auto">
                        <button class="btn btn-success">Confirmar pedido</button>
                    </div>
                </div>
            </div>
                    
        </div>
    </div>
    <footer class="text-center" style="background-color: antiquewhite;">Todos Direitos Reservados @ UBC Lanchonete</footer>

    <script src="script.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
