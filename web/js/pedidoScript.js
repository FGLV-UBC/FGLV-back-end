/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function incrementarQuantidade() {
    var quantidadeInput = document.getElementById("quantidade");
    quantidadeInput.value = parseInt(quantidadeInput.value) + 1;
}

function decrementarQuantidade() {
    var quantidadeInput = document.getElementById("quantidade");
    if (parseInt(quantidadeInput.value) > 1) {
        quantidadeInput.value = parseInt(quantidadeInput.value) - 1;
    }
}

function adicionarAoPedido(){
    document.getElementById("quantidade").value = 0;

}

function excluirDoPedido(){}