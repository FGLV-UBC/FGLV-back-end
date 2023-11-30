/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Pedido;
import com.aplicacaomodelo.web.interfaces.IViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class PedidoVH implements IViewHelper{
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");
        Pedido pedido = new Pedido();
        
        if (operacao.equals("SALVAR")){
            String id_mesa = request.getParameter("id_mesa");
            String valorTotalPedido = request.getParameter("valor_total_pedido");
            String pedidoPronto = request.getParameter("pedido_pronto");
            
            String pedidoFeito = request.getParameter("pedido_feito");

            
            try {
                pedido.setId_mesa(Integer.parseInt(id_mesa));
                pedido.setPedidoPronto(Boolean.parseBoolean(pedidoPronto));
                pedido.setPedidoFeito(Boolean.parseBoolean(pedidoFeito));

            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("CONSULTAR")){
            String id_mesa = request.getParameter("id_mesa");
            String valorTotalPedido = request.getParameter("valor_total_pedido");
            String pedidoPronto = request.getParameter("pedido_pronto");
            
            String pedidoFeito = request.getParameter("pedido_feito");

            
            try {
                pedido.setId_mesa(Integer.parseInt(id_mesa));
                pedido.setPedidoPronto(Boolean.parseBoolean(pedidoPronto));
                pedido.setPedidoFeito(Boolean.parseBoolean(pedidoFeito));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("ALTERAR")){
            String id = request.getParameter("id");
            
            String id_mesa = request.getParameter("id_mesa");
            String valorTotalPedido = request.getParameter("valor_total_pedido");
            String pedidoPronto = request.getParameter("pedido_pronto");
            
            String pedidoFeito = request.getParameter("pedido_feito");
            
            try {
                pedido.setId( Integer.parseInt(id));
                
                pedido.setId_mesa(Integer.parseInt(id_mesa));
                pedido.setPedidoPronto(Boolean.parseBoolean(pedidoPronto));
                pedido.setPedidoFeito(Boolean.parseBoolean(pedidoFeito));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("EXCLUIR")){
            String id = request.getParameter("id");
            
            String id_mesa = request.getParameter("id_mesa");
            String valorTotalPedido = request.getParameter("valor_total_pedido");
            String pedidoPronto = request.getParameter("pedido_pronto");
            
            String pedidoFeito = request.getParameter("pedido_feito");

            
            try {
                pedido.setId( Integer.parseInt(id));
                pedido.setId_mesa(Integer.parseInt(id_mesa));
                pedido.setPedidoPronto(Boolean.parseBoolean(pedidoPronto));
                pedido.setPedidoFeito(Boolean.parseBoolean(pedidoFeito));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
     return pedido;   
    }
    
    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(resultado.getMsg() != null){
            response.getWriter().write(resultado.getMsg());
            request.setAttribute("Mensagem", resultado.getMsg());
        
        }else{
            request.setAttribute("listaPedidos", resultado.getEntidades());

        }
        
        

        request.getRequestDispatcher("pedidoConfirmar.jsp").forward(request, response);
    

    }
    
}
