/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Produto;
import com.aplicacaomodelo.web.interfaces.IViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class ProdutoVH implements IViewHelper{
    
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");
        Produto produto = new Produto();
        
        if (operacao.equals("SALVAR")){
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String valor = request.getParameter("valor");
            
            String categoria = request.getParameter("categoria");

            
            try {
                produto.setNome(nome);
                produto.setDescricao(descricao);
                
                produto.setValor(Double.parseDouble(valor));
                produto.setCategoria(categoria);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("CONSULTAR")){
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String valor = request.getParameter("valor"); //OLHA QUI EMMM
            
            String categoria = request.getParameter("categoria");

            
            try {
                produto.setNome(nome);
                produto.setDescricao(descricao);
                produto.setCategoria(categoria);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("ALTERAR")){
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String valor = request.getParameter("valor"); //OLHA QUI EMMM
            
            String categoria = request.getParameter("categoria");

            
            try {
                produto.setId( Integer.parseInt(id));
                produto.setNome(nome);
                produto.setValor(Double.parseDouble(valor));
                produto.setDescricao(descricao);
                produto.setCategoria(categoria);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("EXCLUIR")){
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String valor = request.getParameter("valor"); //OLHA QUI EMMM
            
            String categoria = request.getParameter("categoria");

            
            try {
                produto.setId( Integer.parseInt(id));
                produto.setNome(nome);
                produto.setDescricao(descricao);
                produto.setCategoria(categoria);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
     return produto;   
    }
    
    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(resultado.getMsg() != null){
            response.getWriter().write(resultado.getMsg());
            request.setAttribute("Mensagem", resultado.getMsg());
        
        }else{
            request.setAttribute("listaProdutos", resultado.getEntidades());

        }
        
        String operacao =request.getParameter("operacao");

        String direcionadorTela = request.getParameter("direcionadorTela");
        
        if(operacao.equals("SALVAR")|| operacao.equals("ALTERAR") || operacao.equals("EXCLUIR")){
            request.getRequestDispatcher("admProdutos.jsp").forward(request, response);
        
        } else if (operacao.equals("CONSULTAR")){
        
            if(direcionadorTela.equals("cardapio")){
        
                request.getRequestDispatcher("pedidoCardapio.jsp").forward(request, response);

            }else if(direcionadorTela.equals("adm") || operacao.equals("SALVAR")  ){
        
            request.getRequestDispatcher("admProdutos.jsp").forward(request, response);

            
            }
        
        }
        
        
        
        


    }
    
}
