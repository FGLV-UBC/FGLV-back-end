/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Garcom;
import com.aplicacaomodelo.web.interfaces.IViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class GarcomVH implements IViewHelper {
    
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");
        Garcom garcom = new Garcom();
        
        if (operacao.equals("SALVAR")) {
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            try {
                garcom.setNome(nome);
                garcom.setLogin(login);
                garcom.setSenha(senha);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("CONSULTAR")) {
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            try {
                garcom.setNome(nome);
                garcom.setLogin(login);
                garcom.setSenha(senha);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("VISUALIZAR")) {
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            try {
                garcom.setNome(nome);
                garcom.setLogin(login);
                garcom.setSenha(senha);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("ALTERAR")) {
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            
            
            try {
                garcom.setId( Integer.parseInt(id));
                garcom.setNome(nome);
                garcom.setLogin(login);
                garcom.setSenha(senha);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("EXCLUIR")) {
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            
            
            try {
                garcom.setId( Integer.parseInt(id));
                garcom.setNome(nome);
                garcom.setLogin(login);
                garcom.setSenha(senha);
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        
        
        
        return garcom;

    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(resultado.getMsg() != null){
            response.getWriter().write(resultado.getMsg());
            request.setAttribute("Mensagem", resultado.getMsg());
        
        }else{
            request.setAttribute("listaGarcons", resultado.getEntidades());

        }
        
        

        request.getRequestDispatcher("admHome.jsp").forward(request, response);
    }
    
}