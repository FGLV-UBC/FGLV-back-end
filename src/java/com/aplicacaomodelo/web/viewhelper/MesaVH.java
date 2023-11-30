/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Mesa;
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
public class MesaVH implements IViewHelper{
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");
        Mesa mesa = new Mesa();
        
        if (operacao.equals("SALVAR")){
            String id_garcom = request.getParameter("id_garcom");
            String qrcode = request.getParameter("qrcode");
            String valorTotal = request.getParameter("valor_total");
            String mesaPaga = request.getParameter("mesa_paga");

            try {
                
                mesa.setId_garcom(Integer.parseInt(id_garcom));
                mesa.setQrcode(qrcode);
                mesa.setValorTotal(Double.parseDouble(valorTotal));
                mesa.setMesaPaga(Boolean.parseBoolean(mesaPaga));
                
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        
        if (operacao.equals("CONSULTAR")){
            String id_garcom = request.getParameter("id_garcom");
            String qrcode = request.getParameter("qrcode");
            String valorTotal = request.getParameter("valor_total");
            String mesaPaga = request.getParameter("mesa_paga");

            
            try {
                mesa.setId_garcom(Integer.parseInt(id_garcom));
                mesa.setQrcode(qrcode);
                mesa.setValorTotal(Double.parseDouble(valorTotal));
                mesa.setMesaPaga(Boolean.parseBoolean(mesaPaga));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("ALTERAR")){
            String id = request.getParameter("id");
            
            String id_garcom = request.getParameter("id_garcom");
            String qrcode = request.getParameter("qrcode");
            String valorTotal = request.getParameter("valor_total");
            String mesaPaga = request.getParameter("mesa_paga");

            
            try {
                mesa.setId(Integer.parseInt(id));
                mesa.setId_garcom(Integer.parseInt(id_garcom));
                mesa.setQrcode(qrcode);
                mesa.setValorTotal(Double.parseDouble(valorTotal));
                mesa.setMesaPaga(Boolean.parseBoolean(mesaPaga));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
        if (operacao.equals("EXCLUIR")){
            String id = request.getParameter("id");
            
            String id_garcom = request.getParameter("id_garcom");
            String qrcode = request.getParameter("qrcode");
            String valorTotal = request.getParameter("valor_total");
            String mesaPaga = request.getParameter("mesa_paga");

            
            try {
                mesa.setId(Integer.parseInt(id));

                mesa.setId_garcom(Integer.parseInt(id_garcom));
                mesa.setQrcode(qrcode);
                mesa.setValorTotal(Double.parseDouble(valorTotal));
                mesa.setMesaPaga(Boolean.parseBoolean(mesaPaga));
            } catch (NumberFormatException e) {
                // Handle the error or provide user feedback for invalid input
                e.printStackTrace(); // For debugging purposes
            }
        }
     return mesa;   
    }
    
    
    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(resultado.getMsg() != null){
            response.getWriter().write(resultado.getMsg());
            request.setAttribute("Mensagem", resultado.getMsg());
        
        }else{
            request.setAttribute("listaMesa", resultado.getEntidades());

        }
        
        

        request.getRequestDispatcher("mesaGarcom.jsp").forward(request, response);
    

    }
    
}
