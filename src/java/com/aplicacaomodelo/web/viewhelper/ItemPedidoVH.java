/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.ItemPedido;
import com.aplicacaomodelo.web.interfaces.IViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class ItemPedidoVH  implements IViewHelper{
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");
        ItemPedido itemPedido = new ItemPedido();
        
        if (operacao.equals("SALVAR")){
            //String id_pedido = request.getParameter("id_pedido");
            String nome = request.getParameter("nome");
            String valor = request.getParameter("valor");
            String categoria = request.getParameter("categoria");
            String quantidade = request.getParameter("quantidade");

            
            try {
                //itemPedido.setId_pedido(Integer.parseInt(id_pedido));
                itemPedido.setNome(nome);
                itemPedido.setValor(Double.parseDouble(valor));
                itemPedido.setCategoria(categoria);
                itemPedido.setQuantidade(Integer.parseInt(quantidade));
                
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("CONSULTAR")){
            String id_pedido = request.getParameter("id_pedido");
            String nome = request.getParameter("nome");
            String valor = request.getParameter("valor");
            String categoria = request.getParameter("categoria");
            String quantidade = request.getParameter("quantidade");

            
            try {
                itemPedido.setId_pedido(Integer.parseInt(id_pedido));
                itemPedido.setNome(nome);
                itemPedido.setValor(Double.parseDouble(valor));
                itemPedido.setCategoria(categoria);
                itemPedido.setQuantidade(Integer.parseInt(quantidade));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("ALTERAR")){
            String id = request.getParameter("id");
            
            String id_pedido = request.getParameter("id_pedido");
            String nome = request.getParameter("nome");
            String valor = request.getParameter("valor");
            String categoria = request.getParameter("categoria");
            String quantidade = request.getParameter("quantidade");

            
            try {
                itemPedido.setId( Integer.parseInt(id));
                
                itemPedido.setId_pedido(Integer.parseInt(id_pedido));
                itemPedido.setNome(nome);
                itemPedido.setValor(Double.parseDouble(valor));
                itemPedido.setCategoria(categoria);
                itemPedido.setQuantidade(Integer.parseInt(quantidade));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("EXCLUIR")){
            String id = request.getParameter("id");
            
            String id_pedido = request.getParameter("id_pedido");
            String nome = request.getParameter("nome");
            String valor = request.getParameter("valor");
            String categoria = request.getParameter("categoria");
            String quantidade = request.getParameter("quantidade");

            
            try {
                itemPedido.setId( Integer.parseInt(id));
                
                itemPedido.setId_pedido(Integer.parseInt(id_pedido));
                itemPedido.setNome(nome);
                itemPedido.setValor(Double.parseDouble(valor));
                itemPedido.setCategoria(categoria);
                itemPedido.setQuantidade(Integer.parseInt(quantidade));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
     return itemPedido;   
    }
    
    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(resultado.getMsg() != null){
            response.getWriter().write(resultado.getMsg());
            request.setAttribute("Mensagem", resultado.getMsg());
        
        }else{
            request.setAttribute("listaItemPedido", resultado.getEntidades());

        }
        
        

        request.getRequestDispatcher("pedidoConfirmar.jsp").forward(request, response);
    }
    
}
